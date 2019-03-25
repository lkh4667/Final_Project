package dao;

import java.util.HashMap;
import java.util.List;

import dto.BucketDTO;
import dto.Bucket_picDTO;
import dto.HashTagDTO;


public interface BucketListDAO {
	public List<BucketDTO> bListMethod();
	public List<BucketDTO> bListAllMethod(HashMap<String, Object> map);
	public BucketDTO bViewMethod(int bk_num);
	public List<Bucket_picDTO> bPicMethod(int bk_num);
	public List<HashTagDTO> bHashTagMethod(int bk_num);
	public int bInsertMethod(BucketDTO dto);
	public int hInsertMethod(HashTagDTO hdto);
	public int pInsertMethod(BucketDTO dto);
	public int bCountMethod();
	public int bSearchCntMethod(HashMap<String, String> map);
	public int bdeleteMethod(int bk_num);
	public int hdeleteMethod(int bk_num);
	public int pdeleteMethod(int bk_num);
	public int cdeleteMethod(int bk_num);
	public List<Bucket_picDTO> pFindMethod(int bk_num);
	public String pFilefindMethod(Bucket_picDTO bdto);
	public void pFileDelMethod(Bucket_picDTO bdto);
	public void bUpdateMethod(BucketDTO dto);
	public void bPopUpMethod(int bk_num);
	
	public List<BucketDTO> pListMethod(String bk_group);
}
