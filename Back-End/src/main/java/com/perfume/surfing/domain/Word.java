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
    private Long id;

    @Column(name = "ALIAS", nullable = false)
    private String alias;

    @Column(name = "NAME", nullable = false)
    private String name;

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




    //== 생성자 메서드 ==//
    // 기본 생성자 제한
    protected Word(){}

    // 생성자를 통해 객체를 생성할 때 WordType에 따라 매핑할 필드를 설정
    public Word(String name, String alias, WordType type) {
        this.name = name;
        this.alias = alias;
        this.type = type;
        setMappedFields();
    }


    //== 연관관계 메서드 ==//
    /**
     * WordType에 따라 Brand, Perfume, Note 필드 매핑
     * 매핑하지 않은 필드들을 null로 설정
     */
    private void setMappedFields() {
        switch (type) {
            case BRAND:
                setBrand();
                perfume = null;
                note = null;
                break;
            case PERFUME:
                setPerfume();
                brand = null;
                note = null;
                break;
            case NOTE:
                setNote();
                brand = null;
                perfume = null;
                break;
        }
    }

    /**
     * Brand 매핑
     * Perfume 매핑
     * Note 매핑
     */
    private void setBrand(){
        brand = null;
    }

    private void setPerfume() {
        perfume = null;
    }

    private void setNote() {
        note = null;
    }
}
