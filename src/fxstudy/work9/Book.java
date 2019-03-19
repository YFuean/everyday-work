package fxstudy.work9;

import java.util.ArrayList;
import java.util.List;

/**
 * List基础用法复习
 * @author yuuefan
 * 2019.3.19
 */
public class Book {
    private Integer id;
    private String name;
    private Double price;

    public Book(){}

    public Book(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "   "+ name + "   " + price;
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(01,"母猪的产后护理",30.70));
        bookList.add(new Book(02,"计算机网络基础",40.96));
        bookList.add(new Book(03,"军事理论教程",26.36));
        System.out.println(bookList);
        bookList.add(1,new Book(04,"java",78.38));
        System.out.println(bookList);
        bookList.remove(1);
        System.out.println(bookList);
        bookList.set(0,new Book(01,"高数",29.34));
        System.out.println(bookList);
        System.out.println(bookList.get(1));
        bookList.add(new Book(05,"母鸡场后护理",48.3));
        System.out.println(bookList);
        System.out.println(bookList.indexOf(03));
        System.out.println(bookList.lastIndexOf("军事理论教程"));
    }
}
