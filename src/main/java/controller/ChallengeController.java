package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.BucketDTO;
import dto.Bucket_picDTO;
import dto.ChallengeDTO;
import dto.ChallengePageDTO;
import service.ChallengeService;
//http://localhost:8090/mybucketlist/Challenge.do


@Controller
public class ChallengeController {
	
	@Autowired
	private ChallengeService cservice;
	private ChallengePageDTO cpdto;
	private int currentPage;
	
	
	
	public ChallengeController() {
	}
	
	
	public ChallengeService getCservice() {
		return cservice;
	}

	public void setCservice(ChallengeService cservice) {
		this.cservice = cservice;
	}



	@RequestMapping("/challenge.do")
	public ModelAndView process(HttpServletRequest request, ChallengePageDTO cpdto) {
		ModelAndView mav = new ModelAndView();
		/*HttpSession httpSession = request.getSession(true);
		String sessionId = (String) httpSession.getAttribute("id");*/
		
		HttpSession session2 =  request.getSession();
		String mem_id = request.getParameter("mem_id");
		String sessionId=(String)session2.getAttribute("id");
		System.out.println("mem_id=========? " + request.getParameter("mem_id"));
		
		int totalRecord = 0;
		if (mem_id != null) {
			totalRecord = cservice.recordCountProcess(mem_id);
		}else {
			totalRecord = cservice.recordCountProcess(sessionId);
		}
		
		if(totalRecord>=1) {
			if(cpdto.getCurrentPage()==0) {
				currentPage=1;
			}else {
				currentPage=cpdto.getCurrentPage();
			}
			cpdto= new ChallengePageDTO(currentPage , totalRecord);
			mav.addObject("cpdto",cpdto);
		}
		
	/*	System.out.println(cpdto.getStartRow());
		System.out.println(cpdto.getEndRow());*/
		
		// String sessionId = getSession("id")
		HashMap<String, Object> map = new HashMap<>();
		 
		if (mem_id != null) {
			map.put("mem_id", mem_id);
		}else {
			map.put("mem_id", sessionId);
		}
		System.out.println("sessionId --?" +sessionId);
		
		map.put("startRow", cpdto.getStartRow());
		map.put("endRow", cpdto.getEndRow());
		
		List<ChallengeDTO> cList= cservice.challengeListprocess(map);
		List<BucketDTO> alist = new ArrayList<BucketDTO>();

		for (ChallengeDTO cdto : cList) {
			int bk_num = cdto.getBk_num();
			System.out.println("bk_num===========>" + bk_num);
			BucketDTO bdto = cservice.challengeBucketProcess(bk_num);
			String bpFile = bdto.getPic_dto().getBp_file();
			bdto.setBp_file(bpFile);
			alist.add(bdto);
		}
		
		mav.addObject("c_list", alist);
		mav.addObject("mem_id", mem_id);
		/*httpSession.setAttribute("id", "asd123");*/
		/*mav.setViewName("bk_sub");*/
		mav.setViewName("bk_sub");
		return mav;
	}
	
	   @RequestMapping("/challengeUpdate.do")
	   public String challengeUpateProcess(int bk_num, HttpServletRequest request) {
		    HttpSession session2 =  request.getSession();
			
			String sessionId=(String)session2.getAttribute("id");
		   
		  System.out.println("challengeUpdate Start !!!!"); 
	      System.out.println("sessionId===========> " + sessionId);
	      System.out.println("bk_num==========> " + bk_num);
	      
	      
	      
	      HashMap<String, Object> map = new HashMap<>();
	      map.put("bk_num", bk_num);
	      map.put("mem_id",sessionId);
	      
	      cservice.cUpdateProcess(map);
	      
	    /*  redirect:/challenge.do*/
	      
	      
	      return "redirect:/challenge.do";
	   }
	
	   @RequestMapping("/challengeDelete.do")
	   public String challengeDeleteProcess(int bk_num, HttpServletRequest request) {
		HttpSession session2 = request.getSession();

		String sessionId = (String) session2.getAttribute("id");
		
		System.out.println("sessionId->" + sessionId);
		System.out.println("bk_num-> " + bk_num);

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("bk_num", bk_num);
		map.put("mem_id", sessionId);

		cservice.cDeleteProcess(map);

		return "redirect:/challenge.do";
		   
	   }
	   
	   @RequestMapping("/challengeReciewDelete.do")
	   public String challengeReviewDeleteProcess(int bk_num,HttpServletRequest request) {
			HttpSession session2 = request.getSession();

			String sessionId = (String) session2.getAttribute("id");
		
			
			HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bk_num", bk_num);
		map.put("mem_id", sessionId);
		cservice.cReDelProcess(map);

		return "redirect:/challengeSuccess.do";
	   }
	   
	   
	   @RequestMapping("/challengeSuccess.do")
		public ModelAndView successProcess(HttpServletRequest request ,ChallengePageDTO cpdto) {
		    ModelAndView mav = new ModelAndView();
			HttpSession session2 = request.getSession();

			String sessionId = (String) session2.getAttribute("id");
		    
			String mem_id = request.getParameter("mem_id");
			int totalRecord = 0;
			
			if (mem_id != null) {
				totalRecord = cservice.successRecordCntProcess(mem_id);
			}else {
				totalRecord = cservice.successRecordCntProcess(sessionId);
			}
			
			if(totalRecord>=1) {
				if(cpdto.getCurrentPage()==0)
					currentPage=1;
				else
					currentPage=cpdto.getCurrentPage();
				cpdto= new ChallengePageDTO(currentPage , totalRecord);
				mav.addObject("cpdto",cpdto);
			}
			
			System.out.println(cpdto.getStartRow());
			System.out.println(cpdto.getEndRow());
			
			// String sessionId = getSession("id");
			HashMap<String, Object> map = new HashMap<>();
			 
			if (mem_id != null) {
				map.put("mem_id", mem_id);
			}else {
				map.put("mem_id", sessionId);
			}
			map.put("startRow", cpdto.getStartRow());
			map.put("endRow", cpdto.getEndRow());
			
			List<ChallengeDTO> cList= cservice.successListProcess(map);
			List<BucketDTO> alist = new ArrayList<BucketDTO>();

			for (ChallengeDTO cdto : cList) {
				int bk_num = cdto.getBk_num();
				System.out.println("bk_num===========>" + bk_num);
				BucketDTO bdto = cservice.challengeBucketProcess(bk_num);
				String bpFile = bdto.getPic_dto().getBp_file();
				System.out.println(bpFile);
				bdto.setBp_file(bpFile);
				alist.add(bdto);
			}
			
			mav.addObject("c_list", alist);

			/*httpSession.setAttribute("id", "asd123");*/
				mav.addObject("mem_id", mem_id);
			/*mav.setViewName("bk_sub");*/
			mav.setViewName("challengeSuccess");
			return mav;
		}

	
	
}//end class


