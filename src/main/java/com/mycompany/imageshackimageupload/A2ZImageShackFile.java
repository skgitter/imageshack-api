/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageshackimageupload;

import java.io.File;

/**
 *
 * @author sunil
 */
public class A2ZImageShackFile
{
   private File file;  
   private String title;       // title of the image, if not given image name will sent as image title
   private String description; // description abut the image
   private Boolean PublicFlag=true; // wheather image will be available publically or not default is public
   private String albumIdOrTitle;   //to upload image in a saperate album

   public A2ZImageShackFile(File file, String title, String description, Boolean PublicFlag, String albumIdOrTitle)
   {
      this.file = file;
      this.title = title;
      this.description = description;
      this.PublicFlag = PublicFlag;
      this.albumIdOrTitle = albumIdOrTitle;
   }

   public Boolean getPublicFlag()
   {
      return PublicFlag;
   }

   public void setPublicFlag(Boolean PublicFlag)
   {
      this.PublicFlag = PublicFlag;
   }

   public String getAlbumIdOrTitle()
   {
      return albumIdOrTitle;
   }

   public void setAlbumIdOrTitle(String albumIdOrTitle)
   {
      this.albumIdOrTitle = albumIdOrTitle;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public File getFile()
   {
      return file;
   }

   public void setFile(File file)
   {
      this.file = file;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }
   
}
