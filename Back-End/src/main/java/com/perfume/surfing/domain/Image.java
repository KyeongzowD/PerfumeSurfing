package com.perfume.surfing.domain;


import jakarta.persistence.*;
import lombok.Getter;

@Embeddable
@Getter
public class Image {
    @Column(name = "IMAGE_NAME")
    private String name;

    @Column(name = "IMAGE_PATH")
    private String path;

    // 기본 생성자 제한
    protected Image(){}

    public Image(String name, String path){
        this.name = name;
        this.path = path;
    }

    //    @Enumerated(EnumType.STRING)
//    @Column(name = "TYPE", nullable = false) // PERFUME, NOTE
//    private WordType type;

//    @Column(name = "CREATED_AT", nullable = false, updatable = false)
//    private Date created_at;
//
//    @Column(name = "UPDATED_AT", nullable = false)
//    private Date updated_at;

}
