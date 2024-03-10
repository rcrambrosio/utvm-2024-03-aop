package io.rcrambrosio.aop.model;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @apiNote Interface para acceder a través de Repository a la entidad
 *          SesionEntity vía JpaRepository
 * @author  rcrambrosio
 * @since   1.0.0
 */
@Repository
public interface SesionRepository extends JpaRepository<SesionEntity, Long> {
	
	Optional<SesionEntity> findBySesion(@Param(value = "sesion")UUID sesion);

}
