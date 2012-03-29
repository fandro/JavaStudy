package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWordController {
	
	@RequestMapping("/hello")
	public ModelAndView helloWord(){
		String msg = "hello!my first spring mvc!";
		return new ModelAndView("hello", "message", msg);
	}
}
