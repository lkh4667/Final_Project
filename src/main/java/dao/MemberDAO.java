package dao;

import java.util.List;

import dto.MemberDTO;

public interface MemberDAO {
   public int login(MemberDTO mdto); //로그인 처리
   public String MemNameSession(String mem_id); //이름세션
   public String MemPicSession(String mem_id); //사진세션
   public void signup(MemberDTO mdto); // 회원가입
   public int memIdChk(String mem_id);// idcheck
   public MemberDTO MemberPage(String mem_id); //회원조회
   public void memUpdate(MemberDTO mdto);  // 회원수정
   public void memDelete(String mem_id); //회원탈퇴
   public List<MemberDTO> MemSelectAll();/* 회원전체 조회*/
   public int emailchk(MemberDTO mdto);//이메일 체크
   
} //dd