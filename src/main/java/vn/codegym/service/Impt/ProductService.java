package vn.codegym.service.Impt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.model.ProductType;
import vn.codegym.repository.IProductRepository;
import vn.codegym.service.IProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByProductType(ProductType productType) {
        return null;
    }

    @Override
    public Page<Product> findAllByNameContaining(Pageable pageable, String name) {
        return productRepository.findAllByNameContaining(pageable,name);
    }
}
