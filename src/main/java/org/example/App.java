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
        System.out.println("======================");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        // 접근 제한자에 관계없이 모든 필드 출력
        Book book = new Book();
        System.out.println("======================");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f ->{
            try {
                f.setAccessible(true);
                System.out.printf("%s : %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        // setAccessible => 접근이 제한된 필드에 접근할 수 있도록 해주는 옵션
        // 필드의 값을 출력하는 코드. 필드가 값을 가지려면 인스턴스가 있어야 하므로 book 인스턴스를 인자로 전달.
        System.out.println("======================");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        // getMethods 로 클래스가 가지고 있는 메서드를 받아올 수 있음.
        System.out.println("======================");
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
        // constructor 도 마찬가지로 받아올 수 있음.
        System.out.println("======================");
        System.out.println(MyBook.class.getSuperclass());
        // superclass 도 받아올 수 있음. superclass 는 하나만 존재하기 때문에 Arrays 사용 불가.
        System.out.println("======================");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
        // 당연히 interface 들도 받아올 수 있음. interface 는 여러개 존재할 수 있으므로 Arrays 사용.
    }
}
