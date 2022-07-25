package com.company.mvc.todo;

import java.util.List;
import com.company.mvc.todo.TodoVO;


public interface TodoMapper {
	public List<TodoVO> findAll(TodoVO vo);
	public void persist(TodoVO vo);
	public void merge(TodoVO vo);
	public void remove(Integer no);
	public TodoVO findById(int no);
} 
