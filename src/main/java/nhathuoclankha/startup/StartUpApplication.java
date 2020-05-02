package nhathuoclankha.startup;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import nhathuoclankha.auth.model.User;
import nhathuoclankha.auth.repository.UserRepository;
import nhathuoclankha.factory.Factory;
import nhathuoclankha.model.Browser;
import nhathuoclankha.repository.BrowserRepository;
import nhathuoclankha.utils.RoleConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartUpApplication {

  @Autowired
  UserRepository userRepository;
  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  private BrowserRepository browserRepository;

  /**
   *
   */
  public void initUser() {
    // Khi chương trình chạy
    // Insert vào csdl một user.
    User user = userRepository.findByUsername("dangadmin");

    if (user == null) {
      user = Factory.getUserInstant();
      user.setUsername("dangadmin");
      user.setRole(RoleConstant.ROLEADMIN);
      user.setPassword(passwordEncoder.encode("dangadmin"));
      userRepository.save(user);
    }
    User user2 = userRepository.findByUsername("dangadmin2");
    if (user2 == null) {
      user2 = Factory.getUserInstant();
      user2.setUsername("dangadmin2");
      user2.setPassword(passwordEncoder.encode("dangadmin2"));
      user2.setRole(RoleConstant.ROLEADMIN);
      userRepository.save(user2);
    }
    User user3 = userRepository.findByUsername("lankha");
    if (user3 == null) {
      user3 = Factory.getUserInstant();
      user3.setUsername("lankha");
      user3.setPassword(passwordEncoder.encode("hieuthuoclankha@123"));
      user3.setRole(RoleConstant.ROLEADMIN);
      userRepository.save(user3);
    }
    User user4 = userRepository.findByUsername("nhanvien1");
    if (user4 == null) {
      user4 = Factory.getUserInstant();
      user4.setUsername("nhanvien1");
      user4.setPassword(passwordEncoder.encode("nhanvien1@123"));
      user4.setRole(RoleConstant.ROLESTAFF);
      userRepository.save(user4);
    }
    
    User accountantDefaultUser = userRepository.findByUsername("ketoan");
    if(accountantDefaultUser == null) {
    	accountantDefaultUser = Factory.getUserInstant();
    	accountantDefaultUser.setUsername("ketoan");
    	accountantDefaultUser.setPassword(passwordEncoder.encode("ketoan1"));
    	accountantDefaultUser.setRole(RoleConstant.ROLEACCOUNTANT);
    	userRepository.save(accountantDefaultUser);
    }
  }

  /**
   * Auto open google chrome with path : http://nhathuoclankha.com:80
   */
  public void openBrowser() {
    Optional<Browser> browserOpt = browserRepository.findById(1);

    if (browserOpt.isPresent()) {
      try {
        Browser browser = browserOpt.get();
        String domain = String
            .format("%1$s://%2$s:%3$s", browser.getProtocol(), browser.getDomain(), browser.getPort());
        log.info(">>> domain: {}",domain);
        ProcessBuilder pb = new ProcessBuilder(browser.getPathToBrowser(), domain);
        pb.start();
      } catch (IOException e) {
        log.error(">>> Can not open browser: {},{}", browserOpt.get().getPathToBrowser(),
            browserOpt.get().getDomain());
      }
    } else {
      log.error(">>> Can not find Browser with id 1");
    }

  }

  public void openDefaultBrowserWhenUserClickOpenApp(){
    Browser browser = new Browser();
    try {
      String domain = String
          .format("%1$s://%2$s:%3$s", browser.getProtocol(), browser.getDomain(), browser.getPort());
      log.info(">>> domain: {}",domain);
      ProcessBuilder pb = new ProcessBuilder(browser.getPathToBrowser(), domain);
      pb.start();
    } catch (IOException e) {
      log.error(">>> Can not open browser: {},{}", browser.getPathToBrowser(),
          browser.getDomain());
    }
  }

  public void resgisterApplicationAutoStartup() {

    List<Browser> browsers = browserRepository.findAll();
    if (browsers == null || browsers.size() == 0) {
      log.info(">>> dont have any browser list. Init one...");
      Browser browser = new Browser();
      browser.setId(1);
      browserRepository.save(browser);
    }
  }

}
