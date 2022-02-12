package genericUtility;

import java.util.Random;
/**
 * This class contains java specific generic method
 * @author Akash
 */

public class JavaUtility {

	/**
	 * This method generates Random number
	 * @return
	 */
	public int getRadomNUm()
	{
		
		Random random= new Random();
		int value= random.nextInt(1000);
		return value;
	}
}