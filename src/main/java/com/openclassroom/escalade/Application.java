package com.openclassroom.escalade;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Application extends AbstractContextLoaderInitializer {

  @Override
  protected WebApplicationContext createRootApplicationContext() {
      AnnotationConfigWebApplicationContext rootContext
        = new AnnotationConfigWebApplicationContext();
      rootContext.register(PersistenceJPAConfig.class);
      return rootContext;
  }
}

