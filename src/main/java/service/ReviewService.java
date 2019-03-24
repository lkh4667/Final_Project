package service;

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
}// end interface
