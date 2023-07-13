package com.perfume.surfing.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORD_ID")
    private int id;

    @Column(name = "ALIAS", nullable = false)
    private String alias;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private WordType type;

    @Column(name = "NAME_ID", nullable = false)
    private int name_id;
}
