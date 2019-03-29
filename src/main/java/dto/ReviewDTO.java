package dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReviewDTO {
	private int rv_num, rv_count, rv_state, re_count;
	private String mem_id, rv_title, rv_content, rv_group;
	private Date rv_regdate;
	private String upload, ip;
	private MultipartFile filename;
	private List<ReplyDTO> rv_list;
	private List<Review_picDTO> rv_pic_list;
	
	public ReviewDTO() {
		
	}// end ReviewDTO()

	public int getRv_num() {
		return rv_num;
	}

	public List<ReplyDTO> getRv_list() {
		return rv_list;
	}

	public void setRv_list(List<ReplyDTO> rv_list) {
		this.rv_list = rv_list;
	}

	public void setRv_num(int rv_num) {
		this.rv_num = rv_num;
	}

	public int getRv_count() {
		return rv_count;
	}

	public void setRv_count(int rv_count) {
		this.rv_count = rv_count;
	}

	public int getRv_state() {
		return rv_state;
	}

	public void setRv_state(int rv_state) {
		this.rv_state = rv_state;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getRv_title() {
		return rv_title;
	}

	public void setRv_title(String rv_title) {
		this.rv_title = rv_title;
	}

	public String getRv_content() {
		return rv_content;
	}

	public void setRv_content(String rv_content) {
		this.rv_content = rv_content;
	}

	public Date getRv_regdate() {
		return rv_regdate;
	}

	public void setRv_regdate(Date rv_regdate) {
		this.rv_regdate = rv_regdate;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public MultipartFile getFilename() {
		return filename;
	}

	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<Review_picDTO> getRv_pic_list() {
		return rv_pic_list;
	}

	public void setRv_pic_list(List<Review_picDTO> rv_pic_list) {
		this.rv_pic_list = rv_pic_list;
	}

	public int getRe_count() {
		return re_count;
	}

	public void setRe_count(int re_count) {
		this.re_count = re_count;
	}
	
	public String getRv_group() {
		return rv_group;
	}
	
	public void setRv_group(String rv_group) {
		this.rv_group = rv_group;
	}
	

}// end class
