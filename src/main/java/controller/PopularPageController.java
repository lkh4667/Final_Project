package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.BucketDTO;
import service.BucketListService;
import service.BucketListServiceImp;

@Controller
public class PopularPageController {
	
	private BucketListService service;

	public PopularPageController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setService(BucketListService service) {
		this.service = service;
	}


	@RequestMapping("/popular.do")
	public String listProcess() {
		return "popular";
	}
	@RequestMapping("/popularGp.do")
	@ResponseBody
	public List<BucketDTO> listGroupProcess(String bk_group) {
		System.out.println("popularGp start !!!!");
		System.out.println("bk_group===============> " + bk_group);
		List<BucketDTO> plist = service.pListProcess(bk_group);
		System.out.println(plist.size());
		for (BucketDTO bdto : plist) {
			System.out.println(bdto.getPic_dto().getBp_file());
		}
		return plist;
	}
	/*
	 * @RequestMapping("/popular.do") public String process() { return "popular"; }
	 */
}// end class
