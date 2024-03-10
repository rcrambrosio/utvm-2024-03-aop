package io.rcrambrosio.aop.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.rcrambrosio.aop.service.AuthService;
import io.rcrambrosio.aop.vo.AuthVO;

/**
 * @apiNote Clase Controller que permite exponer métodos de autenticación
 * @author rcrambrosio
 * @since 1.0.0
 */
@RestController
@RequestMapping("/utvm/aop/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;

    /**
     * @implNote Método POST para realizar proceso de login
     * @param loginUser VO con credenciales de acceso
     * @return ResponseEntity
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthVO loginUser) {
        String sesion = authService.authenticateUser(loginUser);
        return new ResponseEntity<String>((sesion != null) ? sesion : "Error authentication!", HttpStatus.OK);
    }
    
    /**
     * @implNote Método GET para realizar proceso de validación de sesión sin aspectos
     * @param sesion Identificador de sesión UUID
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity<String> validateSesion(@RequestParam("sesion") String sesion) {
        if(authService.validateSesion(UUID.fromString(sesion))) {
        	return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    
    /**
     * @implNote Método GET para realizar proceso de validación de sesión con aspectos
     * @param sesion Identificador de sesión UUID
     * @return ResponseEntity
     */
    @GetMapping("/v2/validate")
    public ResponseEntity<String> validateAOPSesion(@RequestParam("sesion") String sesion) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
