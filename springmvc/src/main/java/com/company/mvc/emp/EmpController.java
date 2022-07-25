package com.company.mvc.emp;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpController {

	@Autowired EmpMapper mapper;
	Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	//단건조회
	@RequestMapping("/emp")
	public String emp(EmpVO vo, Model model) { // request도 가능하지만 굳이 그렇게 쓰진않음
		logger.info("파라미터" + vo.toString());
		model.addAttribute("emp", mapper.getEmp(vo));
		return "emp/emp";
	}
	
	//목록
	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("empList", mapper.getEmpList());
		return "emp/empList";
	}
	
	//목록
//	@RequestMapping("/empList")
//	public String empList(Model model, EmpReqVO vo) {
//		model.addAttribute("empList", mapper.search(vo));
//		return "emp/empList";
//	}
	
	//등록페이지 이동
	@RequestMapping("/empInsert")
	public String empInsert() {
		return "emp/empList";
	}
	
	//등록처리
	//@PostMapping("/empInsertProc")
	@RequestMapping(value = "/empInsertProc" , method = RequestMethod.POST)
	public String empInsertProc(EmpVO vo) {
		// 커맨드 객체
		logger.debug(vo.toString());
		System.out.println(vo);
		mapper.insert(vo);
		System.out.println(vo.getEmployeeId() + "사번 등록");
		return "redirect:empList";
	}
	
	//수정 페이지
	@RequestMapping("/empUpdate")
	public String empUpdateForm(Model model, EmpVO vo) {
		model.addAttribute("emp", mapper.getEmp(vo));
		return "emp/empUpdate";
	}
	
	//수정 처리
//	@PostMapping("/empUpdateProc")
	@RequestMapping(value = "/empUpdateProc" , method = RequestMethod.POST)
	public String empUpdateProc(EmpVO vo) {
		
		System.out.println(vo.toString());
		mapper.update(vo);
		return "redirect:empList";
	}
	
	//삭제
	@RequestMapping("/empDelete")
	public String empDelete(EmpVO vo) {
		mapper.delete(vo);
		return "rediret:empList";
	}
	
}
