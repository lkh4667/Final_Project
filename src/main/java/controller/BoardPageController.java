package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.PageDTO;
import dto.ReplyDTO;
import dto.ReviewDTO;
import dto.Review_picDTO;
import service.ReviewService;

//http://localhost:8090/mybucket/rv_list.do

@Controller
public class BoardPageController {

	private ReviewService service;
	private String path;
	private PageDTO pdto;
	private int currentPage;
	private List<String> arr = new ArrayList<String>();
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
		System.out.println("rv_writeEnd start !!!!!!!!!!!");
		System.out.println("파일 리스트 !!");
		for (String str : arr) {
			System.out.println(str);
		}
		/*MultipartFile file = dto.getFilename();
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
		*/	
		service.insertProcess(dto);
		return "redirect:/rv_list.do";
		}// end writeProMethod()


	
	@RequestMapping("/rv_insert.do")
	public ModelAndView insertProcess(ReviewDTO dto) {
		ModelAndView mav = new ModelAndView();
		System.out.println("rv_insert start !!!!!!!!!!!");
		System.out.println("파일 리스트 !!");
		System.out.println(dto.getMem_id());
		System.out.println(dto.getRv_title());
		System.out.println(dto.getRv_content());
		System.out.println("rv_insert 리스트 사이즈==================> " + arr.size());

		service.insertProcess(dto);
		System.out.println("맥스 rv_num=========> " + dto.getRv_num());
		List<Review_picDTO> alist = new ArrayList<Review_picDTO>();
		if (arr != null) {
			for (String str : arr) {
				Review_picDTO pdto = new Review_picDTO();
				pdto.setRv_num(dto.getRv_num());
				pdto.setRp_file(str);
				alist.add(pdto);
			}
		}
		dto.setRv_pic_list(alist);
		service.rvPicInsertProcess(dto);
		arr.clear();
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
	
		 // 다중파일업로드
	    @RequestMapping(value = "/file_uploader_html5.do",
	                  method = RequestMethod.POST)
	    @ResponseBody
	    public String multiplePhotoUpload(HttpServletRequest request) {
	        // 파일정보
	        StringBuffer sb = new StringBuffer();
	        try {
	            // 파일명을 받는다 - 일반 원본파일명
	            String oldName = request.getHeader("file-name");
	            // 파일 기본경로 _ 상세경로
	            String filePath = "C:/temp/reviewImg/";
	            String saveName = sb.append(new SimpleDateFormat("yyyyMMddHHmmss")
	                          .format(System.currentTimeMillis()))
	                          .append(UUID.randomUUID().toString())
	                          .append(oldName.substring(oldName.lastIndexOf("."))).toString();
	            
	            arr.add(saveName);
	            System.out.println("파일 리스트 사이즈 =============> " + arr.size());

	            InputStream is = request.getInputStream();
	            OutputStream os = new FileOutputStream(filePath + saveName);
	            int numRead;
	            byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	            while ((numRead = is.read(b, 0, b.length)) != -1) {
	                os.write(b, 0, numRead);
	            }
	            os.flush();
	            os.close();
	            // 정보 출력
	            sb = new StringBuffer();
	            sb.append("&bNewLine=true")
	              .append("&sFileName=").append(oldName)
	              .append("&sFileURL=").append("/reviewImg/")
	        .append(saveName);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return sb.toString();
	    }
}// end BoardPageController
