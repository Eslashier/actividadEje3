package com.example.actividadeje3.usecases.product;

import com.example.actividadeje3.dto.ProductDTO;
import com.example.actividadeje3.mapper.ProductMapper;
import com.example.actividadeje3.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProductUseCase {

    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public Flux<ProductDTO> getAllProducts(){
        return iProductRepository.findAll().map(productMapper::fromProductToProductDTO);
    }
}
