

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.lang.Exception;



/*
 * validate format is "dd/MM/yyyy"
 * empry string return false   / raise
 */

//validate that date dd/MM/yyyy in time window: today-90d 
public class ValidateTimeFormat{
	
		public static boolean convertFormat(String strDate) {
			if (strDate.trim().equals(""))
			{
			    return false;
			}
			/* Date is not 'null' */
			else
			{
			   
			    SimpleDateFormat sdfrmt = new SimpleDateFormat(strDate);
			    sdfrmt.setLenient(false);
			   
			    try
			    {
			        Date javaDate = sdfrmt.parse(strDate); 
			        System.out.println(strDate+" is valid date format");
			    }
			    /* Date format is invalid */
			    catch (ParseException e)
			    {
			        System.out.println(strDate+" is Invalid Date format");
			        return false;
			    }
			    /* Return true if date format is valid */
			    return true;
			}
					
			
		}
		
	
		public static boolean validateDataFormat(String strDate, String format) throws Exception {
			
			
			if (strDate.trim().equals(""))
			{
			    return false;
			}
			/* Date is not 'null' */
			else
			{
			   
			    SimpleDateFormat sdfrmt = new SimpleDateFormat(format);
			    sdfrmt.setLenient(false);
			   
			    try
			    {
			        Date javaDate = sdfrmt.parse(strDate); 
			        System.out.println(strDate+" is valid date format");
			    }
			    /* Date format is invalid */
			    catch (ParseException e)
			    {
			        System.out.println(strDate+" is Invalid Date format");
			        return false;
			    }
			    /* Return true if date format is valid */
			    return true;
			}
					
		}
	
	   public static boolean validateInlast90d(String strDate) throws Exception{
		   if (! validateJavaDate(strDate) ) {
			   System.out.println(strDate+" is Invalid Date format");
		       return false;
		   }
		   
		   SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		   Date javaDate = sdfrmt.parse(strDate);
		   Date today = new Date(System.currentTimeMillis());
		   Date tm_now = Date.from(ZonedDateTime.now().toInstant());
		   Date tm90 = Date.from(ZonedDateTime.now().minusDays(90).toInstant());
	 
		   if(javaDate.after(tm_now)) {
			   System.out.println("future date");
			   return false;
		   }
					   
		   if(javaDate.after(tm90)) {
			   System.out.println("Is in the range on 90's days" + " " + javaDate + " " + tm90 );
			   return true;
		   }
			   System.out.println("90's days has passed!");
			   return false;
	   }
	
	  
	   public static boolean validateJavaDate(String strDate)
	   {
		/* Check if date is 'null' */
		if (strDate.trim().equals(""))
		{
		    return false;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try
		    {
		        Date javaDate = sdfrmt.parse(strDate); 
		        System.out.println(strDate+" is valid date format");
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        System.out.println(strDate+" is Invalid Date format");
		        return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
	   }
	   
	   
	   
	   public static void main(String args[]) throws Exception{
		
		 if (! validateJavaDate("29/12/2016")) {
			 throw new Exception("MY ASSERT");
		 }
		 if(!validateJavaDate("29/12/2016")) {
			 throw new Exception("My asseret2");
		 }
		 System.out.println(validateJavaDate("29/12/2016"));
         System.out.println(validateJavaDate("29/12/2016"));
         System.out.println(!validateJavaDate("29-12-2016"));
         System.out.println(!validateJavaDate("29:12:2016"));
         System.out.println(!validateJavaDate(" "));
         System.out.println(! validateJavaDate("asadasds"));
         System.out.println(validateInlast90d("01/01/2022"));
         System.out.println(validateInlast90d("01/02/2022"));
         System.out.println(validateInlast90d("01/02/2023"));
         
 
	     System.out.println(validateDataFormat("01/01/2022", "dd/MM/yyyy"));
	     System.out.println(convertFormat("01.01.2021"));
         
         
	   }

	   
}