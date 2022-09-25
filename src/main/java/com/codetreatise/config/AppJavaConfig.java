/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codetreatise.config;

import com.codetreatise.logging.ExceptionWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppJavaConfig {

  @Autowired
  private ApplicationContext context;

  /**
   * Useful when dumping stack trace to a string for logging.
   * @return ExceptionWriter contains logging utility methods
   */
  @Bean
  @Scope("prototype")
  public ExceptionWriter exceptionWriter() {
    return new ExceptionWriter(new StringWriter());
  }

  @Bean
  public ResourceBundle resourceBundle() {
    return ResourceBundle.getBundle("Bundle");
  }

  @Bean
  public SpringFXMLLoader springFXMLLoader() {
    return new SpringFXMLLoader(context, resourceBundle());
  }

  @Bean
  @Lazy
  public StageManager stageManager(Stage stage) throws IOException {
    return new StageManager(springFXMLLoader(), stage);
  }
}
