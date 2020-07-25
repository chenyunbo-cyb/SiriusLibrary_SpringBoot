/*
 * BookService
 * 描述
 @author Sirius
 */
package com.sirius.service.interfaces;

import com.sirius.domain.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public interface BookService {
    // 借书
    int borrow(HashMap<Book, Integer> books);
    // 还书
    int returnBook(HashMap<Book, Integer> books);
    // 根据名称查询书籍信息
    ArrayList<Book> showBookInfo(String bookName);
    // 根据isbn查询
    Book showBookByISBN(String isbn);
    // 根据其他条件查询
    ArrayList<Book> showByOnCondition(Book book);
    // 根据作者查询
    ArrayList<Book> showBooksByAuthor(String author);
    // 根据出版时间查询
    ArrayList<Book> showBooksByTime(Date left, Date right);
    // 显示所有书籍
    ArrayList<Book> showAllBook();
    // 根据类型查询
    ArrayList<Book> showBooksByType(String type);
    // 详细查询
    Book showBookInDetail(Book book);
    // 根据作者和书名查询
    ArrayList<Book> showBooksByNameAndAuthor(String name, String author);
    // 查询用户借阅情况
    ArrayList<Book> showBookDependsOnUser(Integer id);
    // 查询即将过期书籍
    ArrayList<Book> showBookNearByTimeout(Integer id);
    // 查询已经过期书籍
    ArrayList<Book> showBooksAlreadyTimeout(Integer id);
    // 新增书籍
    Boolean addBook(Book book);
    // 增加库存数量
    Boolean addBookNums(Book book, Integer nums);

    // 修改ISBN
    Boolean changeISBN(String oldIsbn, String newIsbn);
    // 修改id
    Boolean changeId(Integer oldId, Integer newId);
    // 修改书籍
    Boolean changeBook(Book oldBook, Book newBook);
}
