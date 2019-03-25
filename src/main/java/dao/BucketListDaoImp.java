package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BucketDTO;
import dto.Bucket_picDTO;
import dto.HashTagDTO;

public class BucketListDaoImp implements BucketListDAO{

	private SqlSessionTemplate sqlSession;
	
	public BucketListDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<BucketDTO> bListMethod() {
		return sqlSession.selectList("bucket.list");
	}
	
	@Override
	public List<BucketDTO> bListAllMethod(HashMap<String, Object> map) {
		return sqlSession.selectList("bucket.bkList", map);
	}

	@Override
	public BucketDTO bViewMethod(int bk_num) {
		return sqlSession.selectOne("bucket.bk_view", bk_num);
	}

	@Override
	public List<Bucket_picDTO> bPicMethod(int bk_num) {
		return sqlSession.selectList("bucket.bk_view_pic", bk_num);
	}

	@Override
	public List<HashTagDTO> bHashTagMethod(int bk_num) {
		return sqlSession.selectList("bucket.hashtag", bk_num);
	}

	@Override
	public int bInsertMethod(BucketDTO dto) {
		return sqlSession.insert("bucket.bk_insert", dto);
	}

	@Override
	public int hInsertMethod(HashTagDTO hdto) {
		return sqlSession.insert("bucket.ht_insert", hdto);
	}

	@Override
	public int pInsertMethod(BucketDTO dto) {
		return sqlSession.insert("bucket.pic_insert", dto);
	}

	@Override
	public int bCountMethod() {
		return sqlSession.selectOne("bucket.count");
	}

	@Override
	public int bdeleteMethod(int bk_num) {
		return sqlSession.delete("bucket.bk_delete", bk_num);
	}

	@Override
	public int hdeleteMethod(int bk_num) {
		return sqlSession.delete("bucket.ht_delete", bk_num);
	}

	@Override
	public int pdeleteMethod(int bk_num) {
		return sqlSession.delete("bucket.pic_delete",bk_num);
	}

	@Override
	public List<Bucket_picDTO> pFindMethod(int bk_num) {
		return sqlSession.selectList("bucket.pic_find",bk_num);
	}

	@Override
	public String pFilefindMethod(Bucket_picDTO bdto) {
		return sqlSession.selectOne("bucket.pic_file_find", bdto);
	}

	@Override
	public void pFileDelMethod(Bucket_picDTO bdto) {
		sqlSession.delete("bucket.pic_file_del", bdto);
	}

	@Override
	public void bUpdateMethod(BucketDTO dto) {
		sqlSession.update("bucket.bk_update", dto);
	}

	@Override
	public int bSearchCntMethod(HashMap<String, String> map) {
		return sqlSession.selectOne("bucket.bcount", map);
	}

	@Override
	public void bPopUpMethod(int bk_num) {
		sqlSession.update("bucket.bkPopCnt", bk_num);
	}

	@Override
	public int cdeleteMethod(int bk_num) {
		return sqlSession.delete("bucket.ck_delete", bk_num);
	}

	@Override
	public List<BucketDTO> pListMethod(String bk_group) {
		return sqlSession.selectList("bucket.popular", bk_group);
	}


}
