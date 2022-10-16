package dev.vorstu.database.entities.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.vorstu.database.entities.BaseEntity;
import dev.vorstu.database.entities.UserInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity extends BaseEntity {

    String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private ChatEntity chat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity user;

    @JsonProperty("chat_id")
    private void jsonSetChat(Long chat_id) {
        this.chat = new ChatEntity();
        chat.setUniqueId(chat_id);
    }

    @JsonProperty("user_id")
    private void jsonSetUser(Long user_id) {
        this.user = new UserInfoEntity();
        user.setUniqueId(user_id);
    }
}
