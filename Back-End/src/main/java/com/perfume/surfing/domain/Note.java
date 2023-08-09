package com.perfume.surfing.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter @Setter
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTE_ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "note")
    private List<PerfumeNote> perfumeNotes = new ArrayList<>();

    @OneToMany(mappedBy = "note")
    private List<Word> words = new ArrayList<>();

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date created_at;

    @Column(name = "UPDATED_AT", nullable = false)
    private Date updated_at;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="IMAGE_ID")
//    private Image image;


    //==연관관계 메서드==//
    public void setWord(Word word){
        words.add(word);
        word.setNote(this);
    }

    public void setPerfumeNote(PerfumeNote perfumeNote){
        perfumeNotes.add(perfumeNote);
        perfumeNote.setNote(this);
    }
}
