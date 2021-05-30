package com.compasso.uol.repositories;

import com.compasso.uol.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo da Cruz
 * @version 1.0
 * @since 2021-05-25
 *
 */

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
