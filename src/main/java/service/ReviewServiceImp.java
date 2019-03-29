package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import dao.ReviewDAO;
import dao.ReviewDaoImp;
import dto.PageDTO;
import dto.ReplyDTO;
import dto.ReviewDTO;

public class ReviewServiceImp implements ReviewService{
	private ReviewDAO dao;
	
	public ReviewServiceImp() {
		
	}// end ReviewServiceImp()
	
	public void setDao(ReviewDaoImp dao) {
		this.dao = dao;
	}//end setDao

	@Override
	public int countProcess() {
		return dao.count();
	}// end countProcess()

	@Override
	public List<ReviewDTO> listProcess(PageDTO pv) {
		return dao.list(pv);
	}// end listProcess()

	@Override
	public ReviewDTO contentProcess(int rv_num) {
		dao.readCount(rv_num);
		return dao.content(rv_num);
	}// end contentProcess()

	@Override
	public int insertProcess(ReviewDTO dto) {
		return dao.save(dto);
	}// end insertProcess()

	@Override
	public void replyInsertProcess(ReplyDTO dto) {
		dao.replyCountPlus(dto.getRv_num());
		dao.replyInsertMethod(dto);
	}// end replyInsertProcess()
	
	@Override
	public List<ReplyDTO> replyListProcess(int rv_num) {
		return dao.replyListMethod(rv_num);
	}// end replyListProcess()

	@Override
	public void updateProcess(ReviewDTO dto, HttpServletRequest request) {
		dao.update(dto);		
	}// end updateProcess()

	@Override
	public ReviewDTO updateSelectProcess(int rv_num) {
		return dao.updateNum(rv_num);
	}// end updateSelectProcess()

	@Override
	public void deleteProcess(int rv_num, HttpServletRequest request) {
		dao.delete(rv_num);
	}// end deleteProcess()

	@Override
	public List<ReplyDTO> replyDeleteProcess(ReplyDTO rdto) {
		dao.replyCountMinus(rdto.getRv_num());
		dao.replyDelete(rdto.getRe_num());
		return dao.replyListMethod(rdto.getRe_num());
	}// end replyDeleteProcess()

	@Override
	public List<ReplyDTO> replyUpdateProcess(ReplyDTO rdto) {
		dao.replyUpdateMethod(rdto);
		return dao.replyListMethod(rdto.getRe_num());
	}// end replyUpdateProcess()

	@Override
	public void rvPicInsertProcess(ReviewDTO dto) {
		dao.rvPicInsertMethod(dto);
	}// end rvPicInsertProcess()

	@Override
	public List<ReviewDTO> searchProcess(HashMap<String, Object> map) {
		return dao.search(map);
	}// end rvPicInsertProcess()

	@Override
	public int searchCountProcess(ReviewDTO dto) {
		return dao.searchCount(dto);
	}

	@Override
	public int searchCountElseProcess(ReviewDTO dto) {
		return dao.searchCountElse(dto);
	}

	@Override
	public List<ReviewDTO> searchTitleContentProcess(HashMap<String, Object> map) {
		return dao.searchTitlecontentMethod(map);
	}

	@Override
	public List<ReviewDTO> searchElseProcess(HashMap<String, Object> map) {
		return dao.searchElseMethod(map);
	}

	@Override
	public List<ReviewDTO> searchGroupProcess(HashMap<String, Object> map) {
		return dao.searchgroup(map);
	}

	
	

	

	
	

	
	
	
	
	
	
	
	
}// end class
