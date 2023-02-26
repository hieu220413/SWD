package fpt.asignment.estate_trading_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import fpt.asignment.estate_trading_system.entity.Role;
import fpt.asignment.estate_trading_system.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class UserModel {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("username")
    @Schema(example = "luugiavinh")
    private String username;

    @JsonProperty("full_name")
    @Schema(example = "Luu Gia Vinh")
    private String fullName;

    @JsonProperty("role")
    private Role role;

    @JsonProperty("age")
    @Schema(example = "20")
    private int age;

    @JsonProperty("gender")
    @Schema(example = "0", type = "integer")
    private byte gender;

    @JsonProperty("email")
    @Schema(example = "luugiavinh@gmail.com")
    private String email;

    @JsonProperty("phone")
    @Schema(example = "1234567890")
    private String phone;

    @JsonProperty("avatar")
    @Schema(example = "image.jpg")
    private String avatar;

    @JsonProperty("status")
    @Schema(example = "1", type = "integer")
    private byte status;

    public UserModel(Users userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.fullName = userEntity.getFullName();
        this.role = userEntity.getRole();
        this.age = userEntity.getAge();
        this.gender = userEntity.getGender();
        this.email = userEntity.getEmail();
        this.phone = userEntity.getPhone();
        this.avatar = userEntity.getAvatar();
        this.status = userEntity.getStatus();
    }
}
