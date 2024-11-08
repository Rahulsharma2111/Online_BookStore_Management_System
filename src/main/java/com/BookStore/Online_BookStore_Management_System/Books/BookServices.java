package com.BookStore.Online_BookStore_Management_System.Books;

import com.BookStore.Online_BookStore_Management_System.Cart.CartRepository;
import com.BookStore.Online_BookStore_Management_System.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookServices{
    @Autowired
    private BookRepository bookRepository;

//    public  List<Book> bookList=new ArrayList<>();;

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Optional<Book> findBookById(int id){
          Optional<Book> book= this.bookRepository.findById(id);
        return book;
    }
    public List<Book> findAllBookBybookName( String bookName){
        List<Book> book= this.bookRepository.findByTitle(bookName);
        return book;
    }
    public List<Book> findAllBookByCategory( String categoryName){
        List<Book> book= this.bookRepository.findAllBookByCategory(categoryName);
        return book;
    }
    public List<Book> findAllBookByAuthor(String authorName){
        List<Book> book= this.bookRepository.findAllBookByAuthor(authorName);
        return book;
    }
    public Book saveBook(Book book){
        return  this.bookRepository.save(book);
    }

    public List<Book> sortAllBookByprice(){
        List<Book> book= this.bookRepository.findAll();
//            book.getPrice()
        return book;
    }

//    public User updateBook(Book book, String bookname) {
//        Book userUpdated=this.bookRepository.findByTitle(bookname);
//
//        if(userUpdated==null){
//            return null;
//        }
//        userUpdated.setUsername(user.getUsername());
//        userUpdated.setPassword(user.getPassword());
//        userUpdated.setEmail(user.getEmail());
//        userUpdated.setRole(user.getRole());
//        userUpdated.setAddress(user.getAddress());
//        return this.userRepository.save(userUpdated);
//    }

    public Book updateBookById( Book book,int id) {
        Optional<Book> bookUpdated=this.bookRepository.findById(id);

        if(!bookUpdated.isPresent()){
            return null;
        }
        Book existingBook=bookUpdated.get();
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setCategory(book.getCategory());
        existingBook.setStock(book.getStock());
        existingBook.setDescription(book.getDescription());
        return this.bookRepository.save(existingBook);
    }

    public boolean deleteBookById(int bookId){
        if (bookId==0)return false;

     this.bookRepository.deleteById(bookId);
        return true;
    }

    @Autowired
    private CartRepository cartRepository;

    public void deleteBook(int bookId) {
        // First, delete all cart entries associated with the book
        cartRepository.deleteByBookId(bookId); // Implement this method in CartRepository

        // Then, delete the book
        bookRepository.deleteById(bookId);
    }
}
