/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageshackimageupload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author sunil
 */
public class UtilityClass
{
   public static String convertStreamToString(InputStream is) 
	{
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    try 
	    {
	        while ((line = reader.readLine()) != null) 
	        {
	            sb.append((line + "\n"));
	        }
	    }
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        try 
	        {
	            is.close();
	        }
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}
}
