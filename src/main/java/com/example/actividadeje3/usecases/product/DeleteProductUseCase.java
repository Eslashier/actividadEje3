package com.example.actividadeje3.usecases.product;

import com.example.actividadeje3.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
@AllArgsConstructor
public class DeleteProductUseCase {

    private final IProductRepository iProductRepository;

    public Mono<Void> deleteProductById(String id){
        return iProductRepository.deleteById(id);
    }
}
