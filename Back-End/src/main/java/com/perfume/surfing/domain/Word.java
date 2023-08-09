package com.perfume.surfing.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORD_ID")
    private Long id;

    @Column(name = "ALIAS", nullable = false)
    private String alias;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "count", nullable = false)
    private Long count;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private WordType type;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", insertable = false, updatable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "PERFUME_ID", insertable = false, updatable = false)
    private Perfume perfume;

    @ManyToOne
    @JoinColumn(name = "NOTE_ID", insertable = false, updatable = false)
    private Note note;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date created_at;

    @Column(name = "UPDATED_AT", nullable = false)
    private Date updated_at;


    //== 생성자 메서드 ==//
    // 기본 생성자 제한
    protected Word(){}

    // 생성자를 통해 객체를 생성할 때 WordType에 따라 매핑할 필드를 설정
    public Word(String name, String alias, WordType type) {
        this.name = name;
        this.alias = alias;
        this.type = type;
    }

    //== 연관관계 메서드 ==//
    /**
     * 다형성
     * Brand 매핑
     * Perfume 매핑
     * Note 매핑
     */
    private void setEntity(Brand brand) {
        this.brand = brand;
        perfume = null;
        note = null;
    }

    private void setEntity(Perfume perfume){
        this.perfume =  perfume;
        brand = null;
        note = null;
    }

    private void setEntity(Note note) {
        this.note = note;
        brand = null;
        perfume = null;
    }



}
