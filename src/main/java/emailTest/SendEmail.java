package emailTest;

import java.util.HashMap;

public class SendEmail {
	// ��� ���ϴ� �ڵ�. �̸��� ���� ����
	public static void sendMail(String email, String access_cd)throws Exception{
		HashMap<String, Object> arg = new HashMap<String, Object>();
		StringBuffer mailHtml = new StringBuffer();// StringBuffer��ü mailHtml����
		mailHtml.append("<html>");
		mailHtml.append("<body\">");
		mailHtml.append("<div style=\"width:100%;background:#f3f3f3;padding-top:10%;padding-bottom:10%; \">");
		mailHtml.append("<div  style=\"width:70%; margin-left:5%;padding:10%;border: 1px solid #ccc;background:#fff; \">");
		mailHtml.append("<span style=\"font-weight:bold;font-size: 1.2em\">ȸ������ �̸��� ����</span><br><hr style=\"border-width: 2px;\">");
		mailHtml.append("<div  style=\"margin-top:5%;\">");
		mailHtml.append("<span style=\"font-size: 1.1em;color: #222\">�ȳ��ϼ���. myBucket ��ǥ�� ����Դϴ�</span>.<br>");
		mailHtml.append("<span style=\"color:#ff9d41;margin-top:15px;\">������ȣ�� �����߽��ϴ�.");
		mailHtml.append("</div>");
		mailHtml.append("<div style=\"margin-top:30px;border-bottom: 1px solid #bbb;border-top: 1px solid #bbb;padding:5%;background: #eee\" >");
		mailHtml.append("<div>��  ������ȣ : <span style=\"font-weight: bold;color : #3d8aea;\">"+access_cd+"</span></div>");
		mailHtml.append("</div>");
		mailHtml.append("<div style=\"margin-top:30px;\"><span style=\"font-size: 1em;color:black\">�ڼ��� ������ myBucket �����Ϳ��� �����Ͻñ� �ٶ��ϴ�.<br>�����մϴ�.</span><br></div>");
		mailHtml.append("</div>");
		mailHtml.append("</div>");
		mailHtml.append("</body>");
		mailHtml.append("</html>");
		mailHtml.append("</html> \n");

		JAVA2MailVO mailvo = new JAVA2MailVO();
		mailvo.FROM = "duny@myBucket.com"; //�߽���
		mailvo.TO = email; //������
		mailvo.TITLE = "[myBucket]" + email + "���� �̸��� �����ڵ��Դϴ�."; //��������
		mailvo.BODY = mailHtml.toString(); //����

		JAVA2Mail mail = new JAVA2Mail();
		mail.sendMail(mailvo);
	}
}
