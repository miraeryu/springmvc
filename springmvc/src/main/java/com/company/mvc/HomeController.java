package com.company.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.mvc.emp.EmpMapper;
import com.company.mvc.emp.EmpVO;

/**
 * Handles requests for the application home page.
 */
@Controller // POJO / Command를 상속받을 필요없이 커맨트화시켜줌 / @component상속. 빈 등록, 서블릿이 호출할 수 있도록 command화
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/ajax")
	@ResponseBody
	public EmpVO ajax(EmpVO vo) {
		vo.setFirstName("hong");
		vo.setLastName("gil-dong");
		return vo;
	}
	
	
}
