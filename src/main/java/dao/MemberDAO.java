package dao;

import java.util.List;

import dto.AdminDTO;
import dto.MemberDTO;

public interface MemberDAO {
   public int login(MemberDTO mdto); //로그인
   public String MemNameSession(String mem_id); //네임세션
   public String MemPicSession(String mem_id); //사진 세션
   public void signup(MemberDTO mdto); // 회원가입
   public int memIdChk(String mem_id);// id중복체크
   public MemberDTO MemberPage(String mem_id); //회원정보
   public void memUpdate(MemberDTO mdto);  // 회원수정
   public void memDelete(String mem_id); //회원삭제
   public List<MemberDTO> MemSelectAll();//전체회원 검색
   public int adminchk(AdminDTO adto); //admin chk 
   public int adminIdChk(String ad_id); //admin idchk
   public void picUpdate(String mem_id); //프사 
   public String MemIdSearch(MemberDTO mdto); //id 찾기
} //dd