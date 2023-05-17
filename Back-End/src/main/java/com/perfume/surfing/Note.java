package com.perfume.surfing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTE_ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "IMAGE_NAME", nullable = false)
    private String image_name;
    @Column(name = "IMAGE_PATH", nullable = false)
    private String image_path;

    @Column(name = "update", nullable = false)
    private Date created_at;
}
