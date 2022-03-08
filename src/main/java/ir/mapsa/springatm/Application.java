package ir.mapsa.springatm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//@AllArgsConstructor
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }
}
