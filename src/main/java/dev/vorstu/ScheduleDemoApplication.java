package dev.vorstu;

import dev.vorstu.database.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScheduleDemoApplication {

	private static Initializer initiator;

	@Autowired
	public void setInitialLoader(Initializer initiator) {
		ScheduleDemoApplication.initiator = initiator;
	}
	public static void main(String[] args) {
		SpringApplication.run(ScheduleDemoApplication.class, args);
		initiator.initial();
	}

}
