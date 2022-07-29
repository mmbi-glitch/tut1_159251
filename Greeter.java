import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.*;

public class Greeter {

  private Locale locale;
  private String name;

  public Greeter(String language, String country, String name) {
    locale = new Locale(language, country);
    this.name = name;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + "_" + name + "_"; // feature #2: add markdown formatting to emphasize name
  }

  public static void main(String[] args) {
    // issue #1: check length of args
    if (args.length == 3) {
      String language = args[0];
      String country = args[1];
      String name = args[2];
      Greeter greeter = new Greeter(language, country, name);
      System.out.println(greeter.sayHello());  
    }
    else {
      Logger.getGlobal().warning("Too few arguments!");
    }
  }
}
