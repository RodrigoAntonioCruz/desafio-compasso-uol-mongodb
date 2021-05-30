package com.compasso.uol.services;

import com.compasso.uol.models.Product;
import com.compasso.uol.models.dto.ProductDTO;
import com.compasso.uol.repositories.ProductRepository;
import javax.persistence.EntityNotFoundException;

import com.compasso.uol.repositories.specs.products.ProductSpecification;
import com.compasso.uol.utils.exceptions.ObjectNotFoundException;
import com.compasso.uol.utils.sequenceGeneratorId.SequenceGeneratorId;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.compasso.uol.models.Product.SEQUENCE_NAME;

/**
 *
 * @author Rodrigo da Cruz
 * @version 1.0
 * @since 2021-05-25
 *
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final SequenceGeneratorId sequenceGeneratorId;

    @Autowired
    private final ProductSpecification productSpecification;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Pageable pageable) {
           Page<Product> list =  productRepository.findAll(pageable);
        return list.map(ProductDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findSearch(Pageable pageable, String q, Double min_price, Double max_price) {
        return productSpecification.findSearch(pageable, q.toUpperCase(),  min_price,  max_price);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
           Optional<Product> object = productRepository.findById(id);
           Product product = object.orElseThrow(() -> new ObjectNotFoundException("Objeto solicitado não encontrado!"));
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO insert(ProductDTO object) {
           Product product = new Product();
           product.setId(sequenceGeneratorId.getSequenceNumber(SEQUENCE_NAME));
           product.setName(object.getName());
           product.setDescription(object.getDescription());
           product.setPrice(object.getPrice());
           product = productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO object) {
        try {
            Optional<Product> entity = productRepository.findById(id);
            Product product = entity.get();
            product.setName(object.getName());
            product.setDescription(object.getDescription());
            product.setPrice(object.getPrice());
            product = productRepository.save(product);
            return new ProductDTO(product);
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException("Objeto solicitado não encontrado!");
        }
    }

    public void delete(Long id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            if (product.get().getId() != null) {
                productRepository.deleteById(id);
            }
        }catch (RuntimeException e){
            throw new ObjectNotFoundException("Objeto solicitado não encontrado!");
        }
    }
}
