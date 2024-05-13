package umc.mission7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Mission7Application {

	public static void main(String[] args) {
		SpringApplication.run(Mission7Application.class, args);
	}

}
