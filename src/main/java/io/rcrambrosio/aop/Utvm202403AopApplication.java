package io.rcrambrosio.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.rcrambrosio.aop.model.UserEntity;
import io.rcrambrosio.aop.model.UserRepository;

/**
 * @apiNote Clase principal para ejecutar microservicio, implementa por defecto el alta de 5 usuarios para UserEntity
 * @author rcrambrosio
 * @since 1.0.0
 */
@SpringBootApplication
public class Utvm202403AopApplication {

	private static UserRepository userRepository;

	@Autowired
	public Utvm202403AopApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		
		SpringApplication.run(Utvm202403AopApplication.class, args);
		// Create default users
		for (int i = 1; i <= 5; i++) {
			UserEntity user = new UserEntity();
			user.setUserName("user" + i);
			user.setPassword("password" + i);
			user.setRole("admin");
			try {
				userRepository.save(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
