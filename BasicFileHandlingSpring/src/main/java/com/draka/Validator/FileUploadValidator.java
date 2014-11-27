package com.draka.Validator;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.draka.Model.FileUpload;

@Component
public class FileUploadValidator implements Validator {

  @Override
  public boolean supports(Class<?> arg0) {
    return arg0.isAssignableFrom(FileUpload.class);
  }

  @Override
  public void validate(Object arg0, Errors arg1) {
    FileUpload fileupload = (FileUpload) arg0;
    if (fileupload.getFile().isEmpty()) {
      arg1.rejectValue("file", null, "Please Choose a File");
    }

  }

}