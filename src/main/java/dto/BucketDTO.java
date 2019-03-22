package dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BucketDTO {
	private int bk_num;
	private String bk_title;
	private String bk_content;
	private String bk_pop_cnt;
	private String bk_group;
	private List<Bucket_picDTO> pic_list;
	private String bp_file;
	private List<HashTagDTO> hashtag;
	private List<MultipartFile> bf_file;
	private Bucket_picDTO pic_dto;
	
	

	public BucketDTO() {
		
	}

	public int getBk_num() {
		return bk_num;
	}

	public void setBk_num(int bk_num) {
		this.bk_num = bk_num;
	}

	public String getBk_title() {
		return bk_title;
	}

	public void setBk_title(String bk_title) {
		this.bk_title = bk_title;
	}

	public String getBk_content() {
		return bk_content;
	}

	public void setBk_content(String bk_content) {
		this.bk_content = bk_content;
	}

	public String getBk_pop_cnt() {
		return bk_pop_cnt;
	}

	public void setBk_pop_cnt(String bk_pop_cnt) {
		this.bk_pop_cnt = bk_pop_cnt;
	}

	public String getBk_group() {
		return bk_group;
	}

	public void setBk_group(String bk_group) {
		this.bk_group = bk_group;
	}

	public List<Bucket_picDTO> getPic_list() {
		return pic_list;
	}

	public void setPic_list(List<Bucket_picDTO> pic_list) {
		this.pic_list = pic_list;
	}

	public List<HashTagDTO> getHashtag() {
		return hashtag;
	}

	public void setHashtag(List<HashTagDTO> hashtag) {
		this.hashtag = hashtag;
	}

	public List<MultipartFile> getBf_file() {
		return bf_file;
	}

	public void setBf_file(List<MultipartFile> bf_file) {
		this.bf_file = bf_file;
	}

	public Bucket_picDTO getPic_dto() {
		return pic_dto;
	}

	public void setPic_dto(Bucket_picDTO pic_dto) {
		this.pic_dto = pic_dto;
	}

	public String getBp_file() {
		return bp_file;
	}

	public void setBp_file(String bp_file) {
		this.bp_file = bp_file;
	}
	
	
	
}
