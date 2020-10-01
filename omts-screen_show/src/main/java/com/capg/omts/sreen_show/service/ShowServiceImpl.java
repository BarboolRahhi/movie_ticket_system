/**
	* Project Name : Online Movie Ticket System
	*
	* 
**/

package com.capg.omts.sreen_show.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.omts.sreen_show.exception.IdAlreadyExistsException;
import com.capg.omts.sreen_show.exception.IdNotExistsException;
import com.capg.omts.sreen_show.exception.InValidIdException;
import com.capg.omts.sreen_show.exception.InValidNameException;
import com.capg.omts.sreen_show.exception.InValidTimeException;
import com.capg.omts.sreen_show.model.Show;
import com.capg.omts.sreen_show.repository.IShowRepo;
import com.capg.omts.sreen_show.util.Constants;
/**
 * ShowServiceImpl class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
@Service
public class ShowServiceImpl implements IShowService {
	Logger logger = LoggerFactory.getLogger(ShowServiceImpl.class);
	@Autowired
	IShowRepo showRepo;
	/***************************************************************************************************************
	 * -FunctionName : addShow()
	 * -Input Parameters : Show Object 
	 * -Return Type : Show
	 * -Throws : IdAlreadyExistsException
	 * -Description : Adding Show to database
	 ***************************************************************************************************************/

	@Override
	public Show addShow(Show show) {
		isValidShowId(show.getShowId());
	 isValidShowName(show.getShowName()) ;
		 if(!showRepo.existsById(show.getShowId())) {
			 return showRepo.saveAndFlush(show);}
		 else { System.err.println("hello Already");
			throw new IdAlreadyExistsException(Constants.SHOW_ALREADY_EXISTS+show.getShowId());
			
		}
		
		// System.out.println("hello isValid");
		
	}
	
	/***************************************************************************************************************
	 * -FunctionName : updateShow() 
	 * -Input Parameters : Show Object 
	 * -Return Type : Show 
	 * -Throws : IdNotExistsException
	 *  -Description : Updating Show in database
	 ***************************************************************************************************************/

	@Override
	
	public Show updateShow(Show show) {

		  isValidShowId(show.getShowId());
		  isValidShowName(show.getShowName()) ;
		   
		  isValidShowTime(show.getShowStartTime(),show.getShowEndTime());
			    if(showRepo.existsById(show.getShowId())) {
			    	Show updateShow=showRepo.getOne(show.getShowId());
			    	updateShow.setShowName(show.getShowName());
			    	updateShow.setShowStartTime(show.getShowStartTime());
			    	updateShow.setShowEndTime(show.getShowEndTime());
			   
				    return showRepo.saveAndFlush(show);
			    }
			    else
			        throw new  IdNotExistsException(Constants.SHOW_NOT_EXISTS+show.getShowId());
		
		
	
	}
	/************************************************************************************************************
	 * -FunctionName : deleteByShowId()
	 * -Input Parameters : showId
	 * -Return Type: boolean
	 * -Throws : IdNotExistsException 
	 * -Description : Deleting Show in database
	 ***************************************************************************************************************/
	@Override
	public boolean deleteByShowId(int showId) {
		  isValidShowId(showId); 
		   
			  if(showRepo.existsById(showId)) {
				  showRepo.deleteById(showId);
				  return true;
			  }
			  else
				  throw new IdNotExistsException(Constants.SHOW_NOT_EXISTS+showId);
			    
			
	}
	/***************************************************************************************************************
	 * -FunctionName : getShowById() 
	 * -Input Parameters : showId 
	 * -Return Type :Show 
	 * -Throws : IdNotExistsException 
	 * -Description : Fetches Show from Database based on showId
	 ***************************************************************************************************************/
	@Override
	public Show getShowById(int showId) {
		  isValidShowId(showId) ;
		   
			  if(showRepo.existsById(showId)) {
				 return showRepo.getOne(showId);
			  }
			  else
				  throw new IdNotExistsException(Constants.SHOW_NOT_EXISTS+showId);
			    
			
	}
	/***************************************************************************************************************
	 * -FunctionName : getAllShows()
	 *  -Input Parameters : No Input 
	 *  -Return Type : List of Shows 
	 *  -Throws : IdNotExistsException
	 *   -Description : Shows All the Shows present in Database
	 ***************************************************************************************************************/

	@Override
	
	public List<Show> getAllShows() {
		if(showRepo.findAll().size()==0) {
			 throw new IdNotExistsException("NO SHOWS ARE AVAILABLE IN THEATRE");
			
		}
		System.err.println("GET ALL SHOWS IS CALLED");
//		logger.info("These are All Shows"+showRepo.findAll());
		
		return	showRepo.findAll();
	}
	/***************************************************************************************************************
	 * -FunctionName : isValidShowId() 
	 * -Input Parameters : showId 
	 * -Return Type : Boolean 
	 * -Throws : InvalidIdException 
	 * -Description : Validates whether the showId   5 digit and Starts with [1-9] 
	 ***************************************************************************************************************/
	@Override
	public boolean isValidShowId(int showId) {
		boolean flag=false;
		String show = showId + "";
		flag=show.matches("[1-9][0-9]{4}");
		    if(flag)
			return flag;
		    else
		    	throw new InValidIdException(Constants.INVALID_SHOWID);
	}
	/***************************************************************************************************************
	 * -FunctionName : isValidShowName() 
	 * -Input Parameters : showName 
	 * -Return Type : Boolean 
	 * -Throws : InValidNameException 
	 * -Description : Validates whether the showName is minimum 3 digit and maximum 15 digit or not 
	 ***************************************************************************************************************/
	@Override
	public boolean isValidShowName(String showName) {
		boolean flag=false;
		
		flag=showName.matches("[A-Za-z ]{3,15}");
		    if(flag)
			return flag;
		throw new InValidNameException(Constants.INVALID_SHOW_NAME);
		}
	/***************************************************************************************************************
	 * -FunctionName : isValidShowTime() 
	 * -Input Parameters : showStartTime ,showEndTime
	 * -Return Type : Boolean 
	 * -Throws : InValidTimeException 
	 * -Description : Validates whether showStartTime  is before showEndTime 
	 * and duration of time is between  2 to 4 hours or not
	 ***************************************************************************************************************/
	
	@Override
	public  boolean isValidShowTime(LocalDateTime showStartTime,LocalDateTime showEndTime)
	{
		
		
		if(showStartTime.isBefore(showEndTime)&&showStartTime.isAfter(LocalDateTime.now())) 
		{
			
			
		Duration diff=	Duration.between(showStartTime, showEndTime);
			   
		    if (diff.isZero()) 
		    {
		        System.out.println("0 minutes");
		    } 
		    else 
		        {
		                   long days = diff.toDays();
		              if (days != 0) 
		              {
		            System.out.print("" + days + " days ");
		            diff = diff.minusDays(days);
		                }
		                    long hours = diff.toHours();
		              if (hours != 0) 
		                 {
		            System.out.print("" + hours + " hours ");
		            
                    //System.out.println(hours==3);
		                        if(hours>2 && hours<4)
		                        {
		            	       System.out.println("caluculated duration");
		            	        return true;
		            	         }
		           
		                  }
		            System.out.println();
		          }
			//return true;
		}
			
		
			throw new InValidTimeException(Constants.INVALID_SHOW_TIME);
		
		
	}


	

}
