package myProject.num1;

import myProject.num1.config.Config;
import myProject.num1.repository.PerfumeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(Config.class)
@SpringBootApplication(scanBasePackages = "myProject.num1.controller")
public class Num1Application {

	public static void main(String[] args) {
		SpringApplication.run(Num1Application.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(PerfumeRepository perfumeRepository) {
		return new TestDataInit(perfumeRepository);
	}
}
