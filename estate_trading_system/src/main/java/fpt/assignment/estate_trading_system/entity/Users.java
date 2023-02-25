package fpt.assignment.estate_trading_system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonProperty("username")
    @Column(length = 30, name = "username")
    private String username;

    @JsonProperty("password")
    @Column(length = 30, name = "password")
    private String password;

    @JsonProperty("full_name")
    @Column(length = 50, name = "full_name")
    private String fullName;

    @JsonProperty("role")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
    )
    private Role role;

    @JsonProperty("age")
    @Column(name = "age", columnDefinition = "TINYINT")
    private int age;

    @JsonProperty("gender")
    @Column(name = "gender")
    private byte gender;

    @JsonProperty("email")
    @Column(length = 255, name = "email")
    private String email;

    @JsonProperty("phone")
    @Column(length = 11, name = "phone")
    private String phone;

    @JsonProperty("avatar")
    @Lob
    @Column(name = "avatar")
    private String avatar;

    @JsonProperty("status")
    @Column(name = "status")
    private byte status;
}
