package com.crm.autodesk.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Abhi
 *
 */
public class FileUtility {
	
	/**
	 *    used to get data from property file based on key
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws Throwable  {
		  
			FileInputStream fis = new FileInputStream(IConstant.commonDataFilePath);
			 Properties pObj = new Properties();
			 pObj.load(fis);
			 String value = pObj.getProperty(key);
		
		return value;
	}

}