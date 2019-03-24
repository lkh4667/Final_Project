package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.PageDTO;
import dto.ReplyDTO;
import dto.ReviewDTO;

public class ReviewDaoImp implements ReviewDAO {
	private SqlSessionTemplate sqlSession;

	public ReviewDaoImp() {
		// TODO Auto-generated constructor stub
	}// end ReviewDaoImp()

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}// end setSqlSEssion()

	@Override
	public int count() {
		return sqlSession.selectOne("review.count");
	}

	@Override
	public List<ReviewDTO> list(PageDTO pv) {
		return sqlSession.selectList("review.rv_list", pv);
	}

	@Override
	public void readCount(int rv_num) {
		sqlSession.update("review.readCount", rv_num);
	}

	@Override
	public ReviewDTO content(int rv_num) {
		return sqlSession.selectOne("review.content", rv_num);
	}

	@Override
	public int save(ReviewDTO dto) {
		return sqlSession.insert("review.save",dto);
	}

	@Override
	public void replyInsertMethod(ReplyDTO dto) {
		sqlSession.insert("reply.re_insert",dto);
	}
	
	@Override
	public List<ReplyDTO> replyListMethod(int rv_num) {
		List<ReplyDTO> list =  sqlSession.selectList("reply.re_list", rv_num);
		return list;
	}

	@Override
	public void update(ReviewDTO dto) {
		sqlSession.update("review.update",dto);
	}

	@Override
	public String getFile(int rv_num) {
		return sqlSession.selectOne("review.getupload",rv_num);
	}

	@Override
	public ReviewDTO updateNum(int rv_num) {
		return sqlSession.selectOne("review.content",rv_num);
	}

	@Override
	public void delete(int rv_num) {
		sqlSession.delete("review.delete",rv_num);
	}

	@Override
	public void replyDelete(int re_num) {
		sqlSession.delete("reply.re_delete",re_num);
	}

	@Override
	public void replyUpdateMethod(ReplyDTO rdto) {
		sqlSession.update("reply.re_update",rdto);
	}

	@Override
	public void rvPicInsertMethod(ReviewDTO dto) {
		sqlSession.insert("review.rv_pic_insert", dto);
	}

	

	

	
	

	
	
}// end class
