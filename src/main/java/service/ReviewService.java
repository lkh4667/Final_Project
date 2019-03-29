package service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import dto.PageDTO;
import dto.ReplyDTO;
import dto.ReviewDTO;

public interface ReviewService {
	public int countProcess();
	public List<ReviewDTO> listProcess(PageDTO pv);
	public ReviewDTO contentProcess(int rv_num);
	public int insertProcess(ReviewDTO dto);
	public void replyInsertProcess(ReplyDTO dto);
	public List<ReplyDTO> replyListProcess(int re_num);
	public ReviewDTO updateSelectProcess(int rv_num);
	public void updateProcess(ReviewDTO dto, HttpServletRequest request);
	public void deleteProcess(int rv_num, HttpServletRequest request);
	public List<ReplyDTO> replyDeleteProcess(ReplyDTO rdto);
	public List<ReplyDTO> replyUpdateProcess(ReplyDTO rdto);
	public void rvPicInsertProcess(ReviewDTO dto);
	public List<ReviewDTO> searchProcess(HashMap<String, Object> map);
	
	/*검색 -> 제목 + 내용 갯수*/
	public int searchCountProcess(ReviewDTO dto);
	
	/*검색 -> 나머지 갯수*/
	public int searchCountElseProcess(ReviewDTO dto);
	
	
	public List<ReviewDTO> searchTitleContentProcess(HashMap<String, Object> map);
	
	public List<ReviewDTO> searchElseProcess(HashMap<String, Object> map);
	
	public List<ReviewDTO> searchGroupProcess(HashMap<String, Object> map);
	
}// end interface
