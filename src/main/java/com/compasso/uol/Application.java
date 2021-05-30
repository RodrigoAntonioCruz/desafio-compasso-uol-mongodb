package com.compasso.uol;

import com.compasso.uol.models.Product;
import com.compasso.uol.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        this.productRepository.deleteAll();

        for (int i=0; i < 1000; i++) {
            Product product = new Product();
            product.setId((long) i++);
            product.setName("Nome " + i++ + " produto " + i++);
            product.setDescription("Uma descrição " + i++ + " de um produto teste " + i++ + " gerado pela API-REST de forma automática " + i++);
            product.setPrice(i++ * 2.65);
            productRepository.save(product);
        }
    }
}
