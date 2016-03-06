
import java.io.*;
import java.util.*; 

/*
 * Phone directory
 */
public class PhoneDirectory {
	
	String num;
	/*
	 * @param number the number to be added for that entry 

	 */
	public void addEntry(String name, String number){
		Properties prop = new Properties(); 
		try{

			OutputStream outStream = new FileOutputStream("src/main/resources/phone.properties", true); 

			prop.setProperty(name, number);
			prop.store(outStream, null);
			outStream.close();
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}

	
	
	/*

	 * @param  name  an absolute URL giving the base location of the image
	 *
	 */
	public void deleteEntry(String name){
		Properties prop = new Properties(); 
		try{

			InputStream inStream = new FileInputStream("src/main/resources/phone.properties");
			prop.load(inStream);
			prop.remove(name);
			inStream.close();
			OutputStream outStream = new FileOutputStream("src/main/resources/phone.properties"); 
			prop.store(outStream, null);
			outStream.close();
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	/*
	 * @param  name  an absolute URL giving the base location of the image
	 * @return      the image at the specified URL
	 */

		
	public String getNumber(String name){
		try{	
			Properties prop = new Properties();
			InputStream input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(input);
			num = prop.getProperty(name);
			input.close();
			return num;
		}
		catch (IOException ex){
			ex.printStackTrace();
			return "";
		}
		
		
	}
	
	/*
	 * @param number the number to be added for that entry 
	 * @param  name  an absolute URL giving the base location of the image
	 * @return      the image at the specified URL
	 */
	
	public void changeEntry(String name, String number){
		Properties prop = new Properties(); 
		try{

			InputStream inStream = new FileInputStream("src/main/resources/phone.properties");
			prop.load(inStream);
			prop.replace(name, number);
			inStream.close();
			OutputStream outStream = new FileOutputStream("src/main/resources/phone.properties"); 
			prop.store(outStream, null);
			outStream.close();
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		
	}

	


	
}
