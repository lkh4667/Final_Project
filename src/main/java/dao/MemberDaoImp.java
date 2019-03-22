package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemberDTO;

public class MemberDaoImp implements MemberDAO {
	private SqlSessionTemplate sqlSession;

	public MemberDaoImp() {
		// TODO Auto-generated constructor stub
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int login(MemberDTO mdto) {
		return sqlSession.selectOne("member.loginchk", mdto);
	}

	@Override
	public void signup(MemberDTO mdto) {
		sqlSession.insert("member.signup", mdto);

	}

	@Override
	public String MemNameSession(String mem_id) {
		return sqlSession.selectOne("member.namesession", mem_id);
	}

	@Override
	public String MemPicSession(String mem_id) {
		return sqlSession.selectOne("member.picsession", mem_id);
	}

	@Override
	public int memIdChk(String mem_id) {
		return sqlSession.selectOne("member.idcheck", mem_id);
	}

	@Override
	public MemberDTO MemberPage(String mem_id) {
		return sqlSession.selectOne("member.memberdata", mem_id);
	}

	@Override
	public void memUpdate(MemberDTO mdto) {
		sqlSession.update("member.update", mdto);
	}

	@Override
	public void memDelete(String mem_id) {
		sqlSession.delete("member.delete", mem_id);
	}

	@Override
	public List<MemberDTO> MemSelectAll() {
		return sqlSession.selectList("member.memlistAll");
	}

	@Override
	public int emailchk(MemberDTO mdto) {
		return sqlSession.selectOne("member.memcodechk", mdto);
	}

	



}

