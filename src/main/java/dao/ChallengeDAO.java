package dao;

import java.util.HashMap;
import java.util.List;

import dto.BucketDTO;
import dto.ChallengeDTO;

public interface ChallengeDAO {

	public List<ChallengeDTO> cListMethod(HashMap<String, Object> map);

	public String cMem_idMethod(String mem_id);

	public List<BucketDTO> bucketMethod();

	public BucketDTO membucketMethod(int bk_num);

	public int recordCount(String sessionId);

	public int succes_rescordCount(String sessionId);

	public void cUpdateMethod(HashMap<String, Object> map);

	public void cDeleteMethod(HashMap<String, Object> map);

	public List<ChallengeDTO> successListMethod(HashMap<String, Object> map);
	
	public void cReDelMethod(HashMap<String, Object> map);
	
	public void cInsertMethod(ChallengeDTO cdto);
	
}
