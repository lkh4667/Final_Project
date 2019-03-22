package service;


import java.util.List;

import dto.MemberDTO;

public interface MemberService {
   public int login(MemberDTO mdto); //로그인 처리
   public void signUp(MemberDTO mdto); //회원가입
   public String nameSession(String mem_id); //name 세션
   public String picSession(String mem_id); //pic세션
   public int memIdChkPro(String mem_id);  //id조회
   public MemberDTO memberData(String mem_id); //회원정보
   public void update(MemberDTO mdto); //회원 수정
   public void delete(String mem_id);//회원삭제
   public List<MemberDTO> selectMember();//회원 전체 조회
   public int emailcodechk(MemberDTO mdto);//이메일 체크
}