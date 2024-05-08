package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.IProductService;
import vn.codegym.service.IProductTypeService;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

//    @ModelAttribute("productTypes")
//    public Iterable<Province> listProvinces() {
//        return provinceService.findAll();
//    }

    @GetMapping
    public ModelAndView listProducts(@PageableDefault(value = 5) Pageable pageable){
        Page<Product> Products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", Products);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("productTypeList",  productTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("product") Product product,
                         RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        System.out.println(1);
        if (bindingResult.hasFieldErrors()) return "/product/create";
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công");
        return "redirect:/products";
    }

//    @GetMapping("/search")
//    public ModelAndView listProductsSearch(@RequestParam(value = "search") Optional<String> search, Pageable pageable){
//        Page<Product> Products;
//        ModelAndView modelAndView = new ModelAndView("/Product/list");
//        if(search.isPresent()){
//            Products = productService.findAllByNameContaining(pageable, search.get());
//            modelAndView.addObject("keyword", search.get());
//        } else {
//            Products = productService.findAll(pageable);
//        }
//        modelAndView.addObject("Products", Products);
//        return modelAndView;
//    }
//
//    @GetMapping("/update/{id}")
//    public ModelAndView updateForm(@PathVariable Long id) {
//        Optional<Product> Product = productService.findById(id);
//        if (Product.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/Product/update");
//            modelAndView.addObject("Product", Product.get());
//            return modelAndView;
//        } else {
//            return new ModelAndView("/error_404");
//        }
//    }
//
//    @PostMapping("/update/{id}")
//    public String update(@ModelAttribute("Product") Product Product,
//                         RedirectAttributes redirect) {
//        productService.save(Product);
//        redirect.addFlashAttribute("message", "Update Product successfully");
//        return "redirect:/Products";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id,
//                         RedirectAttributes redirect) {
//        productService.remove(id);
//        redirect.addFlashAttribute("message", "Delete Product successfully");
//        return "redirect:/Products";
//    }
}
