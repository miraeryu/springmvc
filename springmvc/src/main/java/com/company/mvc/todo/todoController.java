package com.company.mvc.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller랑 responsebody 합한것
@CrossOrigin(origins = "*") //모든 보안항복에 대해 오픈
public class todoController {
	
	@Autowired TodoMapper mapper;
	
	@GetMapping(value = "/getText" , produces = MediaType.TEXT_PLAIN_VALUE)
	public String getText() {
		return "안녕";
	}
	
	@GetMapping("/check")
	public ResponseEntity<List<TodoVO>> check(TodoVO vo) {
//		int a = 5/0;
		List<TodoVO> list = mapper.findAll(vo);
		return new ResponseEntity <List<TodoVO>>(list, HttpStatus.OK);
	}
	
	//조회
	@GetMapping(value = "/todo" , produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<TodoVO> todoList(TodoVO vo) {
		return mapper.findAll(vo);
	}
	
	@PostMapping("/todo") //등록은 post방식
	public TodoVO todoInsert(TodoVO vo) {
		mapper.persist(vo);
		return vo;
	}
	
	@PutMapping("/todo") // 파라미터가 json string만 가능
	public TodoVO todoUpdate(@RequestBody TodoVO vo) {
		mapper.merge(vo);
		return vo;
	}
	
	@DeleteMapping("/todo/{no}")
	public Integer todoDelete(@PathVariable Integer no) {
		System.out.println(no);
		mapper.remove(no);
		return no;
	}
	
	//단건 조회
	@GetMapping("/todo/{no}")
	public TodoVO todoSelect(@PathVariable Integer no) {
		return mapper.findById(no);
	}
}
