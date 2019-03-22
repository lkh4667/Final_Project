package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.BucketDTO;
import dto.Bucket_picDTO;
import dto.HashTagDTO;
import service.BucketListService;


// http://localhost:8090/mybucket/main.do
@Controller
public class MainPageController {
	private BucketListService service;
	
	public MainPageController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setService(BucketListService service) {
		this.service = service;
	}
	@RequestMapping("/main.do")
	public ModelAndView bucketListProcess(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		List<BucketDTO> list = service.bucketListProcess();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getPic_list().size());
		}
		mav.addObject("bk_list", list);
		mav.setViewName("bk_main");
		return mav;
	}
	@RequestMapping("/view.do")
	@ResponseBody
	public BucketDTO bucketViewProcess(int num) {
		System.out.println("View start num=====> " + num);
		return service.bucketViewProcess(num);
	}
	
	@RequestMapping("/bkAllList.do")
	@ResponseBody
	public List<BucketDTO> bucketAllListProcess(int startRow, int cntRow) {
		System.out.println("AllList start ");
		System.out.println("startRow=========> " + startRow);
		System.out.println("cntRow=========> " + cntRow);
		HashMap<String, Object> map = new HashMap<>();
		int strtrw = startRow+1;
		int endrw = startRow+cntRow;
		map.put("startRow", strtrw);
		map.put("endRow", endrw);
		List<BucketDTO> list = service.bucketAllListProcess(map);
		System.out.println("startrw=======> " + strtrw);
		System.out.println("endrw=======> " + endrw);

		return list;
	}
	
	@RequestMapping("/bkSearch.do")
	public ModelAndView bucketsearchListProcess(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		System.out.println("====search start page==== ");
		String category = req.getParameter("category");
		System.out.println("category=====> "  + category);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", 1);
		map.put("endRow", 8);
		map.put("category", category);
		List<BucketDTO> alist = service.bucketAllListProcess(map);
		mav.addObject("bk_list", alist);
		mav.setViewName("bk_main");
		return mav;
	}
	@RequestMapping("/bkAdd.do")
	@ResponseBody
	public int bucketAddListProcess(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		System.out.println("========bucketAdd start==========");
		String bk_num = req.getParameter("bk_num");
		System.out.println("bk_num==========> " + bk_num);
		int chk = 1;
		return chk;
	}
}


//찬구찬구찬구