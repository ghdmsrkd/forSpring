package kr.inhatc.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MyProjectApplicationTests {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSqlSessionTest() {
		System.out.println(">>>>>>>>>>>>>>>>>"+sqlSessionTemplate.toString());
	}
}
