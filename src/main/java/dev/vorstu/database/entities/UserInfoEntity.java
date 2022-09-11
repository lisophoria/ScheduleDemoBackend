package dev.vorstu.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.vorstu.database.entities.auth.UserAuthEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="userInfo")
@Getter @Setter
@NoArgsConstructor
public class UserInfoEntity extends BaseEntity {

    public UserInfoEntity(String username, String firstname, String lastname, int age, UserAuthEntity authUser) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.authUser = authUser;
    }
    @Column(unique = true)
    private String username;
    private String firstname;
    private String lastname;
    private int age;

    @JsonIgnore
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "authUser", referencedColumnName = "uniqueId")
    private UserAuthEntity authUser;
}
