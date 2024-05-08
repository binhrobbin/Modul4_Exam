package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Product;
import vn.codegym.model.ProductType;

public interface IProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAll(Pageable pageable);

    Product findAllByProductType(ProductType productType);

    Page<Product> findAllByNameContaining(Pageable pageable, String name);
}
