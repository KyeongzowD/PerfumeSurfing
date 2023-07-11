package com.perfume.surfing.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter @Setter
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "URL", length = 1000)
    private String url;

    @Column(name = "CREATED_AT", nullable = false)
    private Date created_at;
}
