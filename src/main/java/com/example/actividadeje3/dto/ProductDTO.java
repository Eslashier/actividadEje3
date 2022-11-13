package com.example.actividadeje3.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductDTO {

    private String id;

    @NotNull(message = "El nombre del producto es obligatorio")
    @Size(min = 3, message = "El nombre debe contener mas de 3 caracteres")
    @Size(max = 50, message = "El nombre debe contener menos de 50 caracteres")
    private String name;

    @NotNull(message = "La marca del producto es obligatorio")
    @Size(min = 3, message = "La marca debe contener mas de 3 caracteres")
    @Size(max = 50, message = "La marca debe contener menos de 50 caracteres")
    private String brand;

    @Size(min = 3, message = "La descripción debe contener mas de 3 caracteres")
    @Size(max = 100, message = "La descripción debe contener mas de 100 caracteres")
    @NotNull(message = "La descripción del producto es obligatorio")
    private String description;

    @NotNull(message = "El precio del producto es obligatorio")
    @Min(0)
    @Max(1000000)
    private Integer price;
}
