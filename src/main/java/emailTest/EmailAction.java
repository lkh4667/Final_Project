package emailTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String email = req.getParameter("email");
		
		String code = emailUtil.generate_accessCode(); // 인증코드값 생성 
		
		try {
			SendEmail.sendMail(email, code); // 인증번호 발송
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
