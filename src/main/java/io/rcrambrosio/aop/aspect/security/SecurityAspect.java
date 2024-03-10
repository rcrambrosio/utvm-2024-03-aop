package io.rcrambrosio.aop.aspect.security;

import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.rcrambrosio.aop.service.AuthService;

/**
 * @apiNote Clase Aspect que permite implementar advices Around para ejemplificar escenarios ad hoc.
 * @author rcrambrosio
 * @since 1.0.0
 */
@Aspect
@Component
public class SecurityAspect {

	@Autowired
	private AuthService authService;

	/**
	 * @implNote Aspecto que permite evaluar la sesión durante la ejecución de algún método expuesto que solicite la sesión
	 * 			 en este caso el método de validateAOPSesion
	 * @param sesion Identificador de la sesion
	 * @return ResponseEntity
	 */
	@SuppressWarnings("unchecked")
	@Around("execution(* io.rcrambrosio.aop.controller.AuthController.validateAOPSesion(..)) && args(sesion)")
    public ResponseEntity<String> aroundValidateSesion(ProceedingJoinPoint joinPoint, String sesion) throws Throwable {
        System.out.println("Executing @Around method");
        if (!authService.validateSesion(UUID.fromString(sesion))) {
            return new ResponseEntity<>("Invalid Session!", HttpStatus.FORBIDDEN);
        } else {
            // Si la sesión es válida, permitir que el método objetivo se ejecute
            return (ResponseEntity<String>) joinPoint.proceed();
        }
    }
	
	@Before("execution(* io.rcrambrosio.aop.controller.AuthController.validateAOPSesion(..)) && args(sesion)")
    public void beforeValidateSesionWithArg(JoinPoint joinPoint, String sesion) {
        System.out.println("Before method execution: Logging session validation with session: " + sesion);
    }

}
