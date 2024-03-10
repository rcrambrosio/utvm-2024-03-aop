package io.rcrambrosio.aop.service;

import java.util.UUID;

import io.rcrambrosio.aop.vo.AuthVO;

/**
 * @apiNote Interface para realizar procesos de autenticación de usuarios
 * @author rcrambrosio
 * @since 1.0.0
 */
public interface AuthService {
	
	String authenticateUser(AuthVO userRequest);
	
	boolean validateSesion(UUID sesion);

}
