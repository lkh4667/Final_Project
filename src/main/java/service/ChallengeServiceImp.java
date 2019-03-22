package service;

import java.util.HashMap;
import java.util.List;

import dao.ChallengeDAO;
import dto.BucketDTO;
import dto.ChallengeDTO;

public class ChallengeServiceImp implements ChallengeService{
		
	
	private ChallengeDAO cdao;
	
	
	public ChallengeServiceImp() {
		// TODO Auto-generated constructor stub
	}
	


	public void setCdao(ChallengeDAO cdao) {
		this.cdao = cdao;
	}




	@Override
	public List<ChallengeDTO> challengeListprocess(HashMap<String, Object> map) {
		return cdao.cListMethod(map);
	}

	@Override
	public List<BucketDTO> challengebListprocess() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BucketDTO challengeBucketProcess(int bk_num) {
		return cdao.membucketMethod(bk_num);
	}



	@Override
	public int recordCountProcess(String sessionId) {
		return cdao.recordCount(sessionId);
	}



	@Override
	public void cUpdateProcess(HashMap<String, Object> map) {
		cdao.cUpdateMethod(map);
	}



	@Override
	public void cDeleteProcess(HashMap<String, Object> map) {
		cdao.cDeleteMethod(map);
	}



	@Override
	public List<ChallengeDTO> successListProcess(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return cdao.successListMethod(map);
	}



	@Override
	public int successRecordCntProcess(String sessionId) {
		return cdao.succes_rescordCount(sessionId);
	}



	@Override
	public void cReDelProcess(HashMap<String, Object> map) {
		cdao.cReDelMethod(map);
	}





	
}
