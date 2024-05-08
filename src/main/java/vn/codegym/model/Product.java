package vn.codegym.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 50)
    private String name;
    @NotNull
    @Min(100000)
    private Double price;
    @NotNull
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_loai_sp")
    private ProductType productType;

    public Product() {

    }
}
