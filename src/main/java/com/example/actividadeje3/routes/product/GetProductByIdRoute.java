package com.example.actividadeje3.routes.product;

import com.example.actividadeje3.dto.ProductDTO;
import com.example.actividadeje3.usecases.product.GetProductByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProductByIdRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllCyclistByTeamId(GetProductByIdUseCase getProductByIdUseCase){
        return route(GET("/v1/product/{id}"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getProductByIdUseCase.findById(request.pathVariable("id")), ProductDTO.class)));

    }

}
