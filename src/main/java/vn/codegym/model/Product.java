package vn.codegym.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
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
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_loai_sp")
    private ProductType productType;

    public Product() {
        this.status = "chờ duyệt";
    }
}
