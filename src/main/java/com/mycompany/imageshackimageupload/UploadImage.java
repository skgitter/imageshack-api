/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageshackimageupload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author sunil
 */

public class UploadImage
{
   private static String token = "b27d9069c22901a99f1b67fd38b8c57b";
   private static String apiKey="478DEFMT1cb089d6e965064e7672eb0474611e91";
   private static String baseUrl="https://api.imageshack.com/v2/images";
   
   public static void main(String[] g) throws UnsupportedEncodingException, IOException
   {
      ImageShackSetting settings = new ImageShackSetting(token, apiKey, baseUrl,2048.0);
      A2ZImageShackFile imgFile = new A2ZImageShackFile(new File("/home/sunil/Downloads/ikc-screenshot-new.jpg"),null,null,false, null);
      if(isFileSizeValid(imgFile.getFile(),settings.getMaxAllowedSizeInKB()))
      {
         String strRes = uploadFileToImageShack(settings, imgFile);
         System.out.println(strRes);
      }
      else
      {
         System.out.println("Image size is too big to upload.");
         //Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE,null,"Image size is too big to upload.");
      }
   }
   
   private static  boolean isFileSizeValid(File file,Double maxSize)
   {
      boolean validFlag = true;
      double bytes = file.length();
      double kbytes = bytes/1024;
      if(kbytes>maxSize)
      {
         validFlag = false;
      }
      return validFlag;
   }
   
   private static String uploadFileToImageShack(ImageShackSetting settings, A2ZImageShackFile imgFile)
   throws IOException
   {
      //get settings param
      String API_KEY = settings.getApiKey();
      String AUTH_TOKEN = settings.getToken();
      String BASE_URL = settings.getBaseUrl();
      
      //get file properties
      File file = imgFile.getFile();
      
      String fileName = file.getName();
      
      //remove .jpg, .png etc extension at last of image to get exact file name
      System.out.println(fileName.indexOf("."));
      if(fileName.indexOf(".")!=-1)
      {
         fileName = fileName.substring(0,fileName.indexOf("."));
      }
      
      String title = imgFile.getTitle();
      String description = imgFile.getDescription();
      String album = imgFile.getAlbumIdOrTitle();
      Boolean isPublic = imgFile.getPublicFlag();
      
      String finalResponse = null;
         HttpClient httpclient = new DefaultHttpClient();
         HttpPost httppost = new HttpPost(BASE_URL);
         
         System.out.println("getAbsolutePath"+file.getAbsolutePath());
         System.out.println("getCanonicalPath"+file.getCanonicalPath());
         System.out.println("file name"+file.getName());
         System.out.println("is file"+file.isFile());
         
         ContentBody cb = new FileBody(file);
         MultipartEntityBuilder builder = MultipartEntityBuilder.create();
         builder.addPart("file",cb); // file required
         builder.addTextBody("api_key", API_KEY);
         builder.addTextBody("auth_token", AUTH_TOKEN);
         
         if(title!=null && !title.isEmpty())
         {
            builder.addTextBody("title",title);//title is required
         }
         else
         {
            builder.addTextBody("title",fileName);//title is required
         }
         
         //sending description
         if(description!=null && !description.isEmpty())
         {
            builder.addTextBody("description",description);//title is required
         }
         
         //sending public flag default is true
         if(!isPublic)
         {
            builder.addTextBody("public",String.valueOf(isPublic));//title is required
         }
         
         //sending public flag default is true
         if(album!=null && !album.isEmpty())
         {
            builder.addTextBody("album",album);//title is required
         }
         httppost.setEntity(builder.build());
         System.out.println("executing request " + httppost.getRequestLine());
         
         HttpResponse response = httpclient.execute(httppost);
         
         HttpEntity resEntity = response.getEntity();
         InputStream istrm = resEntity.getContent();
         finalResponse= UtilityClass.convertStreamToString(istrm);
         
         return finalResponse;
   }
}
