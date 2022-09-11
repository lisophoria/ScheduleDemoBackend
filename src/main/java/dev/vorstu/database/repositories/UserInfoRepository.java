package dev.vorstu.database.repositories;

import dev.vorstu.database.entities.UserInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Long> {
    UserInfoEntity findByUsername(String username);
}
