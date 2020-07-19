/*
 * Book class
 * 书籍实体类
 * @author Sirius
 * @date 2020-07-13 19:28
 */
package com.sirius.domain;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String outcome;
    private String type;
    private String isbn;
    private String picture;
    private Integer total;
    private Integer remain;
    private Integer ordered;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Book(Integer id, String name, String author, String outcome,
                String type, String isbn, String picture, Integer total,
                Integer remain, Integer ordered) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.outcome = outcome;
        this.type = type;
        this.isbn = isbn;
        this.picture = picture;
        this.total = total;
        this.remain = remain;
        this.ordered = ordered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
