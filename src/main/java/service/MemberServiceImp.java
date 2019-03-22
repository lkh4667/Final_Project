package service;


import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberServiceImp implements MemberService {

	private MemberDAO mdao;

	public MemberServiceImp() {
	}

	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}

	@Override
	public int login(MemberDTO mdto) {
		return mdao.login(mdto);
	}

	@Override
	public void signUp(MemberDTO mdto) {
		mdao.signup(mdto);
	}

	@Override
	public String nameSession(String mem_id) {
		return mdao.MemNameSession(mem_id);
	}

	@Override
	public String picSession(String mem_id) {
		return mdao.MemPicSession(mem_id);
	}

	@Override
	public int memIdChkPro(String mem_id) {
		return  mdao.memIdChk(mem_id);
	}

	@Override
	public MemberDTO memberData(String mem_id) {
		return mdao.MemberPage(mem_id);
	}

	@Override
	public void update(MemberDTO mdto) {
		mdao.memUpdate(mdto);
	}

	@Override
	public void delete(String mem_id) {
		mdao.memDelete(mem_id);
	}

	@Override
	public List<MemberDTO> selectMember() {
		return mdao.MemSelectAll();
	}

	@Override
	public int emailcodechk(MemberDTO mdto) {
		return mdao.emailchk(mdto);
	}

}