package com.perfume.surfing.domain;

import jakarta.persistence.*;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IMAGE_ID")
    private Image image_id;

    @Column(name = "CREATE_AT", nullable = true)
    private Date created_at;

    @OneToMany(mappedBy = "note")
    private List<PerfumeNote> perfumeNotes;

}
