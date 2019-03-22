package dto;

import java.util.Date;

public class ChallengeDTO {
	
	private int c_num;
	private int bk_num;
	private String mem_id;
	private String c_state;
	private Date c_regdate;
	private BucketDTO bucketDTO;
	
	public ChallengeDTO() {
		// TODO Auto-generated constructor stub
	}

	public ChallengeDTO(int c_num, int bk_num, String mem_id, String c_state, Date c_regdate) {
		super();
		this.c_num = c_num;
		this.bk_num = bk_num;
		this.mem_id = mem_id;
		this.c_state = c_state;
		this.c_regdate = c_regdate;
	}

	
	
	public BucketDTO getBucketDTO() {
		return bucketDTO;
	}

	public void setBucketDTO(BucketDTO bucketDTO) {
		this.bucketDTO = bucketDTO;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public int getBk_num() {
		return bk_num;
	}

	public void setBk_num(int bk_num) {
		this.bk_num = bk_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getC_state() {
		return c_state;
	}

	public void setC_state(String c_state) {
		this.c_state = c_state;
	}

	public Date getC_regdate() {
		return c_regdate;
	}

	public void setC_regdate(Date c_regdate) {
		this.c_regdate = c_regdate;
	}
	
	
	
}//end class
