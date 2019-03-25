package service;

import java.util.HashMap;
import java.util.List;

import dao.BucketListDAO;
import dao.ChallengeDAO;
import dto.BucketDTO;
import dto.Bucket_picDTO;
import dto.ChallengeDTO;
import dto.HashTagDTO;

public class BucketListServiceImp implements BucketListService {

	private BucketListDAO dao;
	private ChallengeDAO cdao;
	
	public BucketListServiceImp() {
		// TODO Auto-generated constructor stub
	}

	public void setDao(BucketListDAO dao) {
		this.dao = dao;
	}

	public void setCdao(ChallengeDAO cdao) {
		this.cdao = cdao;
	}
	
	@Override
	public List<BucketDTO> bucketListProcess() {
		return dao.bListMethod();
	}

	@Override
	public List<BucketDTO> bucketAllListProcess(HashMap<String, Object> map) {
		return dao.bListAllMethod(map);
	}

	@Override
	public BucketDTO bucketViewProcess(int bk_num) {
		System.out.println("Service start !!!!");
		BucketDTO bdto = dao.bViewMethod(bk_num);
		List<Bucket_picDTO> list = dao.bPicMethod(bk_num);
		for (Bucket_picDTO pdto : list) {
			System.out.println(pdto.getBp_file());
		}
		bdto.setPic_list(dao.bPicMethod(bk_num));
		bdto.setHashtag(dao.bHashTagMethod(bk_num));
		return bdto;
	}

	@Override
	public int bucketInsertProcess(BucketDTO dto) {
		return dao.bInsertMethod(dto);
	}

	@Override
	public int HashTagInsertProcess(HashTagDTO hdto) {
		return dao.hInsertMethod(hdto);
	}

	@Override
	public int bucketPicInsertProcess(BucketDTO dto) {
		return dao.pInsertMethod(dto);
	}

	@Override
	public int bucketCountProcess() {
		return dao.bCountMethod();
	}

	@Override
	public void bucketDeletePorcess(int bk_num) {
		dao.hdeleteMethod(bk_num);
		dao.pdeleteMethod(bk_num);
		dao.bdeleteMethod(bk_num);
		dao.cdeleteMethod(bk_num);
	}

	@Override
	public List<Bucket_picDTO> PicFindProcess(int bk_num) {
		return dao.bPicMethod(bk_num);
	}

	@Override
	public int picDeleteProcess(int bk_num) {
		return dao.pdeleteMethod(bk_num);
	}

	@Override
	public List<HashTagDTO> findHashTagProcess(int bk_num) {
		return dao.bHashTagMethod(bk_num);
	}

	@Override
	public int hashTagDeleteProcess(int bk_num) {
		return dao.hdeleteMethod(bk_num);
	}

	@Override
	public String fileFindProcess(Bucket_picDTO bdto) {
		return dao.pFilefindMethod(bdto);
	}

	@Override
	public void fileDelProcess(Bucket_picDTO bdto) {
		dao.pFileDelMethod(bdto);
	}

	@Override
	public void bucketUpdateProcess(BucketDTO dto) {
		dao.bUpdateMethod(dto);
	}

	@Override
	public int bucketSearchCountProcess(HashMap<String, String> map) {
		return dao.bSearchCntMethod(map);
	}

	@Override
	public void bucketAddProcess(ChallengeDTO cdto) {
		int bk_num = cdto.getBk_num();
		dao.bPopUpMethod(bk_num);
		cdao.cInsertMethod(cdto);
	}

	@Override
	public int cAddChkProcess(ChallengeDTO cdto) {
		return cdao.cAddChkMethod(cdto);
	}

	@Override
	public List<BucketDTO> pListProcess(String bk_group) {
		return dao.pListMethod(bk_group);
	}

}
