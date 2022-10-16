package dev.vorstu.database.entities.chat;

import dev.vorstu.database.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chats")
@Getter @Setter
@NoArgsConstructor
public class ChatEntity extends BaseEntity {

    String name;

    @OneToMany(
            mappedBy = "chat",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MessageEntity> messages = new ArrayList<>();

    public ChatEntity(String name) {
        this.name = name;
    }
}
