package nhathuoclankha;

import nhathuoclankha.startup.StartUpApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.PortInUseException;

@SpringBootApplication
public class NhathuoclankhaApplication implements CommandLineRunner {
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
  public void run(String... args) throws Exception {
    startUpApplication.resgisterApplicationAutoStartup();
    startUpApplication.openBrowser();
    startUpApplication.initUser();

  }


}
