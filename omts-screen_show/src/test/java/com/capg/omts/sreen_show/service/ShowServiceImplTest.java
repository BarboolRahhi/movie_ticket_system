package com.capg.omts.sreen_show.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.capg.omts.sreen_show.exception.IdAlreadyExistsException;
import com.capg.omts.sreen_show.exception.InValidIdException;
import com.capg.omts.sreen_show.exception.InValidNameException;
import com.capg.omts.sreen_show.exception.InValidTimeException;
import com.capg.omts.sreen_show.model.Screen;
import com.capg.omts.sreen_show.model.Show;
import com.capg.omts.sreen_show.util.Constants;

/**
 * ShowServiceImplTest class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class ShowServiceImplTest {

    @Autowired
	IShowService showService;

	
	Show show;
	
	@BeforeAll
	void initshow()  throws IdAlreadyExistsException {
	
		show =new Show(73486,"Morning Show",LocalDateTime.of(2020,10,02,11,00,00),LocalDateTime.of(2020,10,02,14,00,00));
		showService.addShow(show);
	}
	
	@Test
	@Order(7)
	void testAddshow() {
		Show showSent=new Show(87643,"Matinee Show",LocalDateTime.of(2020,10,02,14,00,00),LocalDateTime.of(2020,10,02,17,00,00));
		Show showOut=showService.addShow(showSent);
		
		assertEquals(showSent, showOut);
	}

	

	@Test
	@Order(8)
	void testGetshowById() {
		
		assertTrue(showService.getShowById(73486)!=null);
	}

	@Test
	@Order(9)
	void testGetAllshows() {
		assertTrue(showService.getAllShows()!=null);
	}

	
	@Test
	@Order(10)
	@Transactional
	void testUpdateshow() {
		Show showSent=new Show(73486,"First Show",LocalDateTime.of(2020,10,02,18,00,00),LocalDateTime.of(2020,10,02,21,00,00));
		

Show updated=showService.updateShow(showSent);
System.err.println(updated+"after test updated");
Show myEntity = (Show) Hibernate.unproxy( updated );
		
		assertEquals(showSent, myEntity);
	}

	@Test
	@Order(11)
	void testDeleteByshowId() {
		assertTrue(showService.deleteByShowId(73486)&&
		showService.deleteByShowId(87643));
	}

	@Test
	@Order(1)
	void testIsValidshowId() {
		
		assertTrue(showService.isValidShowId(show.getShowId()));
	}
	
	@Test
	@Order(2)
	void testIsValidshowName() {
		
		assertTrue(showService.isValidShowName(show.getShowName()));
	}
	@Test
	@Order(3)
	void testIsValidshowTime() {
		
		assertTrue(showService.isValidShowTime(LocalDateTime.of(2020,10,02,11,00,00),LocalDateTime.of(2020,10,02,14,30,00)));
	}
	@Test
	@Order(4)
	void testInValidshowId() {
		Exception exception =assertThrows(InValidIdException.class, ()->{showService.isValidShowId(123);});
		String exceptedMessage=Constants.INVALID_SHOWID;
		String actualMessage=exception.getMessage();
		
		
			assertFalse(!actualMessage.contains(exceptedMessage));
	}
	
	@Test
	@Order(5)
	void testInValidshowName() {
		
		Exception exception =assertThrows(InValidNameException.class, ()->{showService.isValidShowName("ai");});
		String exceptedMessage=Constants.INVALID_SHOW_NAME;
		String actualMessage=exception.getMessage();
		assertFalse(!actualMessage.contains(exceptedMessage));
	}
	@Test
	@Order(6)
	void testInValidshowTime() {
		
		Exception exception =assertThrows(InValidTimeException.class, 
		()->{showService.isValidShowTime(LocalDateTime.of(2020,10,02,11,00,00),LocalDateTime.of(2020,10,02,18,30,00));});
		String exceptedMessage=Constants.INVALID_SHOW_TIME;
		String actualMessage=exception.getMessage();
		assertFalse(!actualMessage.contains(exceptedMessage));
	}
	
}
