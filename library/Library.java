package library;

import java.util.Iterator;

public class Library implements Iterable <Book> {
    private Book [] books;

    public Library(Book...books) {
        this.books = books;
    }
//отиваме тук - public class Library implements Iterable <Book> {
    // цъкаме върху червената линия отдолу и даваме implement iterator:
    // казваме моя итератор искаме да е нов library iterator
    //моя итератор е нов обект от този клас
    @Override
    public Iterator<Book> iterator() {
      //  return null; - това е по default, променяме го
        return new LibraryIterator();
    }

    public class LibraryIterator implements Iterator<Book> {
        // искам да ми имплементира итератор от итератор който ще обхожда книги
        // той е интрумента за обхождане
        // за да може да работи трябва да има имплементирани методите hasNext и next
        // казваме generete implement methods has next и next
// всеки итератор ще се характеризира с private int поле count:
private int count =0; // казва ни на коя книга се намираме

        @Override
        public boolean hasNext() {
           // return false;
            //горе е дефолтното поведение на метода, ние го сменяме
            // ako книгата на която се намира е по-малка от самия брой на книгите тогава
            //значи имам следваща книга:
            return count < books.length;
        }

        @Override
        public Book next() {
           //return null;
            //горе е дефолтното поведение на метода, ние го сменяме
            //от масива с книгите дай ми текущата книга и след това премини на следващата
            return books[count++];

        }
    }
}
