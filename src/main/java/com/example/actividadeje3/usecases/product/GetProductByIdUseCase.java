package com.example.actividadeje3.usecases.product;

import com.example.actividadeje3.dto.ProductDTO;
import com.example.actividadeje3.mapper.ProductMapper;
import com.example.actividadeje3.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class GetProductByIdUseCase {

    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public Mono<ProductDTO> findById(String id) {
        return iProductRepository
                .findById(id)
                .map(productMapper::fromProductToProductDTO);
    }

}
