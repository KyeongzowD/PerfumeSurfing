package SearchPerfume;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Perfume {
    @Id @GeneratedValue
    @Column(name="PERFUME_ID")
    private int id;

    private String name;

    private String name_en;

    private int price;

    private String url;

    //이미지

    @Column(name="Perfume_update")
    private Date created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BRAND_ID")
    private Brand brand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
