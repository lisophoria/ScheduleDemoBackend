package dev.vorstu.database.repositories;

import dev.vorstu.database.entities.chat.ChatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends CrudRepository<ChatEntity, Long> {
    List<ChatEntity> findAll();
    ChatEntity findByUniqueId(Long id);
}
