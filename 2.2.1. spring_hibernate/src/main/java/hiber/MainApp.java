package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Userovich", "user@mail.ru");
      User user2 = new User("User2", "Userovich", "user@mail.ru");
      User user3 = new User("User3", "Userovich", "user@mail.ru");
      User user4 = new User("User4", "Userovich", "user@mail.ru");

      Car audi = new Car(7, "Audi");
      Car bmw = new Car(5, "BMW");
      Car kia = new Car(1, "Kia");
      Car landRover = new Car(1, "LandRover");

      userService.add(user1.setCar(audi).setUser(user1));
      userService.add(user2.setCar(bmw).setUser(user2));
      userService.add(user3.setCar(kia).setUser(user3));
      userService.add(user4.setCar(landRover).setUser(user4));


      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }


      System.out.println(userService.getUserCar("BMW", 5));

      context.close();
   }
}
