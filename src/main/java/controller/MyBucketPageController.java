package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//http://localhost:8090/mybucketlist/detail.do
@Controller
public class MyBucketPageController {
	@RequestMapping("/detail.do")
	public ModelAndView process(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession httpSession = request.getSession(true);
		/*httpSession.setAttribute("id", "asd123");*/
		mav.addObject("sessionId",httpSession.getAttribute("id"));
		mav.setViewName("bk_sub");
		return mav;
	}
	
/*	@RequestMapping("/detail.do")
	public ModelAndView myBucketListProcess(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session =request.getSession(true);
		
		mav.addObject("bucketlist",session.getAttribute("bucketlist"));
		
		mav.setViewName("bk_sub");
		
		return mav;
		
	}
	*/
	
	
}//end class


