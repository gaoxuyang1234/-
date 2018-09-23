package com.yxysoft.basic;

import com.yxysoft.basic.mapper.EmployeeMapper;
import com.yxysoft.basic.model.Employee;
import com.yxysoft.basic.model.EmployeeExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private EmployeeMapper employeeMapper;

	@Test
	public void contextLoads() {
		EmployeeExample employeeExample = new EmployeeExample();
		EmployeeExample.Criteria criteria = employeeExample.createCriteria();
		criteria.andIdGreaterThan(1L);
		List<Employee> exampleList =  employeeMapper.selectByExample(employeeExample);
		for (Employee employee : exampleList) {
			System.out.println(employee);
		}
	}

}
