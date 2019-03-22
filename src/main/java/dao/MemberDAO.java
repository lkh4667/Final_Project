package dao;

import java.util.List;

import dto.MemberDTO;

public interface MemberDAO {
   public int login(MemberDTO mdto); //�α��� ó��
   public String MemNameSession(String mem_id); //�̸�����
   public String MemPicSession(String mem_id); //��������
   public void signup(MemberDTO mdto); // ȸ������
   public int memIdChk(String mem_id);// idcheck
   public MemberDTO MemberPage(String mem_id); //ȸ����ȸ
   public void memUpdate(MemberDTO mdto);  // ȸ������
   public void memDelete(String mem_id); //ȸ��Ż��
   public List<MemberDTO> MemSelectAll();/* ȸ����ü ��ȸ*/
   public int emailchk(MemberDTO mdto);//�̸��� üũ
   
} //dd