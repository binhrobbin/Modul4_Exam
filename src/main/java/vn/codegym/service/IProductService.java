package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Product;
import vn.codegym.model.ProductType;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Optional<Product> findById(Long id);

    void remove(Long id);

    Iterable<Product> findAllByProductType(ProductType productType);


    Page<Product> findAllByNameContaining(Pageable pageable, String name);

}
