package nhathuoclankha;

import nhathuoclankha.startup.StartUpApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.PortInUseException;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NhathuoclankhaApplication extends SpringBootServletInitializer implements CommandLineRunner {
  @Autowired
  private StartUpApplication startUpApplication;

  public static void main(String[] args) {
    try {
      SpringApplication.run(NhathuoclankhaApplication.class, args);
    }catch(PortInUseException ex){
      ex.printStackTrace();
      StartUpApplication startUpApplication = new StartUpApplication();
      startUpApplication.openDefaultBrowserWhenUserClickOpenApp();
    }
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(NhathuoclankhaApplication.class);
  } 
  @Override
  public void run(String... args) throws Exception {
    startUpApplication.resgisterApplicationAutoStartup();
    startUpApplication.openBrowser();
    startUpApplication.initUser();


  }


}
