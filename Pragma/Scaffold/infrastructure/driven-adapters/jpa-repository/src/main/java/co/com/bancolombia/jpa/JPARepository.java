package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigInteger;
import java.util.Optional;

public interface JPARepository extends CrudRepository<UserEntity, Long>, QueryByExampleExecutor<UserEntity> {
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByEmail(String email);
}
