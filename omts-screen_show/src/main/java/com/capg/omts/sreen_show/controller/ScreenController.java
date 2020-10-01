package com.capg.omts.sreen_show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.omts.sreen_show.model.Screen;
import com.capg.omts.sreen_show.model.Show;
import com.capg.omts.sreen_show.service.IScreenService;
/**
 * ScreenController class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@RestController
@RequestMapping("/screen")
@CrossOrigin(origins= {"http://localhost:4200"})
public class ScreenController {
	@Autowired
	IScreenService screenService;
	

	/***************************************************************************************************************
	 * Accepts Screen As Input Parameter and sends it to service layer for  adding Screen into database
	 ***************************************************************************************************************/
	@PostMapping("/add")
	public  ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {
		
		return new ResponseEntity<Screen>(screenService.addScreen(screen), HttpStatus.CREATED); 
		}
	
	/***************************************************************************************************************
	 * Accepts Screen As Input Parameter and sends it to service layer for  updating Screen in the database
	 ***************************************************************************************************************/
	
	
	@PutMapping("/update")
	public  ResponseEntity<Screen> updateScreen(@RequestBody Screen screen) {
		
		
		return new ResponseEntity<Screen>(screenService.updateScreen(screen), HttpStatus.ACCEPTED); 
		}
	
	
	
	/***************************************************************************************************************
	 * Accepts screenId As Input Parameter and sends it to service layer for  fetching a particular Screen from database
	 ***************************************************************************************************************/
	
	
	@GetMapping("/screenById/{id}")
	public   ResponseEntity<Screen> getScreenById(@PathVariable("id") int screenId) {
		
		return new ResponseEntity<Screen>(screenService.getScreenById(screenId), HttpStatus.OK); 
		
		}
	
	/***************************************************************************************************************
	 * Fetch all screens from database through calling service layer getAllScreens method
	 ***************************************************************************************************************/
	
	@GetMapping("/all")
	public List<Screen> getAllScreens(){
		
		return screenService.getAllScreens();
		}
	
	
	/***************************************************************************************************************
	 * Accepts screenId As Input Parameter and sends it to service layer for  deleting a particular Screen which is present in database
	 ***************************************************************************************************************/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByScreenId(@PathVariable("id") int screenId) {
	
		
		boolean flag=	screenService.deleteByScreenId(screenId);
		if(flag)
			return new ResponseEntity<String> ("Screen successfully deleted from database with requested Id :"+screenId,HttpStatus.OK); 
		else
		 return new ResponseEntity<String> (" deletion cannot be performed as screen not present in database with requested Id :"+screenId,HttpStatus.NOT_FOUND);
			
		}
	
	
	

}
