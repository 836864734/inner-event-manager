package leoli.eventer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application Starter
 *
 * @author leoli
 * @date 2020/2/26
 */
@SpringBootApplication(scanBasePackages = {"leoli.eventer"})
public class EventerApplication {

    public static void main(String[] args) {

        SpringApplication.run(EventerApplication.class, args);

    }

}