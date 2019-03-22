package emailTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String email = req.getParameter("email");
		
		String code = emailUtil.generate_accessCode(); // �����ڵ尪 ���� 
		
		try {
			SendEmail.sendMail(email, code); // ������ȣ �߼�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
