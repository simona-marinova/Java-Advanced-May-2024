package library;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //копираме надолу кода от файла
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library(bookOne, bookTwo, bookThree);
         // може да използваме forEach вместо итератор
        //     for (Book book: library) {
        //   System.out.println(book.getTitle());
        //  }
        //може и така:
        Iterator<Book> iterator = library.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}

