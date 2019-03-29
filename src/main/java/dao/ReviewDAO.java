package dao;

import java.util.HashMap;
import java.util.List;

import dto.PageDTO;
import dto.ReplyDTO;
import dto.ReviewDTO;

public interface ReviewDAO {
	public int count();
	public List<ReviewDTO> list(PageDTO pv);
	public void readCount(int num);
	public ReviewDTO content(int rv_num);
	public int save(ReviewDTO dto);
	public void replyInsertMethod(ReplyDTO dto);
	public List<ReplyDTO> replyListMethod(int re_num);
	public ReviewDTO updateNum(int rv_num);
	public void update(ReviewDTO dto);
	public String getFile(int rv_num);
	public void delete(int rv_num);
	public void replyDelete(int re_num);
	public void replyUpdateMethod(ReplyDTO rdto);
	public void rvPicInsertMethod(ReviewDTO dto);
	public void replyCountPlus(int re_num);
	public void replyCountMinus(int re_num);
	
	/*검색*/
	public List<ReviewDTO> search(HashMap<String, Object> map);
	
	/*검색 -> 제목+내용 갯수*/
	public int searchCount(ReviewDTO dto);
	
	/*검색 -> 그외 갯수*/
	public int searchCountElse(ReviewDTO dto);
	
	public List<ReviewDTO> searchTitlecontentMethod(HashMap<String , Object> map);
	public List<ReviewDTO> searchElseMethod(HashMap<String , Object> map);
	
	public List<ReviewDTO> searchgroup(HashMap<String, Object> map);
	
	
}// end interface
