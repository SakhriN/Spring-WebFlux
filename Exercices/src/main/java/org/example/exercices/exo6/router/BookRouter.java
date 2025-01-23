package org.example.exercices.exo6.router;

import org.example.exercices.exo6.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<ServerResponse> productRoutes(BookHandler bookHandler) {
        return route(GET("/api/books"), bookHandler::getAllBooks)
//                .andRoute(GET("/api/books/{id}"), bookHandler::getBookById)
                .andRoute(POST("/api/books"), bookHandler::createBook)
                .andRoute(PUT("/api/books/{id}"), bookHandler::putBook)
                .andRoute(DELETE("/api/books/{id}"), bookHandler::deleteBook)
                .andRoute(GET("/api/books/search"), bookHandler::searchBook);
    }

}
