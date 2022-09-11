package dev.vorstu.database.entities.auth;

import dev.vorstu.database.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity extends BaseEntity {
    private String username;
    @Enumerated(EnumType.STRING)
    private BaseRole role;
}
