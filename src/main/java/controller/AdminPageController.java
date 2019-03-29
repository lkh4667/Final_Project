package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.instrument.classloading.tomcat.TomcatLoadTimeWeaver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.BucketDTO;
import dto.Bucket_picDTO;
import dto.HashTagDTO;
import dto.PageDTO;
import service.BucketListService;

@Controller
public class AdminPageController {

	private BucketListService service;
	private int currentPage;
	private PageDTO pdto;

	public AdminPageController() {
		// TODO Auto-generated constructor stub
	}

	public void setService(BucketListService service) {
		this.service = service;
	}

	// http://localhost:8090/mybucket/admin.do
	@RequestMapping("/admin.do")
	public ModelAndView adminListPorcess(PageDTO pv, String keyword, String category) {
		ModelAndView mav = new ModelAndView();
		int totalRecord = 0;
		System.out.println(category);
		System.out.println(keyword);
		if (keyword != null || category != null) {
			HashMap<String, String> KeyMap = new HashMap<>();
			KeyMap.put("category", category);
			KeyMap.put("keyword", keyword);
			totalRecord = service.bucketSearchCountProcess(KeyMap);
			System.out.println(totalRecord);
		} else {
			totalRecord = service.bucketCountProcess();
			System.out.println(totalRecord);
		}
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0) {
				currentPage = 1;
			} else {
				currentPage = pv.getCurrentPage();
			}
			pdto = new PageDTO(currentPage, totalRecord);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("startRow", pdto.getStartRow());
			map.put("endRow", pdto.getEndRow());
			map.put("keyword", keyword);
			map.put("category", category);
			mav.addObject("pv", pdto);
			mav.addObject("bk_list", service.bucketAllListProcess(map));
		}
		mav.setViewName("admin_list");
		return mav;
	}

	// http://localhost:8090/mybucket/bkWrite.do
	@RequestMapping("/bkWrite.do")
	public String bucketwriteProcess() {
		return "bk_write";
	}

	@RequestMapping("/bkWriteEnd.do")
	@ResponseBody
	public int bucketwriteEndProcess(@RequestParam("sel_files") List<MultipartFile> images, 
			BucketDTO dto,String ht_name) {

		System.out.println("bucket Insert start");

		System.out.println("bk_title==========> " + dto.getBk_title());
		System.out.println("bk_group==========> " + dto.getBk_group());
		System.out.println("bk_content==========> " + dto.getBk_content());
		System.out.println("hs==========> " + ht_name);

		List<Bucket_picDTO> pic_list = new ArrayList<Bucket_picDTO>();

		for (MultipartFile image : images) {
			Bucket_picDTO pdto = new Bucket_picDTO();
			// 파일 이름
			String originalName = image.getOriginalFilename();
			/* long fileSize = image.getSize(); // 파일 사이즈 */
			System.out.println("originFileName : " + originalName);
			UUID random = UUID.randomUUID(); // 중복 파일 구분을 위한 랜덤 생성

			String filename = random + "_" + originalName;

			String path = "C:\\temp\\";
			String safeFile = path + filename;
			pdto.setBp_file(filename);
			pic_list.add(pdto);
			try {
				image.transferTo(new File(safeFile));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 현재 가져온 이미지 파일 갯수
		System.out.println("pic_list Size==========> " + pic_list.size());
		// 버킷리스트 삽입
		service.bucketInsertProcess(dto);
		System.out.println("insert after bk_num==========> " + dto.getBk_num());
		List<HashTagDTO> ht_list = new ArrayList<HashTagDTO>();
		String[] ht_arr = ht_name.split(",");
		for (String str : ht_arr) {
			HashTagDTO hdto = new HashTagDTO();
			hdto.setBk_num(dto.getBk_num());
			hdto.setHt_name(str);
			// 해당 버킷리스트에 대한 해쉬태그 삽입
			service.HashTagInsertProcess(hdto);
		}
		// 사진 객체에 저장
		dto.setPic_list(pic_list);
		// 커킷리스트 사진 데이터 저장
		service.bucketPicInsertProcess(dto);
		return currentPage;
	}

	@RequestMapping("/bk_update.do")
	public ModelAndView bucketUpdatePageProcess(int currentPage, int bk_num) {
		ModelAndView mav = new ModelAndView();
		BucketDTO bdto = service.bucketViewProcess(bk_num);
		mav.addObject("bdto", bdto);
		mav.setViewName("bk_update");
		return mav;
	}

	@RequestMapping("/bkUpdateEnd.do")
	@ResponseBody
	public int bucketUpdateEndProcess(@RequestParam("sel_files") List<MultipartFile> images, int currentPage,
			BucketDTO bdto, String bp_file, String ht_name) {
		System.out.println("updateEnd start");
		
		String path = "C:\\temp\\";
		List<Bucket_picDTO> alist = new ArrayList<Bucket_picDTO>();
		int bk_num = bdto.getBk_num();
		System.out.println(bp_file);
		/*boolean fileCheck = true;
		int bk_num = bdto.getBk_num();
		System.out.println(bk_num);
		
			fileCheck =  bp_file.contains(",");
			System.out.println(fileCheck);
		if (fileCheck == true) {*/
		if (bp_file != null) {
			String[] bpfiles = bp_file.split(",");

			List<Bucket_picDTO> bList = service.PicFindProcess(bk_num);

			int[] exis = new int[bList.size()];

			for (int i = 0; i < exis.length; i++) {
				exis[i] = 0;
			}
			for (String picArr : bpfiles) {
				Bucket_picDTO pdto = new Bucket_picDTO();
				pdto.setBk_num(bk_num);
				pdto.setBp_file(picArr);
				System.out.println("기존 파일명 : " + picArr);
				int count = 0;
				for (Bucket_picDTO ddto : bList) {
					System.out.println("디비에 저장된 파일 명 : " + ddto.getBp_file());
					if (picArr.equals(ddto.getBp_file())) {
						exis[count] = 1;
					}
					count++;
				}
			}

			for (int i = 0; i < exis.length; i++) {
				System.out.println("exis[" + i + "]=> " + exis[i]);
				Bucket_picDTO zdto = new Bucket_picDTO();
				if (exis[i] == 0) {
					zdto.setBk_num(bk_num);
					zdto.setBp_num(i + 1);
					String bpfile = service.fileFindProcess(zdto);
					String fullPath = path + bpfile;
					File oldfile = new File(fullPath);
					oldfile.delete(); // 해당 파일 삭제

					service.fileDelProcess(zdto);
				} else {
					zdto.setBk_num(bk_num);
					zdto.setBp_num(i + 1);
					String mpfile = service.fileFindProcess(zdto);
					zdto.setBp_file(mpfile);
					alist.add(zdto);
				}
			}
		}else {
			System.out.println("기존 파일 삭제");
			
			List<Bucket_picDTO> mlist = service.PicFindProcess(bk_num);
			
			for (Bucket_picDTO vdto : mlist) {
				String xfile = vdto.getBp_file();
				String fullPath = path + xfile;
				File oldfile = new File(fullPath);
				oldfile.delete(); // 해당 파일 삭제
			}
			
			service.picDeleteProcess(bk_num);
		}


		if (images != null) {
			for (MultipartFile mf : images) {

				Bucket_picDTO qdto = new Bucket_picDTO();

				String originFileName = mf.getOriginalFilename(); // 원본 파일 명
				System.out.println("originFileName : " + originFileName);

				UUID random = UUID.randomUUID(); // 중복 파일 구분을 위한 랜덤 생성

				String filename = random + "_" + originFileName;

				String safeFile = path + filename;

				qdto.setBp_file(filename);
				try {
					mf.transferTo(new File(safeFile));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				alist.add(qdto);
			}
		}

		System.out.println("사진 업로드 시작 ");
		// 리스트 안에 사진이 한장이라도 꼭 있어야 됨 !!!
		service.picDeleteProcess(bk_num);
		bdto.setPic_list(alist);
		service.bucketPicInsertProcess(bdto);

		System.out.println("해쉬 태그 삽입 시작");
		String[] HashtagName = ht_name.split(",");
		service.hashTagDeleteProcess(bk_num);
		for (String htArr : HashtagName) {
			HashTagDTO htdto = new HashTagDTO();
			htdto.setBk_num(bk_num);
			htdto.setHt_name(htArr);
			service.HashTagInsertProcess(htdto);
		}

		System.out.println("해당 버킷리스트 수정 시작");
		service.bucketUpdateProcess(bdto);

		return currentPage;
	}

	@RequestMapping("/bk_delete.do")
	public String bucketdeleteEndprocess(int currentPage, int bk_num) {
		System.out.println("bk_delete start!!");
		System.out.println("현재 페이지 값 => " + currentPage);
		System.out.println("bk_num => " + bk_num);

		String path = "C:\\temp\\";
		List<Bucket_picDTO> pList = service.PicFindProcess(bk_num);
		for (Bucket_picDTO pdto : pList) {
			System.out.println("파일 이름 : " + pdto.getBp_file());
			String fullPath = path + pdto.getBp_file();
			File file = new File(fullPath);
			file.delete();
		}
		service.bucketDeletePorcess(bk_num);

		return "redirect:/admin.do?=" + currentPage;
	}

	// http://localhost:8090/mybucket/admin.do
	@RequestMapping("/adminSearch.do")
	public ModelAndView adminSearchProcess(PageDTO pv, String category, String keyword) {
		ModelAndView mav = new ModelAndView();

		System.out.println("currenPage=>" + pv.getCurrentPage());
		System.out.println("category=>" + category);
		System.out.println("keyword==> " + keyword);
		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("category", category);
		searchMap.put("keyword", keyword);
		int totalRecord = service.bucketSearchCountProcess(searchMap);
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0) {
				currentPage = 1;
			} else {
				currentPage = pv.getCurrentPage();
			}
			pdto = new PageDTO(currentPage, totalRecord);

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("startRow", pdto.getStartRow());
			map.put("endRow", pdto.getEndRow());
			map.put("category", category);
			map.put("keyword", keyword);
			mav.addObject("pv", pdto);
			mav.addObject("bk_list", service.bucketAllListProcess(map));
		}
		if (category.equals("")) {
			mav.setViewName("redirect:/admin.do");
		} else {
			mav.setViewName("admin_list");
		}
		return mav;
	}

}
