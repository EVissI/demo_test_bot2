package com.example.demo_test_bot2.database.repository;

import com.example.demo_test_bot2.database.models.Promo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromoServiceRepository extends MongoRepository<Promo, String> {
    boolean existsByPromoService(String promoService);
    boolean existsByPromoLink(String promoLink);
    List<Promo> findAllByPromoService(String promoService);
    List<Promo> findAllByPromoLink(String promoLink);
}