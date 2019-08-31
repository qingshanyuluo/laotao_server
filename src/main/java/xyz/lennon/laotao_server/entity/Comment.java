package xyz.lennon.laotao_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Table(name = "t_commit")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Lob
    private String content;

    @Column
    private Integer liked;

    @Column
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Shop shop;

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Comment(String content, Integer liked, Long userId, Shop shop) {
        this.content = content;
        this.liked = liked;
        this.userId = userId;
        this.shop = shop;
    }

    public Comment() {

    }
}