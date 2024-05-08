package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Product;
import vn.codegym.model.ProductType;

import java.util.List;
import java.util.Optional;

public interface IProductTypeService {
    List<ProductType> findAll();

    Page<ProductType> findAll(Pageable pageable);

    void save(ProductType productType);

    Optional<ProductType> findById(Long id);

    void remove(Long id);
}
