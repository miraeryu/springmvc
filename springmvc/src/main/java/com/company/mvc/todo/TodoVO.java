package com.company.mvc.todo;

import com.company.mvc.todo.TodoVO;

public class TodoVO {
	@Override
	public String toString() {
		return "TodoVO [no=" + no + ", contents=" + contents + ", todoyn=" + todoyn + "]";
	}
	private String no;
	private String id;
	private String contents;
	private String todoyn;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTodoyn() {
		return todoyn;
	}
	public void setTodoyn(String todoyn) {
		this.todoyn = todoyn;
	}
	
	
}
