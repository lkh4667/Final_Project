package service;

import java.util.HashMap;
import java.util.List;

import dto.BucketDTO;
import dto.Bucket_picDTO;
import dto.ChallengeDTO;
import dto.HashTagDTO;


public interface BucketListService {
	public List<BucketDTO> bucketListProcess();
	public List<BucketDTO> bucketAllListProcess(HashMap<String, Object> map);
	public BucketDTO bucketViewProcess(int bk_num);
	public int bucketInsertProcess(BucketDTO dto);
	public int HashTagInsertProcess(HashTagDTO hdto);
	public int bucketPicInsertProcess(BucketDTO dto);
	public int bucketCountProcess();
	public int bucketSearchCountProcess(HashMap<String, String> map);
	public void bucketDeletePorcess(int bk_num);
	public List<Bucket_picDTO> PicFindProcess(int bk_num);
	public int picDeleteProcess(int bk_num);
	public List<HashTagDTO> findHashTagProcess(int bk_num);
	public int hashTagDeleteProcess(int bk_num);
	public String fileFindProcess(Bucket_picDTO bdto);
	public void fileDelProcess(Bucket_picDTO bdto);
	public void bucketUpdateProcess(BucketDTO dto);
	public void bucketAddProcess(ChallengeDTO cdto);
	public int cAddChkProcess(ChallengeDTO cdto);
	
	public List<BucketDTO> pListProcess(String bk_group);
}
