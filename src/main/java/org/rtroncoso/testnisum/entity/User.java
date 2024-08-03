package org.rtroncoso.testnisum.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.rtroncoso.testnisum.utils.Constants;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    @Email(regexp = Constants.EMAIL_PATTERN, message = "El email es invalido.")
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String token;

    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime last_login;

    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;
}
