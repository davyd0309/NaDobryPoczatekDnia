package pl.dawydiuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
public class NaDobryPoczatekDniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaDobryPoczatekDniaApplication.class, args);
	}
}
