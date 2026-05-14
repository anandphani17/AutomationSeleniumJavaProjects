package ExperimentsTemp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
		
		//Import Date class
		Date date = new Date();
		//Convert data to string 
		String dateString = date.toString();
		//Remove spaces from the date string by replacing
		String noSpaceDateString = dateString.replaceAll("\\s", "");
		String noSpaceandnoColonDateString = noSpaceDateString.replaceAll("\\:","");
		String emailWithTimeStamp = noSpaceandnoColonDateString+"@gmail.com";
		System.out.println(emailWithTimeStamp);
		
		
		
	}

}
