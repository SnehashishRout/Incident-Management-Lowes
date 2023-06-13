package com.example.IncidentManagement.LowesApi.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.IncidentManagement.LowesApi.dao.IncidentDao;
import com.example.IncidentManagement.LowesApi.entity.Incident;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class InciServiceImplTest {
	
	@MockBean
	private IncidentDao inciDao;
	
	@Autowired
	private InciService inciservice;
	
	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllIncident() {
//		fail("Not yet implemented");
		
//		inciservice.getIncidents();
//		verify(inciDao).findAll();
		Incident incident1 = new Incident(17, "Server RX down", "abcdefgh", "High", "Hardware Issues", "New", 550, "Neha", "IT");
		Incident incident2 = new Incident(18, "Server DRC down", "abcdefgh", "High", "Hardware Issues", "New", 532, "Neha", "IT");
		
		java.util.List<Incident> list = new ArrayList<>();
		list.add(incident1);
		list.add(incident2);
		
		when(inciDao.findAll()).thenReturn(list);
		
		assertThat(inciservice.getIncidents()).isEqualTo(list);
		
	}
	
	@Test
	void testGetIncident() {
		
		Optional<Incident> incident = Optional.of(new Incident(101, "CPU heated", "abcdefgh", "High", "Hardware Issues", "New", 550, "Neha", "IT"));
		long id = incident.get().getId();
		System.out.println("id = " + id);
		
		// Even Though the function getincident returns the Incident created we are defining what 
		// .findById() returns for better code comprehension
		when(inciDao.findById(id)).thenReturn(incident);
		
		assertThat(inciservice.getincident(id)).isEqualTo(incident);
	}
	
	@Test
	void createIncidentTest()
	{
		Incident incident = new Incident(122, "CPU heated", "abcdefgh", "High", "Hardware Issues", "New", 550, "Neha", "IT");
		
		// Even Though the function createIncident returns the Incident created we are defining what 
		// .save() returns for better code comprehension
		when(inciDao.save(incident)).thenReturn(incident);
		
		assertThat(inciservice.createIncident(incident)).isEqualTo(incident);
	}
	
	@Test
	void updateIncidentTest()
	{
//		Original incident that remains untouched to be compared
		Incident origInci = new Incident(800, "System 331 Not working", "abcdefgh", "High", "Hardware Issues", "New", 550, "Neha", "IT");
		
//		Incident to be Updated
		Incident actualInci = new Incident(800, "System 331 Not working", "abcdefgh", "High", "Hardware Issues", "New", 550, "Neha", "IT");
		
		inciDao.save(origInci);
		
		actualInci.setInciPriority("Low");
		actualInci.setUserName("Chetna");
		
		
		assertThat(inciservice.updateIncident(actualInci)).isEqualTo(actualInci).isNotEqualTo(origInci);
	}
	
	@Test
	void deleteIncidentTest()
	{
		Incident incident = new Incident(800, "System 331 Not working", "abcdefgh", "High", "Hardware Issues", "New", 550, "Neha", "IT");
		inciDao.save(incident);
		
		inciservice.deleteIncident(incident.getId());
		
		assertThat(inciDao.findById(incident.getId())).isEmpty();
	}

}
