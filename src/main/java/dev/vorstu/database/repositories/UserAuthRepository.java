package dev.vorstu.database.repositories;

import dev.vorstu.database.entities.auth.UserAuthEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserAuthRepository extends CrudRepository<UserAuthEntity, Long> {
    Set<UserAuthEntity> findAll();
    UserAuthEntity findByUsername(String username);
}
