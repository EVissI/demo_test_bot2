package com.example.demo_test_bot2.database.Manager;

import com.example.demo_test_bot2.database.models.Promo;
import com.example.demo_test_bot2.database.repository.PromoServiceRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DatabaseManager {
    private final PromoServiceRepository promoServiceRepository;

    public DatabaseManager(PromoServiceRepository promoServiceRepository) {
        this.promoServiceRepository = promoServiceRepository;
    }

    public List<Promo> doesServiceExist(String word) {
        if (promoServiceRepository.existsByPromoService(word)){
            return promoServiceRepository.findAllByPromoService(word);
        } else if (promoServiceRepository.existsByPromoLink(word)) {
            return promoServiceRepository.findAllByPromoLink(word);
        }else {
            return null;
        }
    }

}