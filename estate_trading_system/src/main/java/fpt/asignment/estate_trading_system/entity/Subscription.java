package fpt.asignment.estate_trading_system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscription {
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonProperty("users")
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private Users users;

    @JsonProperty("post")
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "id"
    )
    private Post post;

    @JsonProperty("bundle")
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "bundle_id",
            referencedColumnName = "id"
    )
    private Bundle bundle;


    @JsonProperty("price")
    @Column(name = "price")
    private long price;

    @JsonProperty("expired_date")
    @Column(name = "expired_date")
    private Timestamp expiredDate;

    @JsonProperty("start_date")
    @Column(name = "start_date")
    private Timestamp startDate;

    @JsonProperty("status")
    @Column(name = "status")
    private byte status;

    public Subscription(Users users, Post post, Bundle bundle, long price, Timestamp expiredDate, Timestamp startDate, byte status) {
        this.users = users;
        this.post = post;
        this.bundle = bundle;
        this.price = price;
        this.expiredDate = expiredDate;
        this.startDate = startDate;
        this.status = status;
    }
}
