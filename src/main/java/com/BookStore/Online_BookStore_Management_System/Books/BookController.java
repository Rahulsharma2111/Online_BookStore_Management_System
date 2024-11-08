package com.BookStore.Online_BookStore_Management_System.Books;



import com.BookStore.Online_BookStore_Management_System.Users.User;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServices bookServices;
//    @GetMapping()
//    private List<Books> getAllBooks(){
//
//        return this.bookServices.getAllBook();
//    }


    // get all books for database
    @GetMapping("/get")
//    @ResponseBody
    public String getAllBooks(Model model) {

        List<Book> books= bookServices.getAllBooks();
        model.addAttribute("books",books);
         return "Book-details";
    }


    // upload book details in database
    @GetMapping("/create")
    public String createBook(Model model){
        Book book=new Book();
        model.addAttribute("book",book);
        return "createBook";
    }

    // upload book details in database
    @PostMapping("/create")
    public String saveBook(@ModelAttribute Book book,Model model){
      this.bookServices.saveBook(book);
      model.addAttribute("success","Book add successfully");
        return "redirect:/books/create";
    }

    // find book by id function
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Book> findByid(@PathVariable("id") int id){
        return this.bookServices.findBookById(id);
    }

    // find all book by name(title) function
    @GetMapping("/title/{bookName}")
    @ResponseBody
    public List<Book> findByid(@PathVariable("bookName") String bookName){
        return this.bookServices.findAllBookBybookName(bookName);
    }


    // find all book by name(title) function
    @GetMapping("/category/{categoryName}")
    @ResponseBody
    public List<Book> findByCategoryName(@PathVariable("categoryName") String categoryName){
        return this.bookServices.findAllBookByCategory(categoryName);
    }

    // find all book by author name function
    @GetMapping("/Author/{authorName}")
    @ResponseBody
    public List<Book> findByAuthorName(@PathVariable("authorName") String authorName){
        return this.bookServices.findAllBookByAuthor(authorName);
    }

    // sort all book by price/rate function
    @GetMapping("/price")
    @ResponseBody
    public List<Book> sortAllBookByPrice(){
        return this.bookServices.sortAllBookByprice();
    }

    //update book details
//    @PostMapping("/update/{bookId}")
//    @ResponseBody
//    public Book updateUsersById(@RequestBody Book book, @PathVariable("bookId") int bookId){
//        return this.bookServices.updateBookById(book,bookId);
//    }
    @GetMapping("/update/{bookId}")
    public String updateBookById(@PathVariable("bookId") int bookId, Model model){
//        @RequestBody Book book,
        Optional<Book> getBookData=this.bookServices.findBookById(bookId);
        model.addAttribute("getBookData",getBookData);
         return "update-book";
    }
    @PostMapping("/update/{bookId}")
    public String saveUpdateBookById(@ModelAttribute Book book,@PathVariable("bookId") int bookId,Model model){
        this.bookServices.updateBookById(book,bookId);
        model.addAttribute("success","Book add successfully");
        return "redirect:/books/get";
    }
    // delete the book item from database
    @GetMapping("/delete/{bookId}")
    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId){
         this.bookServices.deleteBookById(bookId);
        return "redirect:/books/get";
    }

}
