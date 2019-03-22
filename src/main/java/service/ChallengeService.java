package service;

import java.util.HashMap;
import java.util.List;

import dto.BucketDTO;
import dto.ChallengeDTO;

public interface ChallengeService {
	public List<ChallengeDTO> challengeListprocess(HashMap<String, Object> map);
	public List<BucketDTO> challengebListprocess();
	public BucketDTO challengeBucketProcess(int bk_num);
	public int recordCountProcess(String sessionId);
	public int successRecordCntProcess(String sessionId);
	public void cUpdateProcess(HashMap<String, Object> map);
	public void cDeleteProcess(HashMap<String, Object> map);
	public List<ChallengeDTO> successListProcess(HashMap<String, Object> map);
	public void cReDelProcess(HashMap<String, Object> map);
	
	
	
	
	
}
