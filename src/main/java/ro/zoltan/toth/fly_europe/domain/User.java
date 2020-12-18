package ro.zoltan.toth.fly_europe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter private long id;

    @Column(name = "email")
    @Getter @Setter private String email;

    @Column(name = "password")
    @Getter @Setter private String password;

    @Column(name = "first_name")
    @Getter @Setter private String firstName;

    @Column(name = "last_name")
    @Getter @Setter private String lastName;

    @Column(name = "role")
    @Getter @Setter private String role;

}
