package com.perfume.surfing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter @Getter
public class Perfume {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERFUME_ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private int price;

    @Column(name = "URL", nullable = false)
    private String url;

    @Column(name = "IMAGE_NAME", nullable = false)
    private String image_name;
    @Column(name = "IMAGE_PATH", nullable = false)
    private String image_path;

    @Column(name = "update", nullable = false)
    private Date created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BRAND_ID")
    private Brand brand;
}
