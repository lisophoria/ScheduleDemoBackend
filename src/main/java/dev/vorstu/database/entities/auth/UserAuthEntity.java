package dev.vorstu.database.entities.auth;

import dev.vorstu.database.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class UserAuthEntity extends BaseEntity {
    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserAuthEntity(String username, boolean enabled, String password, Set<UserRoleEntity> roles) {
        this.username = username;
        this.enabled = enabled;
        this.password = passwordEncoder.encode(password);
        this.roles = roles;
    }

    @Column(unique = true)
    private String username;
    private boolean enabled;
    private String password;
    @OneToMany(cascade = {CascadeType.ALL},
        orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private Set<UserRoleEntity> roles;
}
