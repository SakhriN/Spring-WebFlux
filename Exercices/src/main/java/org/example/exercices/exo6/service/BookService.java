package org.example.exercices.exo6.service;

import org.example.exercices.exo6.entity.Book;
import org.springframework.stereotype.*;
import reactor.core.publisher.*;

import java.util.*;
import java.util.concurrent.*;

@Service
public class BookService {

    private final Map<String, Book> books = new ConcurrentHashMap<>();
    private final List<Book> booksList = new ArrayList<>();

    public BookService(){
        // prodduit de test
//        tasks.put("1",new Task(1,"Livre", false));
//        tasks.put("2",new Task(2,"Tomate", true));

        booksList.add(new Book("Livre", "falseman"));
        booksList.add(new Book("Tomate", "trueman"));
        booksList.add(new Book("Tomate","Nassim"));
    }

    public Flux<Book> getAllBooks(){
        return Flux.fromIterable(booksList);
    }

    public Mono<Book> getBookById(int id){
        for(Book book : booksList){
            if(id == (book.getId())){
                return Mono.just(book);
            }
        }
        return null;
    }

    public Mono<Book> createBook(Book book){
        booksList.add(book);
        return Mono.just(book);
    }

    public Mono<Boolean> putBook(int id, Book book){
        boolean result = false;
        for(Book booklet : booksList){
            if( id == booklet.getId() ){
                booklet.setId(book.getId());
                booklet.setTitle(book.getTitle());
                booklet.setAuthor(book.getAuthor());
                result = true;
            }
        }
        return Mono.just(result);
    }

    public Mono<Boolean> deleteBook(int id){
        boolean result = false;
        for(Book book : booksList){
            if(id == book.getId()){
                booksList.remove(book);
                result = true;
            }
        }
        return Mono.just(result);
    }


    public Flux<Book> getBooksByResearch(String text){
        List<Book> books = new ArrayList<>();
        for(Book book : booksList){
            if(book.getTitle().contains(text)){
                books.add(book);
            }
        }
        return Flux.fromIterable(books);

    }
}
