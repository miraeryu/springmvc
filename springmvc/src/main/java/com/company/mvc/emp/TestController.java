package com.company.mvc.emp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	
	@RequestMapping("/parameter2")
	public ModelAndView parameter2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("parameter");
		mv.addObject("param1","test");
		return mv;
	}
	
	
	
	@RequestMapping("/parameter") // void 여도 가능
	public void parameter() {
		
	}
	
	/*
	@RequestMapping("/parameter")
	public String parameter() {
		return "parameter";
	}
	*/
	
	@RequestMapping("/req1")
	public void req1(HttpServletResponse response,
						@RequestParam(required = false, defaultValue = "park") 
						String id) {
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/req2")
	public void req2(HttpServletResponse response,
						@RequestParam List<String> ids) {
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(ids);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/req3")
	public void req3(HttpServletResponse response,
					@RequestParam Map<String, Object> map) {
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/req4")
	public void req4(HttpServletResponse response,
					ReqVO vo) {
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/req5")
	public void req5(HttpServletResponse response,
					ListReqVO vo) {
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/req6")
	public void req6(HttpServletResponse response,
					ReqVO vo, MultipartFile[] pic) {
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			
			//첨부파일 업로드
			for(MultipartFile temp : pic)
			if (temp != null & temp.getSize() >0) {
				File file = new File("d:/upload", temp.getOriginalFilename());
				temp.transferTo(file);
				out.print(temp.getOriginalFilename() + "<br>");
				out.print(temp.getSize());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/req7/{id}/{age}")
	public void req7(HttpServletResponse response,
					@PathVariable String id,
					@PathVariable int age) {
		response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(id);
			out.print(age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//스트링[] request.getParameterValues()
	
	@GetMapping("/array")
	public void array(@RequestParam String id,
						@RequestParam List<String> ids,
						HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		out.print(id);
		out.print(ids);
	}

}
