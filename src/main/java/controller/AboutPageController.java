package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutPageController {
	@RequestMapping("/about.do")
	public String process() {
		return "about";
	}
}
