package com.example.actividadeje3.usecases.product;

import com.example.actividadeje3.dto.ProductDTO;
import com.example.actividadeje3.mapper.ProductMapper;
import com.example.actividadeje3.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@AllArgsConstructor
public class PostProductUseCase {

    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public Mono<ProductDTO> postProduct(@Valid ProductDTO productDTO){
        return iProductRepository
                .save(productMapper.fromProductDTOToProduct(productDTO))
                .map(productMapper::fromProductToProductDTO);
    }
}
