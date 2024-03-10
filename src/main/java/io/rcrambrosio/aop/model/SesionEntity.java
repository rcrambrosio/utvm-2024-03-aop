package io.rcrambrosio.aop.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @apiNote Clase entidad para almacenar las sesiones
 * @author rcrambrosio
 * @since 1.0.0
 */
@Entity
public class SesionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143377949378555591L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "VARCHAR(36)")
	private UUID sesion;
	private LocalDateTime dateCreation;
	private LocalDateTime dateExpiration;
	private UserEntity idUserEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getSesion() {
		return sesion;
	}

	public void setSesion(UUID sesion) {
		this.sesion = sesion;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(LocalDateTime dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public UserEntity getIdUserEntity() {
		return idUserEntity;
	}

	public void setIdUserEntity(UserEntity idUserEntity) {
		this.idUserEntity = idUserEntity;
	}

}
