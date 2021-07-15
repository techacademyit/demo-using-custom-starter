package techacademy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class DemoApplication {


	@Autowired
	ProductProxy proxy;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
