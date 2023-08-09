package com.perfume.surfing.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ForTestJsonAPI {

    private final ObjectMapper objectMapper;

    public ForTestJsonAPI(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true); // Enable Pretty Printer
    }

    @GetMapping
    public List<Perfume> getPerfume() {
        List<Perfume> list = new ArrayList<>();
        list.add(new Perfume());
        list.add(new Perfume());
        return list;
    }

    @Getter @Setter
    private static class Perfume {

        private String name;
        private String brand_name;
        private String price;
        private String url;
        private String image_url;
        private String brand_url;

        private List<Note> top_note_list;
        private List<Note> middle_note_list;
        private List<Note> base_note_list;
        private List<Note> single_note_lis;

        Perfume(){
            setName("떼 마차 26");
            setBrand_name("르라보");
            setPrice("200,000");
            setUrl("https://www.lelabofragrances.co.kr/th-matcha-26-1186.html?size=15ml");
            setImage_url("https://lelabokorea-java.s3.amazonaws.com/images/skus/J34001R000__Product_01--IMG_1200--THMATCHA26--180362882.jpg");
            setBrand_url("https://www.lelabofragrances.co.kr/?utm_medium=paid_search_brand&utm_source=naver&utm_campaign=brandname_brand-awareness&utm_content=lelabo07_jul_always-on_prospects_brandsearch_pc_homelink&utm_term=%EB%A5%B4%EB%9D%BC%EB%B3%B4");

            top_note_list = new ArrayList<>();
            middle_note_list = new ArrayList<>();
            base_note_list = new ArrayList<>();
            single_note_lis = new ArrayList<>();

            String[]top = "무화과".split(" ");
            for(String s: top) {
                Note note = new Note(s, "https://yt3.ggpht.com/G7CfrklDXQeBGsNwv8E3TeshPuHEyyLGWAC_412ONzVHrr5eixE2F4geNBaE7q0KM4l1tFZnYZlaKA=s640-nd-v1");
                top_note_list.add(note);
            }

            String[] mid = "비터 오렌지".split(" ");
            for(String s: mid) {
                Note note = new Note(s,"https://yt3.ggpht.com/G7CfrklDXQeBGsNwv8E3TeshPuHEyyLGWAC_412ONzVHrr5eixE2F4geNBaE7q0KM4l1tFZnYZlaKA=s640-nd-v1");
                middle_note_list.add(note);
            }

            String[] base = "베티버 시더우드".split(" ");
            for(String s: base) {
                Note note = new Note(s, "https://yt3.ggpht.com/G7CfrklDXQeBGsNwv8E3TeshPuHEyyLGWAC_412ONzVHrr5eixE2F4geNBaE7q0KM4l1tFZnYZlaKA=s640-nd-v1");
                base_note_list.add(note);
            }

            String[] single = "".split(" ");
            for(String s: single) {
                Note note = new Note(s, "https://yt3.ggpht.com/G7CfrklDXQeBGsNwv8E3TeshPuHEyyLGWAC_412ONzVHrr5eixE2F4geNBaE7q0KM4l1tFZnYZlaKA=s640-nd-v1");
                single_note_lis.add(note);
            }
        }

        @Setter @Getter
        private static class Note{
            private String note_name;
            private String image_url;

            Note(){}

            Note(String note_name, String image_url){
                this.note_name = note_name;
                this.image_url = image_url;
            }
        }
    }
}
