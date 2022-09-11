package dev.vorstu.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class BaseEntity {
    @Id
    @Column(name = "uniqueId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;
}
