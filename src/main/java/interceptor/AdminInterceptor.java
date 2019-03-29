package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import service.MemberService;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	private MemberService mservice;
	
	
	public AdminInterceptor() {
		
	}
	
	public void setMservice(MemberService mservice) {
		this.mservice = mservice;
	}
	
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      // 로그인 되어있는 상태인지 판단해서 인터셉트 처림 해주어야함.
      // 로그이 되어있을때는 로그아웃
      String uri = request.getRequestURI();

      uri = uri.substring(uri.lastIndexOf("/") + 1);

      System.out.println("uri : " + uri);

      // noticeList.do는 회원일 때만 제공된다.
      HttpSession session = request.getSession();
     
      String ad_id=null;
      if(session.getAttribute("id")==null) {
    	  ad_id=null;
      }else {
          ad_id=(String)session.getAttribute("id");
      }
      System.out.println("인터셉터 시작======");
      System.out.println("ad_id값은 "+ad_id);
      int chk=mservice.adminIdChkPro(ad_id);
      System.out.println("interceptor chk값은?"+ chk);
      // login상태가 아니면 (=회원이 아니면)
      if (chk==0) {
         response.sendRedirect("main.do?returnUrl=" + uri);
         // 로그인 성공하면 returnUrl 경로로 다시 돌아오게 구현해야한다.
         return false;
      }else{
    	  return true;
      }
   }

   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
   }

   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
   }
}// end class