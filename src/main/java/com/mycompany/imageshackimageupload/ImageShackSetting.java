/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageshackimageupload;

/**
 *
 * @author sunil
 */
public class ImageShackSetting
{
   private String token;   // image shack private token to make private api calls
   private String apiKey;  // api key is a private variable, only used to make upload image call to the imageshack server
   private String baseUrl; // base url of image shack api
   private Double maxAllowedSizeInKB; //to restrict by max allowed file size

   public ImageShackSetting(String token, String apiKey, String baseUrl, Double maxAllowedSizeInKB)
   {
      this.token = token;
      this.apiKey = apiKey;
      this.baseUrl = baseUrl;
      this.maxAllowedSizeInKB = maxAllowedSizeInKB;
   }

   public String getApiKey()
   {
      return apiKey;
   }

   public void setApiKey(String apiKey)
   {
      this.apiKey = apiKey;
   }

   public String getBaseUrl()
   {
      return baseUrl;
   }

   public void setBaseUrl(String baseUrl)
   {
      this.baseUrl = baseUrl;
   }

   public Double getMaxAllowedSizeInKB()
   {
      return maxAllowedSizeInKB;
   }

   public void setMaxAllowedSizeInKB(Double maxAllowedSizeInKB)
   {
      this.maxAllowedSizeInKB = maxAllowedSizeInKB;
   }

   public String getToken()
   {
      return token;
   }

   public void setToken(String token)
   {
      this.token = token;
   }
}
