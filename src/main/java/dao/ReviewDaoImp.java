package dao;

import java.util.HashMap;
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
	}// end count()

	@Override
	public List<ReviewDTO> list(PageDTO pv) {
		return sqlSession.selectList("review.rv_list", pv);
	}// end list()

	@Override
	public void readCount(int rv_num) {
		sqlSession.update("review.readCount", rv_num);
	}// end readCount()

	@Override
	public ReviewDTO content(int rv_num) {
		return sqlSession.selectOne("review.content", rv_num);
	}// end content()

	@Override
	public int save(ReviewDTO dto) {
		return sqlSession.insert("review.save",dto);
	}// end save()

	@Override
	public void replyInsertMethod(ReplyDTO dto) {
		sqlSession.insert("reply.re_insert",dto);
	}// end replyInsertMethod()
	
	@Override
	public List<ReplyDTO> replyListMethod(int rv_num) {
		List<ReplyDTO> list =  sqlSession.selectList("reply.re_list", rv_num);
		return list;
	}// end replyListMethod

	@Override
	public void update(ReviewDTO dto) {
		sqlSession.update("review.update",dto);
	}// end update()

	@Override
	public String getFile(int rv_num) {
		return sqlSession.selectOne("review.getupload",rv_num);
	}// end getFile()

	@Override
	public ReviewDTO updateNum(int rv_num) {
		return sqlSession.selectOne("review.content",rv_num);
	}// end updateNum()

	@Override
	public void delete(int rv_num) {
		sqlSession.delete("review.delete",rv_num);
	}// end delete()

	@Override
	public void replyDelete(int re_num) {
		sqlSession.delete("reply.re_delete",re_num);
	}// end replyDelete()

	@Override
	public void replyUpdateMethod(ReplyDTO rdto) {
		sqlSession.update("replyc.re_update",rdto);
	}// end replyUpdateMethod()

	@Override
	public void rvPicInsertMethod(ReviewDTO dto) {
		sqlSession.insert("review.rv_pic_insert", dto);
	}// end rvPicInsertMethod()
	
	@Override
	public void replyCountPlus(int re_num) {
		sqlSession.update("reply.re_Count_Plus",re_num);
	}// end replyCountPlus()

	@Override
	public void replyCountMinus(int re_num) {
		sqlSession.update("reply.re_Count_Minus", re_num);
	}// end replyCountMinus()

	@Override
	public List<ReviewDTO> search(HashMap<String, Object> map){
		return sqlSession.selectList("review.searchAll", map);
	}// end search()

	@Override
	public int searchCount(ReviewDTO dto) {
		return sqlSession.selectOne("review.countPart1",dto);
	}

	@Override
	public int searchCountElse(ReviewDTO dto) {
		return sqlSession.selectOne("review.countPart2",dto);
	}

	@Override
	public List<ReviewDTO> searchTitlecontentMethod(HashMap<String, Object> map) {
		return sqlSession.selectList("review.search_titlecontent", map);
	}

	@Override
	public List<ReviewDTO> searchElseMethod(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("review.searchElse", map);
	}

	@Override
	public List<ReviewDTO> searchgroup(HashMap<String, Object> map) {
		return sqlSession.selectList("review.searchGroup",map);
	}
	
	
	
	
}// end class
