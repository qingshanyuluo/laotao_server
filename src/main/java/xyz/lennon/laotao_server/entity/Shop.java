package xyz.lennon.laotao_server.entity;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "t_shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private Integer cost;

    @Column
    private Integer rankStar;

    @Column
    private String type;

    @Column
    private Integer liked;

    @Column
    private Integer uploaderId;
}
