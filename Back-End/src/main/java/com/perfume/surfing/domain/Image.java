package com.perfume.surfing.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGE_ID")
    private int id;

    @Column(name = "IMAGE_NAME")
    private String image_name;

    @Column(name = "IMAGE_PATH")
    private String image_path;

    @Column(name = "UPDATE", nullable = false)
    private Date created_at;
}
