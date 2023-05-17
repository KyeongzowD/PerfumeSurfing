package com.perfume.surfing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class PerfumeNote {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERFUME_NOTE_ID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PERFUME_ID")
    private Perfume perfume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="NOTE_ID")
    private Note note_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NOTE_TYPE", nullable = false)
    private NoteType note_type;

    @Column(name = "update", nullable = false)
    private Date created_at;
}
