package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BucketDTO;
import dto.ChallengeDTO;

public class ChallengeDaoImp implements ChallengeDAO{
	
	private SqlSessionTemplate sqlSession;
	
	public ChallengeDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ChallengeDTO> cListMethod(HashMap<String, Object> map) {
		return sqlSession.selectList("challenge.list", map);
	}

	@Override
	public String cMem_idMethod(String mem_id) {
		return sqlSession.selectOne("challenge.cmem_id",mem_id);
	}

	@Override
	public List<BucketDTO> bucketMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BucketDTO membucketMethod(int bk_num) {
		return sqlSession.selectOne("challenge.mem_bk_challenge", bk_num);
	}

	@Override
	public int recordCount(String sessionId) {
		return sqlSession.selectOne("challenge.cnt", sessionId);
	}

	@Override
	public void cUpdateMethod(HashMap<String, Object> map) {
		sqlSession.update("challenge.cUpdate",map);
	}

	@Override
	public void cDeleteMethod(HashMap<String, Object> map) {
		sqlSession.delete("challenge.cDelete",map);
	}

	@Override
	public List<ChallengeDTO> successListMethod(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("challenge.successlist",map);
	}

	@Override
	public int succes_rescordCount(String sessionId) {
		return sqlSession.selectOne("challenge.succes_cnt", sessionId);
	}

	@Override
	public void cReDelMethod(HashMap<String, Object> map) {
		sqlSession.delete("challenge.reDelete",map);
	}

	@Override
	public void cInsertMethod(ChallengeDTO cdto) {
		sqlSession.insert("challenge.cInsert", cdto);
	}




}
