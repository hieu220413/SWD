package fpt.asignment.estate_trading_system.entity;

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

    @JsonProperty("min_price")
    @Column(name = "min_price")
    private int minPrice;

    @JsonProperty("max_price")
    @Column(name = "max_price")
    private int maxPrice;

    @JsonProperty("available_quantity")
    @Column(name = "available_quantity")
    private int availableQuantity;

    @JsonProperty("status")
    @Column(name = "status")
    private byte status;

}
