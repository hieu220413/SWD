package fpt.asignment.estate_trading_system.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UserCreateModel {
    @JsonProperty("username")
    @NotNull
    @Length(min = 4, max = 35)
    @Schema(example = "luugiavinh")
    private String username;

    @JsonProperty("password")
    @NotNull
    @Length(min = 8, max = 40)
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$",message="Password contains at least 8 characters, 1 digit, 1 lower alpha char and 1 upper alpha char.")
    @Schema(example = "123890Password")
    private String password;

    @JsonProperty("full_name")
    @NotNull
    @Length(min = 1, max = 40)
    @Schema(example = "Luu Gia Vinh")
    private String fullName;

    @JsonProperty("age")
    @NotNull
    @Min(value = 1)
    @Max(value = 120)
    @Schema(example = "20")
    private int age;

    @JsonProperty("gender")
    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Schema(example = "0", type = "integer")
    private byte gender;

    @JsonProperty("email")
    @NotNull
    @Pattern(regexp=".+\\@.+\\..+",message="Invalid email input")
    @Schema(example = "luugiavinh@gmail.com")
    private String email;

    @JsonProperty("phone")
    @NotNull
    @Length(min = 10, max = 11)
    @Schema(example = "1234567890")
    private String phone;

    @JsonProperty("avatar")
    @NotNull
    @Schema(example = "image.jpg")
    private String avatar;

}
