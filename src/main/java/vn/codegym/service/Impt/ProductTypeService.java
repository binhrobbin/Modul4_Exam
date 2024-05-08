package vn.codegym.service.Impt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.ProductType;
import vn.codegym.repository.IProductTypeRepository;
import vn.codegym.service.IProductTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public Page<ProductType> findAll(Pageable pageable) {
        return productTypeRepository.findAll(pageable);
    }

    @Override
    public void save(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public Optional<ProductType> findById(Long id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        productTypeRepository.deleteById(id);
    }
}
