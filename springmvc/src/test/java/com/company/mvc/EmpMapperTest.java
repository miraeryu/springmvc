package com.company.mvc;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mvc.emp.EmpMapper;
import com.company.mvc.emp.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperTest {
	@Autowired EmpMapper mapper;
	@Test
	public void test() {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
//		EmpMapper mapper = ctx.getBean(EmpMapper.class);
		EmpVO param = new EmpVO();
		param.setEmployeeId("100");
		EmpVO result = mapper.getEmp(param);
		System.out.println(result);
	}
	
	@Test
	public void list() {
		EmpVO param = new EmpVO();
		//param.setDapartmentId("30");
		List<EmpVO> result = mapper.getEmpList();
		System.out.println(result);
	}
}
