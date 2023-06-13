/**
 * 
 */
package com.example.IncidentManagement.LowesApi.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.IncidentManagement.LowesApi.entity.Incident;

/**
 * @author LENOVO
 *
 */
@SpringBootTest
class IncidentDaoTest {

	@Autowired
	private IncidentDao inciDao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
		long id = 122;
		
		inciDao.deleteById(id);
		System.out.println("Incident with id = 122 DELETED !!");
	}

	@Test
	void test() {
//		fail("Not yet implemented");
		
		Incident incident = new Incident(122, "Central Server Down", "abcdefgh", "High", "Software Issues", "New", 333, "Akash", "IT");
		inciDao.save(incident);
		
		List<Incident> list = inciDao.findByUserId(122);
		
		assertThat(list).isNotEmpty().doesNotContainNull();
		
	}

}
