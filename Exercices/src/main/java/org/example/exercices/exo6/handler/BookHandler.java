package org.example.exercices.exo6.handler;

import org.example.exercices.exo6.entity.Book;
import org.example.exercices.exo6.service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.*;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class BookHandler {

    private BookService bookService;

    public BookHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public Mono<ServerResponse> getAllBooks(ServerRequest request) {
        return ok().body(bookService.getAllBooks(), Book.class);
    }

    public Mono<ServerResponse> getBookById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return bookService.getBookById(id)
                .flatMap(product -> ok().bodyValue(product))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> createBook(ServerRequest request) {
        return request.bodyToMono(Book.class)
                .flatMap(bookService::createBook)
                .flatMap(product -> created(request.uri()).bodyValue(product));
    }

    public Mono<ServerResponse> putBook(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return request.bodyToMono(Book.class)
                .flatMap(book -> bookService.putBook(id, book))
                .flatMap(updatedBook ->
                        ServerResponse.ok().bodyValue(updatedBook)
                )
                .onErrorResume(e ->
                        ServerResponse.badRequest().bodyValue("Erreur lors de la mise à jour")
                );
    }

    public Mono<ServerResponse> deleteBook(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return bookService.deleteBook(id)
                .flatMap(book -> ServerResponse.ok().bodyValue(book))
                .switchIfEmpty(notFound().build());
    }



    public Mono<ServerResponse> searchBook(ServerRequest request) {
        String text = request.queryParam("title").orElse("");

        return bookService.getBooksByResearch(text).collectList()
                .flatMap(books -> ServerResponse.ok().bodyValue(books));
//        bookService.getBooksByResearch(text)
//                .flatMap(book -> ok().bodyValue(book))
//                .switchIfEmpty(notFound().build());
    }
}


