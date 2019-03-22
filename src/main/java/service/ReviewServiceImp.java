package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.ReviewDAO;
import dao.ReviewDaoImp;
import dto.PageDTO;
import dto.ReplyDTO;
import dto.ReviewDTO;

public class ReviewServiceImp implements ReviewService{
	private ReviewDAO dao;
	
	public ReviewServiceImp() {
		
	}// end ReviewServiceImp()
	
	public void setDao(ReviewDaoImp dao) {
		this.dao = dao;
	}//end setDao

	@Override
	public int countProcess() {
		return dao.count();
	}

	@Override
	public List<ReviewDTO> listProcess(PageDTO pv) {
		return dao.list(pv);
	}

	@Override
	public ReviewDTO contentProcess(int rv_num) {
		dao.readCount(rv_num);
		return dao.content(rv_num);
	}

	@Override
	public void insertProcess(ReviewDTO dto) {
		dao.save(dto);
	}

	@Override
	public void replyInsertProcess(ReplyDTO dto) {
		dao.replyInsertMethod(dto);
	}
	
	@Override
	public List<ReplyDTO> replyListProcess(int rv_num) {
		return dao.replyListMethod(rv_num);
	}

	@Override
	public void updateProcess(ReviewDTO dto, HttpServletRequest request) {
		/*MultipartFile file = dto.getFilename();
		String fileName = file.getOriginalFilename();

		// 중복파일명을 처리하기 위해 난수 발생
		UUID random = UUID.randomUUID();
		String root = request.getSession().getServletContext().getRealPath("/");

		// root+"temp/"
		String saveDirectory = root + "temp" + File.separator;

		// 실제 파일 경로 지정
		File fe = new File(saveDirectory);

		if (!file.isEmpty()) {
			String upload = dao.getFile(dto.getRv_num());
			File del = new File(saveDirectory, upload);

			del.delete();

			File ff = new File(saveDirectory, random + "_" + fileName);
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setUpload(random + "_" + fileName);
			System.out.println(dto.getUpload());
		}*/
		dao.update(dto);		
	}

	@Override
	public ReviewDTO updateSelectProcess(int rv_num) {
		return dao.updateNum(rv_num);
	}

	@Override
	public void deleteProcess(int rv_num, HttpServletRequest request) {
		/*String root = request.getSession().getServletContext().getRealPath("/");

		// root+"temp/"
		String saveDirectory = root + "temp" + File.separator;

		String upload = dao.getFile(rv_num);

		if (upload != null) {
			// 실제 파일 경로 지정
			File fe = new File(saveDirectory, upload);
			fe.delete();
		}

		// 무조건 not null이더라도 예외처리로 무조건 실행하기
		
		 * try { // 실제 파일 경로 지정 File fe = new File(saveDirectory, upload); fe.delete();
		 * } catch (Exception e) { // TODO: handle exception }
		 
*/
		dao.delete(rv_num);
	}

	@Override
	public List<ReplyDTO> replyDeleteProcess(ReplyDTO rdto) {
		dao.replyDelete(rdto.getRe_num());
		return dao.replyListMethod(rdto.getRe_num());
	}

	@Override
	public List<ReplyDTO> replyUpdateProcess(ReplyDTO rdto) {
		dao.replyUpdateMethod(rdto);
		return dao.replyListMethod(rdto.getRe_num());
	}

	

	

	

	
	

	
	
	
	
	
	
	
	
}// end class
