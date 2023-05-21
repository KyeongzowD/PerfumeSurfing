package com.perfume.surfing.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Setter @Getter
public class Perfume {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERFUME_ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "URL")
    private String url;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IMAGE_ID")
    private Image image_id;

    @Column(name = "UPDATE", nullable = false)
    private Date created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BRAND_ID")
    private Brand brand_id;
}
