package org.example;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class;
//        Book book = new Book();
//        Class<? extends Book> aClass = book.getClass();
//        Class<?> aClass1 = Class.forName("org.example.Book.java");

        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        // 접근 제한자가 public 인 d 필드만 출력
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        // 접근 제한자에 관계없이 모든 필드 출력
    }
}
