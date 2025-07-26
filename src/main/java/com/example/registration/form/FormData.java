package com.example.registration.form;

import lombok.Data;

@Data
public class FormData {
  
  private String name;
  private String password;
  private int gender;
  private int area;
  private int[] interests;
  private String remarks;

}
