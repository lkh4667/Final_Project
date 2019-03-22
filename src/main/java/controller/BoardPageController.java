package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.PageDTO;
import dto.ReplyDTO;
import dto.ReviewDTO;
import service.ReviewService;
import service.ReviewServiceImp;

//http://localhost:8090/mybucket/rv_list.do

@Controller
public class BoardPageController {

	private ReviewService service;
	private String path;
	private PageDTO pdto;
	private int currentPage;

	public BoardPageController() {
		
	}// end BoardPageController()

	public void setService(ReviewService service) {
		this.service = service;
	}// end setService

	public void setPath(String path) {
		this.path = path;
	}// end setPath

	public void setPdto(PageDTO pdto) {
		this.pdto = pdto;
	}// end setPdto()

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}// end setCurrentPage()

	@RequestMapping("/rv_list.do")
	public ModelAndView process(PageDTO pv) {
		ModelAndView mav = new ModelAndView();
	   int totalRecord = service.countProcess();
		
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0) {
				currentPage = 1;
			} else {
				currentPage = pv.getCurrentPage();
			}
			pdto = new PageDTO(currentPage, totalRecord);
			mav.addObject("pv",pdto);
			mav.addObject("aList", service.listProcess(pdto));
		}
		mav.setViewName("rv_list");
		return mav;
	}// end process()

	
	@RequestMapping("/rv_view.do")
	public ModelAndView viewProcess(int currentPage, int rv_num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("rv_list", service.replyListProcess(rv_num));
		mav.addObject("dto", service.contentProcess(rv_num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("rv_view");
		return mav;
	}// end viewProcess()
	

	@RequestMapping("/rv_write.do")
	public ModelAndView writeProcess(ReviewDTO dto) {
		ModelAndView mav = new ModelAndView();
		//mav.addObject("currentPage", pv.getCurrentPage());
		mav.addObject("dto",dto);
		mav.setViewName("rv_write");
		return mav;
}// end writeProcess()*/
		
	@RequestMapping(value = "/rv_writeEnd.do", method = {RequestMethod.POST, RequestMethod.GET})
	// 파일과 ip주소를 받아오려고 HttpServletRequest를 받아온다
	public String writeProMethod(ReviewDTO dto, HttpServletRequest request) {
		MultipartFile file = dto.getFilename();
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			
				// 중복파일명을 처리하기 위해 난수 발생
			UUID random = UUID.randomUUID();
			String root = request.getSession().getServletContext().getRealPath("/");
			
				// root+"temp/"
			String saveDirectory = root + "temp" + File.separator;
			
				// 실제 파일 경로 지정
			File fe = new File(saveDirectory);
			if (!fe.exists())
				fe.mkdir();
				File ff = new File(saveDirectory, random + "_" + fileName);
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setUpload(random + "_" + fileName);
		}
			dto.setIp(request.getRemoteAddr());
			
			service.insertProcess(dto);
		return "redirect:/rv_list.do";
		}// end writeProMethod()


	
	@RequestMapping("/rv_insert.do")
	public ModelAndView insertProcess(ReviewDTO dto) {
		ModelAndView mav = new ModelAndView();
		service.insertProcess(dto);
		mav.setViewName("redirect:/rv_list.do");
		return mav;
	}
	
	@RequestMapping("/replyInsetList.do")
	public @ResponseBody List<ReplyDTO> replyListPage(ReplyDTO rdto){
		// 글번호, 댓글 작성자, 댓글 내용 =>
		service.replyInsertProcess(rdto);
		int cnt = rdto.getRv_num();
		return service.replyListProcess(cnt);
	}//end replyListPage()
	
	@RequestMapping(value="/replyDelete.do", method=RequestMethod.GET )
	public @ResponseBody List<ReplyDTO> replyDeleteListPage(ReplyDTO rdto){		
	  System.out.println("replydelete start !!!");
	  System.out.println("rv_num()=========> " + rdto.getRv_num());
	  System.out.println("리스트 사이즈=================> " + service.replyListProcess(rdto.getRv_num()).size());
	   service.replyDeleteProcess(rdto);
		return service.replyListProcess(rdto.getRv_num());
	}// end replyDeleteListPage()
	
	@RequestMapping("/replyUpdate.do")
	public @ResponseBody List<ReplyDTO> replyUpdateListPage	(ReplyDTO rdto){
		  System.out.println("replyUpdate start !!!");
		  System.out.println("rv_num()=========> " + rdto.getRv_num());
		  System.out.println("리스트 사이즈=================> " + service.replyListProcess(rdto.getRv_num()).size());
		service.replyUpdateProcess(rdto);
		return service.replyListProcess(rdto.getRv_num());
		
	}
	
	
	
	// 수정하는 부분
		@RequestMapping(value = "/rv_update.do", method = RequestMethod.GET)
		public ModelAndView updateMethod(int rv_num, int currentPage) {
			ModelAndView mav = new ModelAndView();
			// BoardDTO bbto = service.updateSelectProcess(num);
			mav.addObject("dto", service.updateSelectProcess(rv_num));
			mav.addObject("currentPage", currentPage);
			mav.setViewName("rv_update");
			return mav;
		}// end updateMethod()

		// 수정한 뒤 수정버튼 누르는 부분
		@RequestMapping(value = "/rv_updateEnd.do", method = RequestMethod.POST)
		public ModelAndView updateProc(ReviewDTO dto, int currentPage, HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			service.updateProcess(dto, request);
			mav.addObject("currentPage", currentPage);
			mav.setViewName("redirect:/rv_list.do");
			return mav;

		}// end updateProc()
		
		@RequestMapping("/rv_delete.do")
		public ModelAndView deleteProcess(int rv_num, int currentPage, HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			service.deleteProcess(rv_num, request);

			/*// 삭제 후 조회했던 페이지로 돌아오기~
			PageDTO pv = new PageDTO(currentPage, service.countProcess());
			if (pv.getTotalPage() <= currentPage)
				mav.addObject("currentPage", pv.getTotalPage());
			else
				mav.addObject("currentPage", currentPage);*/

			mav.setViewName("redirect:/rv_list.do");
			return mav;
		}// end deleteProcess
	
}// end BoardPageController
