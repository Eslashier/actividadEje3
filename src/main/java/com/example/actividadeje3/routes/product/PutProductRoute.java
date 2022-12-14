package com.example.actividadeje3.routes.product;

import com.example.actividadeje3.dto.ProductDTO;
import com.example.actividadeje3.usecases.product.PostProductUseCase;
import com.example.actividadeje3.usecases.product.PutProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutProductRoute {

    @Bean
    public RouterFunction<ServerResponse> updateProduct(PutProductUseCase putProductUseCase){
        return route(PUT("/v1/product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(putProductUseCase::putProduct)
                        .flatMap(productDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDTO))
        );
    }
}
