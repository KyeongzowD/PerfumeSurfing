package com.perfume.surfing.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BRAND_ID", nullable = false)
    private Brand brand;

    @Embedded
    private Image image;

    @OneToMany(mappedBy = "perfume")
    private List<Word> words = new ArrayList<>();

    @OneToMany(mappedBy = "perfume")
    private List<PerfumeNote> perfumeNotes = new ArrayList<>();

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date created_at;

    @Column(name = "UPDATED_AT", nullable = false)
    private Date updated_at;

    //==연관관계 메서드==//
    public void setWord(Word word){
        words.add(word);
        word.setPerfume(this);
    }

    public void setPerfumeNote(PerfumeNote perfumeNote){
        perfumeNotes.add(perfumeNote);
        perfumeNote.setPerfume(this);
    }

    public void setBrand(Brand brand){
        this.brand = brand;
        brand.getPerfumes().add(this);
    }
}
