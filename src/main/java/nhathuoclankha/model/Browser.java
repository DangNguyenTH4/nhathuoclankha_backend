package nhathuoclankha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Browser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String pathToBrowser = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"; //userChose or admin setup
  private String domain = "nhathuoclankha.com"; //nhathuoclankha
  private String protocol ="http"; // http / https
  private String port = "6868"; //6868
}
