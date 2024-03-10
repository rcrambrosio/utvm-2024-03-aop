package io.rcrambrosio.aop.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rcrambrosio.aop.model.SesionEntity;
import io.rcrambrosio.aop.model.SesionRepository;
import io.rcrambrosio.aop.model.UserEntity;
import io.rcrambrosio.aop.model.UserRepository;
import io.rcrambrosio.aop.vo.AuthVO;

/**
 * @apiNote Implementación para realizar procesos de autenticación de usuarios
 * @author rcrambrosio
 * @since 1.0.0
 */
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SesionRepository sesionRepository;


	@Override
	public String authenticateUser(AuthVO userRequest) {
		Optional<UserEntity> user = userRepository.findByUserNameAndPassword(userRequest.getUserName(),
				userRequest.getPassword());
		if(user.isPresent()) {
			LocalDateTime now = LocalDateTime.now();
			SesionEntity newSesion = new SesionEntity();
			newSesion.setDateCreation(now);
			newSesion.setDateExpiration(now.plusMinutes(15));
			newSesion.setSesion(UUID.randomUUID());
			newSesion.setIdUserEntity(user.get());
			newSesion = sesionRepository.save(newSesion);
			return newSesion.getSesion().toString();
		}
		return null;
	}


	@Override
	public boolean validateSesion(UUID sesion) {
		return (sesionRepository.findBySesion(sesion).isPresent());
	}
}
