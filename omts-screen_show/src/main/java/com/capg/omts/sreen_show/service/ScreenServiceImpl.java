/**
	* Project Name : Online Movie Ticket System
	*
	* 
**/
package com.capg.omts.sreen_show.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.omts.sreen_show.exception.InValidIdException;
import com.capg.omts.sreen_show.exception.InValidNameException;
import com.capg.omts.sreen_show.exception.IdAlreadyExistsException;
import com.capg.omts.sreen_show.exception.IdNotExistsException;
import com.capg.omts.sreen_show.model.Screen;
import com.capg.omts.sreen_show.repository.IScreenRepo;
import com.capg.omts.sreen_show.util.Constants;

/**
 * ScreenServiceImpl class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@Service
//@Transactional
public class ScreenServiceImpl implements IScreenService {
    
	//private static final 
	Logger logger = LoggerFactory.getLogger(ScreenServiceImpl.class);
	
	@Autowired
	IScreenRepo screenRepo;
	
	/***************************************************************************************************************
	 * -FunctionName : addScreen()
	 * -Input Parameters : Screen Object 
	 * -Return Type :Screen
	 * -Throws : IdAlreadyExistsException
	 * -Description : Adding Screen to database
	 ***************************************************************************************************************/
	@Override
	public Screen addScreen(Screen screen)
	{
		isValidScreenId(screen.getScreenId());
		isValidScreenName(screen.getScreenName());
		 if(!screenRepo.existsById(screen.getScreenId())) {
			
			 return screenRepo.saveAndFlush(screen);
			
			
		}
		 else {
			 logger.info("hello Already" +screen.getScreenId());
			 throw new IdAlreadyExistsException(Constants.SCREEN_ALREADY_EXISTS+screen.getScreenId());
		 }
		
		 
		

	
	 }
	
		
		
	/***************************************************************************************************************
	 * -FunctionName : updateScreen() 
	 * -Input Parameters : Screen Object 
	 * -Return Type : Screen 
	 * -Throws : IdNotExistsException
	 *  -Description : Updating Screen in database
	 ***************************************************************************************************************/

	@Override
	
	public Screen updateScreen(Screen screen) {
		System.err.println("Hello Screen Service Update ");
		isValidScreenId(screen.getScreenId());
		isValidScreenName(screen.getScreenName());
		
			    if(screenRepo.existsById(screen.getScreenId())) {
			    	System.err.println("Before Screen Service Update"+screenRepo.getOne(screen.getScreenId()));
			    	Screen updateScreen=screenRepo.getOne(screen.getScreenId());
			    	updateScreen.setScreenName(screen.getScreenName());
			    	updateScreen.setRows(screen.getRows());
			    	updateScreen.setColumns(screen.getColumns());
			    	System.err.println("During Screen Service Update");
			    	Screen updatedScreen=screenRepo.save(screen);
			    	System.err.println(updatedScreen);
			    	System.err.println("After Screen Service Update");
				    return screenRepo.save(screen);
			    }
			    else
			        throw new  IdNotExistsException(Constants.SCREEN_NOT_EXISTS+screen.getScreenId());
			
	       
		
	
	}
	/************************************************************************************************************
	 * -FunctionName : deleteScreenById()
	 * -Input Parameters : screenId
	 * -Return Type: boolean
	 * -Throws : IdNotExistsException 
	 * -Description : Deleting Screen in database
	 ***************************************************************************************************************/

	@Override
	public boolean deleteByScreenId(int screenId) {
		  isValidScreenId(screenId) ;
		   
			  if(screenRepo.existsById(screenId)) {
				  System.err.println(" hello delete Id exists"+screenId);
				  screenRepo.deleteById(screenId);
				  return true;
			  }
			  else {
				  System.err.println(" hello delete Id Not exists"+screenId);
				  throw new IdNotExistsException(Constants.SCREEN_NOT_EXISTS+screenId);
			  }
		
		
		
	}

	/***************************************************************************************************************
	 * -FunctionName : getScreenById() 
	 * -Input Parameters : screenId 
	 * -Return Type :Screen 
	 * -Throws : IdNotExistsException 
	 * -Description : Fetches Screen from Database based on ScreenId
	 ***************************************************************************************************************/
	@Override
	public Screen getScreenById(int screenId) {
		  isValidScreenId(screenId) ;
		   
			  if(screenRepo.existsById(screenId)) {
				 return screenRepo.getOne(screenId);
			  }
			  else
				  throw new IdNotExistsException(Constants.SCREEN_NOT_EXISTS+screenId);
			    
		
		
		
		
	}

	/***************************************************************************************************************
	 * -FunctionName : getAllScreens()
	 *  -Input Parameters : No Input 
	 *  -Return Type : List of Screens 
	 *  -Throws : IdNotExistsException
	 *   -Description : Shows All the Screens present in Database
	 ***************************************************************************************************************/
	@Override
	public List<Screen> getAllScreens() {
	if(screenRepo.findAll().size()==0) {
		 throw new IdNotExistsException("NO SCREENS ARE AVAILABLE IN THEATRE");
	}
	System.err.println("GET ALL SCREENS IS CALLED");
//logger.info("These are "+screenRepo.findAll());
	return	screenRepo.findAll();
	}
	
	/***************************************************************************************************************
	 * -FunctionName : isValidScreenId() 
	 * -Input Parameters : screenId 
	 * -Return Type : Boolean 
	 * -Throws : InvalidIdException 
	 * -Description : Validates whether the ScreenId   5 digit and Starts with [1-9] 
	 ***************************************************************************************************************/

	@Override
	public boolean isValidScreenId(int screenId) {
		boolean flag=false;
		String screen = screenId + "";
		flag=screen.matches("[1-9][0-9]{4}");
		    if(flag)
			return flag;
		    else
		    	throw new InValidIdException(Constants.INVALID_SCREENID);
		
	}
	/***************************************************************************************************************
	 * -FunctionName : isValidScreenName() 
	 * -Input Parameters : screenName 
	 * -Return Type : Boolean 
	 * -Throws : InValidNameException 
	 * -Description : Validates whether the screenName is minimum 3 digit and maximum 15 digit or not 
	 ***************************************************************************************************************/
	@Override
	public boolean isValidScreenName(String screenName) {
		boolean flag=false;
		
		flag=screenName.matches("[A-Za-z ]{3,15}");
		    if(flag)
			return flag;
		throw new InValidNameException(Constants.INVALID_SCREEN_NAME);
		}
}
























//if(isValidScreenId(screen.getScreenId())) 
//{
//	    if(!screenRepo.existsById(screen.getScreenId())) 
//		    return screenRepo.saveAndFlush(screen);
//	    else
//	        throw new ScreenIdAlreadyExistsException("Screen   Already Exists with this screenId :"+screen.getScreenId())	;
//	}
// else	
//		throw new InvalidScreenIdException("ScreenId must be minimum 5 digit which Starts with 1");
