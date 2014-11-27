package com.draka.Controller;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.draka.Model.FileUpload;
import com.draka.Validator.FileUploadValidator;


@Controller
public class FileUploadController {


    @Autowired
    FileUploadValidator validator;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show(Locale locale, Model model) {
        return "fileuploadform";
    }


    @RequestMapping(value = "/savefile", method = RequestMethod.POST)
    public String saveFile(@ModelAttribute("myfile") FileUpload fileupload,
            BindingResult br, Model model, HttpServletRequest request) {
        try {
            validator.validate(fileupload, br);
            if (br.hasErrors()) {
                return "fileuploadform";
            }
            String filename = fileupload.getFile().getOriginalFilename();
            InputStream is = fileupload.getFile().getInputStream();
            String applicationpath = request.getSession().getServletContext()
                    .getRealPath("");
            FileOutputStream fos = new FileOutputStream(applicationpath + "//"
                    + filename);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = is.read(bytes)) != -1) {
                fos.write(bytes, 0, read);
            }
            is.close();
            fos.close();
            model.addAttribute("message", "File Upload Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fileuploadform";
    }
}