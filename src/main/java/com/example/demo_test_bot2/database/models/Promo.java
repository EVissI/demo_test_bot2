package com.example.demo_test_bot2.database.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "promo")
public class Promo {
    @Id
    private String id;

    private String promoName;
    private String promoService;
    private String promoLink;
    private Integer value;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public String getPromoService() {
        return promoService;
    }



    public Integer getValue() {
        return value;
    }

    public String getPromoLink() {return promoLink;}

    public String getId() {
        return id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public void setPromoService(String promoService) {this.promoService = promoService;}
    public void setPromoLink(String promoLink) {this.promoLink = promoLink;}

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }
}
