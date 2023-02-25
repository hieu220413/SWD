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
public class Bundle {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonProperty("name")
    @Column(length = 255, name = "name")
    private String name;

    @JsonProperty("tier")
    @Column(name = "tier")
    private int tier;

    @JsonProperty("description")
    @Lob
    @Column(name = "description")
    private String description;

    @JsonProperty("price")
    @Column(name = "price")
    private int price;

    @JsonProperty("available")
    @Column(name = "available")
    private byte available;

    @JsonProperty("status")
    @Column(name = "status")
    private byte status;
}
