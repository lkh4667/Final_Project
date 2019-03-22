package dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ReplyDTO {
	private int re_num, rv_num;
	private String mem_id, re_content;
	private Date re_regdate;
	
	public ReplyDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getRe_num() {
		return re_num;
	}

	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}

	public int getRv_num() {
		return rv_num;
	}

	public void setRv_num(int rv_num) {
		this.rv_num = rv_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getRe_content() {
		return re_content;
	}

	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}

	public Date getRe_regdate() {
		return re_regdate;
	}

	public void setRe_regdate(Date re_regdate) {
		this.re_regdate = re_regdate;
	}
	
	
	
	
	
}// end class
