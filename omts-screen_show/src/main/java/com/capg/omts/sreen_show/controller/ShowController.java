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

import com.capg.omts.sreen_show.model.Show;
import com.capg.omts.sreen_show.service.IShowService;
/**
 * ShowController class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@RestController
@RequestMapping("/show")
@CrossOrigin(origins= {"http://localhost:4200"})
public class ShowController {
	
	@Autowired
	IShowService showService;
	/***************************************************************************************************************
	 * Accepts Show As Input Parameter and sends it to service layer for  adding Show into database
	 ***************************************************************************************************************/
	@PostMapping("/add")
	public  ResponseEntity<Show> addShow(@RequestBody Show show) {
		System.err.println("recevied"+show);
		return new ResponseEntity<Show>(showService.addShow(show), HttpStatus.CREATED); 
		
	}
	/***************************************************************************************************************
	 * Accepts Show As Input Parameter and sends it to service layer for  updating Show in the database
	 ***************************************************************************************************************/
	@PutMapping("/update")
	public  ResponseEntity<Show> updateShow(@RequestBody Show show) {
		return  new ResponseEntity<Show>(showService.updateShow(show),HttpStatus.ACCEPTED);
		}
	
	/***************************************************************************************************************
	 * Accepts showId As Input Parameter and sends it to service layer for  fetching a particular Show from database
	 ***************************************************************************************************************/
	
	@GetMapping("/showById/{id}")
	public   ResponseEntity<Show> getShowById(@PathVariable("id") int showId) {
		return  new ResponseEntity<Show>(showService.getShowById(showId),HttpStatus.OK);
		}
	/***************************************************************************************************************
	 * Fetch all Shows from database through calling service layer  getAllShows method
	 ***************************************************************************************************************/
	@GetMapping("/all")
	public ResponseEntity<List<Show>> getAllShows(){
	
		
		return new ResponseEntity<List<Show>> (showService.getAllShows(),HttpStatus.OK);
		
	}
	/***************************************************************************************************************
	 * Accepts showId As Input Parameter and sends it to service layer for  deleting a particular Show  which is present in database
	 ***************************************************************************************************************/
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByShowId(@PathVariable("id") int showId) {
	boolean flag=	showService.deleteByShowId(showId);
	if(flag)
		return new ResponseEntity<String> ("Show successfully deleted from database with requested Id :"+showId,HttpStatus.OK); 
	else
	 return new ResponseEntity<String> (" deletion cannot be performed as show not present in database with requested Id :"+showId,HttpStatus.NOT_FOUND);
		}

}
