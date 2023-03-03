package fpt.asignment.estate_trading_system.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonProperty("users")
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private Users users;

    @JsonProperty("tag_list")
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tagList;

    @JsonProperty("image_list")
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(name = "post_image",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private List<Image> imageList;

    @JsonProperty("subscription_list")
    @OneToMany(
            mappedBy = "post"
    )
    private List<Subscription> subscriptionList;

    @JsonProperty("title")
    @Column(name = "title")
    private String title;

    @JsonProperty("content")
    @Lob
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @JsonProperty("area")
    @Column(name = "area")
    private int area;

    @JsonProperty("estate_price")
    @Column(name = "estate_price")
    private long estatePrice;


    @JsonProperty("status")
    @Column(name = "status")
    private byte status;
}
