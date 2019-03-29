package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
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
import dto.AdminDTO;
import dto.CodeDTO;
import dto.MemberDTO;
import emailTest.SendEmail;
import emailTest.emailUtil;
import service.MemberService;

@Controller
public class LoginController {
	private String path;
	private String prevUrl;
	public LoginController() {
	}

	private MemberService mservice;

	public void setMservice(MemberService mservice) {
		this.mservice = mservice;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@RequestMapping("/loginPro.do") // 로그인페이지로 이동
	public String loginPro(String prevUrl) {
		this.prevUrl = prevUrl;
		System.out.println("url============> " + this.prevUrl);
		return "loginView";
	}

	@RequestMapping("/idcheck.do") // idcheck
	@ResponseBody
	public boolean idChk(@ModelAttribute MemberDTO mdto) {
		String mv_id = mdto.getMem_id();
		boolean chk = false;
		int adchk = mservice.adminIdChkPro(mv_id);
		if (adchk == 1) {
			chk = true; // id가 이미 존재
		} else if (adchk == 0) {
			int loginId = mservice.memIdChkPro(mv_id);
			System.out.println("loginId= " + loginId);
			if (loginId == 1) {
				chk = true; // id가 이미 존재
			} else {
				chk = false; // id가 존재하지않음
			}
		}
		System.out.println("idchk chk= " + chk);
		return chk;
	}

	@RequestMapping("/login.do") // 로그인
	@ResponseBody
	public JSONObject LoginChk(@ModelAttribute MemberDTO mdto, AdminDTO adto, HttpSession session, Model model,
			String returnUrl) {
		String Url = null;
		System.out.println("===============================");
		adto.setAd_id(mdto.getMem_id());
		adto.setAd_pw(mdto.getMem_pw());
		String mv_id=adto.getAd_id();
		String mv_pw=adto.getAd_pw();
		System.out.println("mv_id = "+mv_id);
		System.out.println("mv_pw = "+mv_pw);
		int chk=0;
		chk = mservice.adminid(adto);
		System.out.println("adminchk="+chk);
		if (chk == 1) { // admin 로그인이 됨
			System.out.println("adminchk들어감");
			session.setAttribute("id", mv_id);
			session.setAttribute("name", "관리자");
			session.setMaxInactiveInterval(24 * 60 * 60);
			if(returnUrl !="") {
				Url = returnUrl;
			} else {
				Url = "main.do";
			}
		} else {
			model.addAttribute("mem_id", mv_id);
			mv_id = mdto.getMem_id();
			String namesession = mservice.nameSession(mv_id);
			String picsession = mservice.picSession(mv_id);
			mdto.setMem_pw(Util.getHash(mdto.getMem_pw(), "MD5"));
			chk = mservice.login(mdto);
			System.out.println("loginchk="+chk);

			if (chk == 1) {
				System.out.println("chk=" +chk);
				session.setAttribute("id", mv_id);
				session.setAttribute("name", namesession);
				session.setAttribute("pic", picsession);
				// 로그인 세션은 30분뒤 자동으로 해제됨.
				session.setMaxInactiveInterval(24 * 60 * 60);
				System.out.println("session값 저장"+ session.getAttribute("id"));
				if (returnUrl != "") {
					Url = returnUrl;
				} else {
					Url = "main.do";
				}
			}
		}
		System.out.println("else,if 끝나고 chk="+chk);
		JSONObject obj = new JSONObject();
		obj.put("chk", chk);
		obj.put("Url", Url);
		System.out.println("jsonobject");
		return obj;
	}

	@RequestMapping("/mainPro.do") // main페이지로 이동
	public String mainPro() {
		return "redirect:/main.do";
	}

	@RequestMapping("/logout.do") // 로그아웃
	public String logOut(HttpSession session) {
		System.out.println("logout start");
		session.invalidate();
		return "redirect:/main.do";
	}

	@RequestMapping("/signUp.do") // 회원가입으로 이동
	public String addUserForm() {
		return "signup_view";
	}

	@RequestMapping("/register.do") // 회원가입처리
	@ResponseBody
	public ModelAndView signUp(MemberDTO mdto, HttpServletRequest req) throws IllegalStateException, IOException {
		System.out.println("signup 컨트롤러 들어감!!!!!!!!");

		ModelAndView mav = new ModelAndView();

		MultipartFile files = mdto.getUpfile();
		System.out.println("files= " + files);

		if (files != null) {
			String fileName = files.getOriginalFilename();
			System.out.println("fileName= " + fileName);
			UUID random = UUID.randomUUID();
			path = "c:/temp/userImg" + File.separator;
			String saveDirectory = path;
			System.out.println("path= " + path);
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
				String mem_pic = (mdto.getUpfile() + "," + random + "_" + fileName);
				mav.addObject("mem_pic", mem_pic);
			} else {
				String mem_pic = (random + "_" + fileName);
				mav.addObject("mem_pic", mem_pic);
			}
			System.out.println("fileName=====>" + fileName);
			if (fileName != "") {
				mdto.setMem_pic(random + "_" + fileName);
			}
			System.out.println("getupfile=" + mdto.getUpfile());
		}
		mdto.setMem_pw(Util.getHash(mdto.getMem_pw(), "MD5"));

		mservice.signUp(mdto);
		System.out.println(mav.toString());
		mav.setViewName("redirect:/main.do");
		return mav;
	}// 회원가입

	@RequestMapping("/codeSend.do") // eamil 인증번호보내기
	@ResponseBody
	public String emailChkPro(MemberDTO mdto, CodeDTO codto) {
		String code = emailUtil.generate_accessCode(); // 인증코드값 생성
		try {
			SendEmail.sendMail(codto.getTemp_id(), code); // 인증번호 발송
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return code;
	}

	@RequestMapping("/myPageShift.do") // 마이페이지로 이동
	public String myPageShift(MemberDTO mdto, AdminDTO adto) {
		int chk=mservice.adminIdChkPro(mdto.getMem_id());
		if(chk==1) {
			
		}
		return "myPage";
	}

	@RequestMapping("/myPage.do") // 마이페이지값
	public ModelAndView myPage(@ModelAttribute MemberDTO mdto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
			
		System.out.println("마이페이지 컨트롤러 입성!!!!");
		MemberDTO dto = mservice.memberData((String) session.getAttribute("id"));
		System.out.println("session값은 " + (String) session.getAttribute("id"));
		System.out.println("dtoid= " + dto.getMem_id());
		System.out.println("dtoname= " + dto.getMem_name());
		System.out.println("dtophone= " + dto.getMem_phone());
		System.out.println("dtomail= " + dto.getMem_mail());
		System.out.println("dto pic= " + dto.getMem_pic());
		System.out.println("dao 지나간거.tostring=" + dto.toString());
		mav.addObject("mdto", dto);
		mav.setViewName("myPage");
		return mav;
		
	}// end myPage()

	@RequestMapping("/picUpdate.do")  //프로필 사진 수정 
	@ResponseBody
	public void MemPicUpdate(MemberDTO mdto, MultipartFile picfile) {
		ModelAndView mav = new ModelAndView();
		String mv_pic=mdto.getMem_pic();
		String path="C:\\temp\\userImg";
		if(mv_pic!=null) {
			
		}else {
			MultipartFile files = mdto.getUpfile();
			System.out.println("files= " + files);

			if (files != null) {
				String fileName = files.getOriginalFilename();
				System.out.println("fileName= " + fileName);
				UUID random = UUID.randomUUID();
				path = "c:/temp/userImg" + File.separator;
				String saveDirectory = path;
				System.out.println("path= " + path);
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
					String mem_pic = (mdto.getUpfile() + "," + random + "_" + fileName);
					mav.addObject("mem_pic", mem_pic);
				} else {
					String mem_pic = (random + "_" + fileName);
					mav.addObject("mem_pic", mem_pic);
				}
				System.out.println("fileName=====>" + fileName);
				if (fileName != "") {
					mdto.setMem_pic(random + "_" + fileName);
				}
				System.out.println("getupfile=" + mdto.getUpfile());
			}
		}
		
		mservice.picUptPro(mdto.getMem_id());
	}
	
	@RequestMapping("/memlist.do") // 회원수정으로 이동
	public String Memlist(HttpSession session) {
		return "mem_update";
	}

/*	@RequestMapping("/picUpdate.do")
	@ResponseBody
	public String PicUpdate(MemberDTO mdto, HttpServletRequest request) {
		System.out.println("picupdate컨트롤러");
		String mv_pic=mdto.getMem_pic();
		String formPic=request.getParameter("name");
				
		String path="C:\\temp\\userImg";
		String fullPath=path+mv_pic;
		if(formPic !=null) {
			
		}
		return null;
	}*/
	
	@RequestMapping("/memUpdate.do") // 회원수정
	@ResponseBody
	public String MemUpdate(@ModelAttribute MemberDTO mdto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		System.out.println("수정컨트롤러 들어감");
		String sessionId = (String) session.getAttribute("id");
		System.out.println("sessionId= " + sessionId);
		if (null != sessionId || !StringUtils.isEmpty(sessionId)) {
			System.out.println("sessionid가 있으면");
			mdto.setMem_id(sessionId);
			mservice.update(mdto);
			System.out.println("수정컨트롤러 끝나감");
		}
		
		MultipartFile files = mdto.getUpfile();
		
		return "redirect:/myPage.do";
	}
	@RequestMapping("/AdminMemDelete.do") // 회원탈퇴
	public void AdminMemDelete(MemberDTO mdto) {
		mservice.delete(mdto.getMem_id());
	}
	@RequestMapping("/memDelete.do") // 회원탈퇴
	public String MemDelete(HttpSession session, MemberDTO mdto) {
		
		System.out.println("delete 컨트롤러 입성");
		String sessionId = (String) session.getAttribute("id");
		System.out.println("sessionId는 " + sessionId);
		String mv_pic=mdto.getMem_pic();
		String path="C:\\temp\\userImg";
		if(mv_pic!=null) {
			String fullPath=path+mv_pic;
			File file=new File(fullPath);
			file.delete();
		}
		mservice.delete(sessionId);
		
		session.invalidate();
		return "redirect:/main.do";
	}
	/* ============================================ */

	@RequestMapping("/adminMemPro.do")
	public String adminmemList() {
		return "redirect:/admin_member.do";
	}

	@RequestMapping("/admin_member.do")
	public ModelAndView MemAllList(Model model) {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> memberList = mservice.selectMember();
		System.out.println("selectmemberList들어감");
		mav.addObject("memberList", memberList);
		mav.setViewName("admin_member");
		return mav;
	}
	
	@RequestMapping("/pwdcheck.do")
	@ResponseBody
	public int pwdCheck(MemberDTO mdto, HttpSession session) {
		int chk=0;
		if(mdto.getMem_pw()!=null) {
			mdto.setMem_pw(Util.getHash(mdto.getMem_pw(), "MD5"));
			mdto.setMem_id((String)session.getAttribute("id"));
			chk=mservice.login(mdto);
		}
		return chk;  //chk==1 이면 pwdchk 통과 , 0이면 pwdchk 통과실패
	}
	
	//admin인지 아닌지 확인
	@RequestMapping("/adminidchk.do")
	public int AdminChkId(HttpSession session) {
		int chk=-1;
		System.out.println("ajax 들어감");
		if(session.getAttribute("id")!=null) 
			chk=mservice.adminIdChkPro((String)session.getAttribute("id"));
		System.out.println("adminchk chk값은"+chk);
		return chk;
	}
	
	
}
