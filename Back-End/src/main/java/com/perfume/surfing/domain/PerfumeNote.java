package com.perfume.surfing.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter @Setter
public class PerfumeNote {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERFUME_NOTE_ID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PERFUME_ID", nullable = false)
    private Perfume perfume_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="NOTE_ID", nullable = false)
    private Note note_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NOTE_TYPE", nullable = false)
    private NoteType note_type;

    @Column(name = "CREATED_AT", nullable = false)
    private Date created_at;
}
