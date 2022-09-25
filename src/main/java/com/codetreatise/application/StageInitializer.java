package com.codetreatise.application;

import com.codetreatise.application.JFXApplication.StageReadyEvent;
import com.codetreatise.config.StageManager;
import com.codetreatise.view.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  public void onApplicationEvent(StageReadyEvent event) {
    applicationContext
      .getBean(StageManager.class, event.getStage())
      .switchScene(FxmlView.LOGIN);
  }
}
