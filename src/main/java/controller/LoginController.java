package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import common.Util;
import dto.MemberDTO;
import emailTest.SendEmail;
import emailTest.emailUtil;
import service.MemberService;

@Controller
public class LoginController {
	private String path;
	
	public LoginController() {
	}

	private MemberService mservice;

	public void setMservice(MemberService mservice) {
		this.mservice = mservice;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@RequestMapping("/loginPro.do")    //�α����������� �̵�
	public String loginPro() {
		return "loginView";
	}
	
	@RequestMapping("/idcheck.do")  //idcheck
	@ResponseBody
	public boolean idChk(@ModelAttribute MemberDTO mdto) {
		String mv_id=mdto.getMem_id();
		boolean chk=false;
		int loginId=mservice.memIdChkPro(mv_id);
		System.out.println("loginId= "+ loginId);
		if(loginId==1) {
			chk=true;
		}else {
			chk=false;
		}
		System.out.println("idchk chk= "+ chk);
		return chk;
	}
	
	@RequestMapping("/login.do") //�α���
	@ResponseBody
	public int LoginChk(@ModelAttribute MemberDTO mdto, HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView();
		String mv_id = mdto.getMem_id();
		mdto.setMem_pw(Util.getHash(mdto.getMem_pw(), "MD5"));
		System.out.println("mv_id : " + mv_id);
		System.out.println("===============================");

		String namesession=mservice.nameSession(mv_id);
		String picsession=mservice.picSession(mv_id);
		System.out.println("namesession="+namesession);
		model.addAttribute("mem_id", mv_id);
		int chk = mservice.login(mdto);
		
		System.out.println("chk= " + chk);
		if (chk == 1) {
			session.setAttribute("id", mv_id);
			session.setAttribute("name", namesession);
			session.setAttribute("pic", picsession);
			System.out.println("session id=" + session.getAttribute("id"));
			System.out.println("session name=" + session.getAttribute("name"));
		} else
			System.out.println("session=" + session.getAttribute("id"));

		return chk;
	}

	@RequestMapping("/mainPro.do")    //main�������� �̵�
	public String mainPro() {
		return "redirect:/main.do";
	}
	
	@RequestMapping("/logout.do")    //�α׾ƿ�
	public String logOut(HttpSession session) {
		System.out.println("logout start");
		session.invalidate();
		return "redirect:/main.do";
	}

	@RequestMapping("/signUp.do")  //ȸ���������� �̵�
	public String addUserForm() {
		return "signup_view";
	}


	@RequestMapping("/register.do") //ȸ������ó��
	public @ResponseBody ModelAndView signUp(MemberDTO mdto, HttpServletRequest req) throws IllegalStateException, IOException {
		System.out.println("signup ��Ʈ�ѷ� ��!!!!!!!!");
		
		ModelAndView mav=new ModelAndView();
		
		MultipartFile files = mdto.getUpfile();
		System.out.println("files= "+files);
		
		if (files != null) {
	            String fileName = files.getOriginalFilename();
	            System.out.println("fileName= "+fileName);
	            UUID random = UUID.randomUUID();   
	            path= "c:/temp/userImg" + File.separator;
	            String saveDirectory = path;
	            System.out.println("path= "+path);
	            File fe = new File(saveDirectory);
	            if (!fe.exists()) {
	               fe.mkdir();
	            }
	            File ff = new File(saveDirectory, random + "_" + fileName);
	            System.out.println("ff= " + ff);
	            try {
	            	   if (fileName != "") {
	               FileCopyUtils.copy(files.getInputStream(), new FileOutputStream(ff));
	            	}           
	            } catch (FileNotFoundException e) {
	               e.printStackTrace();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	            System.out.println(random + "_" + fileName);
	            if (mdto.getUpfile() != null) {
	            String mem_pic=(mdto.getUpfile()+ "," + random + "_" + fileName);
	               mav.addObject("mem_pic", mem_pic);
	            } else {
	               String mem_pic=(random + "_" + fileName);
	               mav.addObject("mem_pic", mem_pic);
	            }
	            System.out.println("fileName=====>" + fileName);
	            if (fileName != "") {
	                mdto.setMem_pic(random + "_" + fileName);
				}
	            System.out.println("getupfile=" + mdto.getUpfile());
		}
		System.out.println("�μ�Ʈ�Ϸ�!!!!!!!!!!!!!!!");
		mdto.setMem_pw(Util.getHash(mdto.getMem_pw(), "MD5"));
		
		String code = emailUtil.generate_accessCode(); // �����ڵ尪 ���� 
		
		try {
			SendEmail.sendMail(mdto.getMem_mail(), code); // ������ȣ �߼�
		} catch (Exception e) {
			e.printStackTrace();
		}
		mdto.setMem_code(code);
		mservice.signUp(mdto);
		System.out.println("signup �ȵǴ��� �Ǵ���");
		System.out.println(mav.toString());
		mav.setViewName("redirect:/main.do");
		return mav;
	}// ȸ������
	
	@RequestMapping("/emailChk.do") //eamil ������ȣüũ
	public ModelAndView emailChkPro(MemberDTO mdto) {
		ModelAndView mav=new ModelAndView();
		int chk=mservice.emailcodechk(mdto);
		if(chk==1) {
	         mav.addObject("msg", "�����Ǿ����ϴ�.");
		}else {
	         mav.addObject("msg", "������ȣ�� Ȯ�����ּ���.");
		}
		mav.setViewName("loginView");
		return mav;
	}
	
	/*//eamil���� �߰�
	@RequestMapping("/emailAuth.do")
	public ModelAndView emailAuth(HttpServletResponse resp, HttpServletRequest req) {
		String email=req.getParameter("email");
		String authNum = "";
		authNum=RandomNum();
		
		sendEmail(email.toString(), authNum);
		
		ModelAndView mv= new Model
	}
	private void sendEmail(String email, String authNum) {
		String host= "smtp.gmail.com";// smtp����
		String subject = "NEGABOX ������ȣ����";
		String fromName = "�װ��ڽ� ������";
		String from="                           ";//������ ����
		String tol= email;
		
		String content="������ȣ [" + authNum + "]";
		
		Properties props=new Properties();
		//G-mail smtp ����
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.user", from);
		
	}*/
	

	@RequestMapping("/myPageShift.do")  //������������ �̵�
	public String myPageShift() {
		return "myPage";
	}
	
	@RequestMapping("/myPage.do")  //������������
	public ModelAndView myPage(@ModelAttribute MemberDTO mdto, HttpSession session) { 
		System.out.println("���������� ��Ʈ�ѷ� �Լ�!!!!");
		MemberDTO dto=mservice.memberData((String)session.getAttribute("id"));
		System.out.println("session���� "+(String)session.getAttribute("id"));
		System.out.println("dtoid= " + dto.getMem_id());
		System.out.println("dtoname= " + dto.getMem_name());
		System.out.println("dtophone= " + dto.getMem_phone());
		System.out.println("dtomail= " + dto.getMem_mail());
		System.out.println("dto pic= " + dto.getMem_pic());
		ModelAndView mav=new ModelAndView();
		System.out.println("dao ��������.tostring="+dto.toString());
		mav.addObject("mdto", dto);
		mav.setViewName("myPage");
		return mav;
	}// end myPage()
	
	@RequestMapping("/memlist.do")  // ȸ���������� �̵�
	public String Memlist(HttpSession session) {
		return "Member_update";	
	}
	
	@RequestMapping("/memUpdate.do")  // ȸ������
	@ResponseBody
	public String MemUpdate(@ModelAttribute MemberDTO mdto, HttpSession session) {
		ModelAndView mav=new ModelAndView();
		System.out.println("������Ʈ�ѷ� ��");
		String sessionId=(String)session.getAttribute("id");
		System.out.println("sessionId= "+sessionId);
		if(null != sessionId || !StringUtils.isEmpty(sessionId)) {
			System.out.println("sessionid�� ������");
			mdto.setMem_id(sessionId);
			mservice.update(mdto);
		System.out.println("������Ʈ�ѷ� ������");
		}
		return "redirect:/myPage.do";
	}

	
	@RequestMapping("/memDelete.do")  //ȸ��Ż��
	public String MemDelete(HttpSession session) {
		System.out.println("delete ��Ʈ�ѷ� �Լ�");
		String sessionId=(String)session.getAttribute("id");
		System.out.println("sessionId�� "+sessionId);
		mservice.delete(sessionId);
		session.invalidate();
		return "redirect:/main.do";
	}
	/*============================================*/
	
	@RequestMapping("/adminMemPro.do")
	public String adminmemList() {
		return "redirect:/admin_member.do";
	}
	
	@RequestMapping("/admin_member.do")
	public ModelAndView MemAllList(Model model) {
		ModelAndView mav=new ModelAndView();
		List<MemberDTO> memberList = mservice.selectMember();
		System.out.println("selectmemberList��");
		mav.addObject("memberList", memberList);
		mav.setViewName("admin_member");
		return mav;
	}
}
