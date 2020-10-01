package com.capg.omts.sreen_show.service;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.capg.omts.sreen_show.exception.InValidIdException;
import com.capg.omts.sreen_show.exception.InValidNameException;
import com.capg.omts.sreen_show.model.Screen;
import com.capg.omts.sreen_show.util.Constants;
/**
 * ScreenServiceImplTest class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class ScreenServiceImplTest {
    @Autowired
	IScreenService screenService;

	
	Screen screen;
	
	@BeforeAll
	void initScreen() {
		
		screen =new Screen(75437,"vimal",10,10);
		screenService.addScreen(screen);
	}
	
	@Test
	@Order(3)
	void testAddScreen() {
		Screen screenSent=new Screen(89764,"Ranga",10,10);
		Screen screenOut=screenService.addScreen(screenSent);
		
		assertEquals(screenSent, screenOut);
	}

	

	@Test
	@Order(4)
	void testGetScreenById() {
		
		assertTrue(screenService.getScreenById(75437)!=null);
	}

	@Test
	@Order(5)
	void testGetAllScreens() {
		System.err.println("screenService.getAllScreens()");
		assertTrue(screenService.getAllScreens()!=null);
	}

	
	@Test
	@Order(6)
	@Transactional
	void testUpdateScreen() {
		Screen screenSent=new Screen(75437,"Bhujanga",10,10);

		Screen updated=screenService.updateScreen(screenSent);
		System.err.println(updated+"after test updated");
		Screen myEntity = (Screen) Hibernate.unproxy( updated );
		assertEquals(screenSent, myEntity);//excepted,actual
	}

	@Test
	@Order(7)
	void testDeleteByScreenId() {
		assertTrue(screenService.deleteByScreenId(75437)&&
		screenService.deleteByScreenId(89764));
	}

	@Test
	@Order(1)
	void testIsValidScreenId() {
		assertTrue(screenService.isValidScreenId(screen.getScreenId()));
		//assertTrue(screenService.isValidScreenId(75437));
		
	}		
	@Test
	@Order(2)
	void testIsValidScreenName() {
		assertTrue(screenService.isValidScreenName(screen.getScreenName()));
		//assertTrue(screenService.isValidScreenName("Imax"));
		
	}
	@Test
	@Order(8)
	void testInValidScreenId() {
		
	Exception exception =assertThrows(InValidIdException.class, ()->{screenService.isValidScreenId(123);});
	String exceptedMessage=Constants.INVALID_SCREENID;
	String actualMessage=exception.getMessage();
	
	
		assertFalse(!actualMessage.contains(exceptedMessage));
	}
	
	@Test
	@Order(9)
	void testInValidScreenName() {
	
		
	Exception exception =assertThrows(InValidNameException.class, ()->{screenService.isValidScreenName("ai");});
	String exceptedMessage=Constants.INVALID_SCREEN_NAME;
	String actualMessage=exception.getMessage();
	
	assertFalse(!actualMessage.contains(exceptedMessage));
	}
	
}




