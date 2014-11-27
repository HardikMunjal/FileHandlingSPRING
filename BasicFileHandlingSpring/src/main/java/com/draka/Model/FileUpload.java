/*
FileUpload.java
A model, which is used in transfering file from user's computer to server.
*/
 package com.draka.Model;
 
 import org.springframework.web.multipart.MultipartFile;
 
 public class FileUpload {
   MultipartFile file;
 
   public MultipartFile getFile() {
     return file;
   }
 
   public void setFile(MultipartFile file) {
     this.file = file;
   }
 
 }