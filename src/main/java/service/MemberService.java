package service;


import java.util.List;

import dto.AdminDTO;
import dto.MemberDTO;

public interface MemberService {
   public int login(MemberDTO mdto); //�α��� ó��
   public void signUp(MemberDTO mdto); //ȸ������
   public String nameSession(String mem_id); //name ����
   public String picSession(String mem_id); //pic����
   public int memIdChkPro(String mem_id);  //id��ȸ
   public MemberDTO memberData(String mem_id); //ȸ������
   public void update(MemberDTO mdto); //ȸ�� ����
   public void delete(String mem_id);//ȸ������
   public List<MemberDTO> selectMember();//ȸ�� ��ü ��ȸ
   public int adminid(AdminDTO adto); //admin login
   public int adminIdChkPro(String ad_id); //admin idchk
   public void picUptPro(String mem_id); //프사 변경
   public String idsearch(MemberDTO mdto);// id 찾기
}