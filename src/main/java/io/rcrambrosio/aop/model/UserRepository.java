package io.rcrambrosio.aop.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @apiNote Interface para acceder a través de Repository a la entidad
 *          UserEntity vía JpaRepository
 * @author  rcrambrosio
 * @since   1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUserNameAndPassword(@Param(value = "userName") String userName,
			@Param(value = "password") String password);

}
