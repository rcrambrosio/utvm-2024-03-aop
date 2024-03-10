package io.rcrambrosio.aop.aspect.monitoring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @apiNote Clase Aspect que permite implementar advices After y Around para ejemplificar escenarios ad hoc.
 * @author rcrambrosio
 * @since 1.0.0
 */
@Aspect
@Component
public class MonitoringAspect {

	/**
	 * @implNote Aspecto que permite escribir un log cuando se ejecuta el método save en la implementación de repository de JPA
	 * @param returnValue Objeto correspondiente a la ejecución del método save en alguna interface configurada como
	 * 					  repository.
	 */
	@AfterReturning(pointcut = "execution(* *..*Repository.save*(..))", returning = "returnValue")
	public void afterReturning(Object returnValue) {
		System.out.println("Executing @AfterReturning method!");
	}

	/**
	 * @implNote Aspecto que permite evaluar la salud de nuestra aplicación para determinar si 
	 * 			 existe algún problema e informar el estatus correspondiente.
	 * @param joinPoint punto de ejecución del aspecto
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* io.rcrambrosio.aop..*(..))")
	public Object validarSalud(ProceedingJoinPoint joinPoint) throws Throwable {
		// Verificar la salud de la aplicación aquí antes de continuar con la ejecución
		// del método

		// Por ejemplo, si la aplicación está sana, permitir la ejecución normal del
		// método
		// De lo contrario, devolver un ResponseEntity con HttpStatus.SERVICE_UNAVAILABLE
		if (healthCheck()) {
			return joinPoint.proceed(); // Continuar con la ejecución del método
		} else {
			return new ResponseEntity<>("Application it's not running ok!", HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	/**
	 * @implNote Método que evalua la salud de nuestra aplicación
	 * @return boolean Estatus de salud de nuestra aplicación
	 */
	private boolean healthCheck() {
		// Implementar la lógica de verificación de la salud de la aplicación aquí
		// Por ejemplo, verificar la disponibilidad de recursos, conexiones a bases de
		// datos, etc.
		// Devuelve true si la aplicación está saludable, de lo contrario, devuelve
		// false
		return true;
	}

}
