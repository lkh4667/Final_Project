package interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      // �α��� �Ǿ��ִ� �������� �Ǵ��ؼ� ���ͼ�Ʈ ó�� ���־����.
      // �α��� �Ǿ��������� �α׾ƿ�
      String uri = request.getRequestURI();
      // uri : /myinter/noticeList.do
      uri = uri.substring(uri.lastIndexOf("/") + 1);
      System.out.println("uri : " + uri);

      // noticeList.do�� ȸ���� ���� �����ȴ�.
      HttpSession session = request.getSession();
      // login���°� �ƴϸ� (=ȸ���� �ƴϸ�)
      if (session.getAttribute("id") == null) {
         response.sendRedirect("loginPro.do?returnUrl=" + uri);
         // �α��� �����ϸ� returnUrl ��η� �ٽ� ���ƿ��� �����ؾ��Ѵ�.
         return false;
      } else {
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