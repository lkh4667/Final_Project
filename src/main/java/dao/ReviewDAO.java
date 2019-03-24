package dao;

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
	
	
}// end interface
