package com.example.registration.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.registration.form.FormData;

@Controller
public class RegistrationController {
  
  @PostMapping( "/register" )
  public String register(
      @RequestParam( "name" ) String name,
      @RequestParam( "password" ) String password,
      @RequestParam( "gender" ) int gender,
      @RequestParam( "area" ) int area,
      @RequestParam( "interest" ) int[] interests,
      @RequestParam( "remarks" ) String remarks,
      Model model
      ) {
    
    StringBuilder sb = new StringBuilder();
    sb.append( "名前：" + name );
    sb.append( ", パスワード：" + password );
    sb.append( ", 性別：" + gender );
    sb.append( ", 地域：" + area );
    sb.append( ", 興味のある分野：" + Arrays.toString( interests ) );
    sb.append( ", 備考：" + remarks.replaceAll( "\n", "" ) );
    
    model.addAttribute( "registData", sb.toString() );
    return "result";
  }
  
  
  
  @PostMapping( "/register2" )
  public String register2( @ModelAttribute FormData formData, Model model ) {
    StringBuilder sb = new StringBuilder();
    sb.append( "名前：" + formData.getName() );
    sb.append( ", パスワード：" + formData.getPassword() );
    sb.append( ", 性別：" + formData.getGender() );
    sb.append( ", 地域：" + formData.getArea() );
    sb.append( ", 興味のある分野：" + Arrays.toString( formData.getInterests() ) );
    sb.append( ", 備考：" + formData.getRemarks().replaceAll( "\n", "" ) );
    model.addAttribute( "registData", formData );
    return "result";
  }

}
