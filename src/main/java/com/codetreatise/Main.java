package com.codetreatise;

import com.codetreatise.application.JFXApplication;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

  public static void main(final String[] args) {
    Application.launch(JFXApplication.class, args);
  }
}
