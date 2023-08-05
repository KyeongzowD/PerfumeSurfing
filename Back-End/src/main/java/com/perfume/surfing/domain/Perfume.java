package com.perfume.surfing.domain;

import jakarta.persistence.*;
import java.util.List;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "DISCONTINUE")
    private Discontinue discontinue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IMAGE_ID")
    private Image image_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BRAND_ID", nullable = false)
    private Brand brand_id; //brand

    @OneToMany(mappedBy = "perfume")
    private List<Word> words;

    @OneToMany(mappedBy = "perfume")
    private List<PerfumeNote> perfumeNotes;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date created_at;

    @Column(name = "UPDATED_AT", nullable = false)
    private Date updated_at;
}
