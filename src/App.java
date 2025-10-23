import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String encoding;
        String os = System.getProperty("os.name").toLowerCase();
        
        if (os.contains("win")) {
            encoding = "CP866";
        } else {
            encoding = "UTF-8";
        }
        
        System.setProperty("file.encoding", encoding);
        System.setOut(new PrintStream(System.out, true, encoding));

        Biblioteka bibl = Biblioteka.loadFromFile();
    //    {
    //         Book book1 = new Book("Три мушкетёра", "Александр Дюма", 1844, "classics/duma1.pdf");
    //         Book book2 = new Book("Двадцать лет спустя", "Александр Дюма", 1845, "classics/duma2.epub");
    //         Book book3 = new Book("Граф Монте-Кристо", "Александр Дюма", 1846, "classics/duma3.mobi");

    //         Book book4 = new Book("Война и мир", "Лев Толстой", 1869, "russian/tolstoy1.pdf");
    //         Book book5 = new Book("Анна Каренина", "Лев Толстой", 1877, "russian/tolstoy2.epub");
    //         Book book6 = new Book("Воскресение", "Лев Толстой", 1899, "russian/tolstoy3.mobi");

    //         Book book7 = new Book("Преступление и наказание", "Фёдор Достоевский", 1866, "russian/dostoevsky1.pdf");
    //         Book book8 = new Book("Идиот", "Фёдор Достоевский", 1869, "russian/dostoevsky2.epub");
    //         Book book9 = new Book("Братья Карамазовы", "Фёдор Достоевский", 1880, "russian/dostoevsky3.mobi");

    //         Book book10 = new Book("1984", "Джордж Оруэлл", 1949, "dystopian/orwell1.pdf");
    //         Book book11 = new Book("Скотный двор", "Джордж Оруэлл", 1945, "dystopian/orwell2.epub");

    //         Book book12 = new Book("Гарри Поттер и философский камень", "Джоан Роулинг", 1997, "fantasy/rowling1.pdf");
    //         Book book13 = new Book("Гарри Поттер и Тайная комната", "Джоан Роулинг", 1998, "fantasy/rowling2.epub");
    //         Book book14 = new Book("Гарри Поттер и узник Азкабана", "Джоан Роулинг", 1999, "fantasy/rowling3.mobi");

    //         Book book15 = new Book("Властелин Колец: Братство Кольца", "Джон Толкин", 1954, "fantasy/tolkien1.pdf");
    //         Book book16 = new Book("Властелин Колец: Две крепости", "Джон Толкин", 1954, "fantasy/tolkien2.epub");
    //         Book book17 = new Book("Властелин Колец: Возвращение короля", "Джон Толкин", 1955, "fantasy/tolkien3.mobi");

    //         Book book18 = new Book("Убить пересмешника", "Харпер Ли", 1960, "classics/lee1.pdf");
    //         Book book19 = new Book("Пойди поставь сторожа", "Харпер Ли", 2015, "classics/lee2.epub");

    //         Book book20 = new Book("Шерлок Холмс: Этюд в багровых тонах", "Артур Конан Дойл", 1887, "detective/doyle1.pdf");
    //         Book book21 = new Book("Шерлок Холмс: Знак четырех", "Артур Конан Дойл", 1890, "detective/doyle2.epub");
    //         Book book22 = new Book("Шерлок Холмс: Собака Баскервилей", "Артур Конан Дойл", 1902, "detective/doyle3.mobi");
            
    //         bibl.add_book(book1);
    //         bibl.add_book(book2);
    //         bibl.add_book(book3);
    //         bibl.add_book(book4);
    //         bibl.add_book(book5);
    //         bibl.add_book(book6);
    //         bibl.add_book(book7);
    //         bibl.add_book(book8);
    //         bibl.add_book(book9);
    //         bibl.add_book(book10);
    //         bibl.add_book(book11);
    //         bibl.add_book(book12);
    //         bibl.add_book(book13);
    //         bibl.add_book(book14);
    //         bibl.add_book(book15);
    //         bibl.add_book(book16);
    //         bibl.add_book(book17);
    //         bibl.add_book(book18);
    //         bibl.add_book(book19);
    //         bibl.add_book(book20);
    //         bibl.add_book(book21);
    //         bibl.add_book(book22);
    //     }
        
        InputStreamReader isr = new InputStreamReader(System.in, encoding);
        Scanner scanner = new Scanner(isr);
        

         while (true) {
            System.out.println("\n=== Меню библиотеки ===");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Показать все книги");
            System.out.println("3. Проверить наличие книги по названию");
            System.out.println("4. Найти книги по атрибуту");
            System.out.println("5. Сохранить и выйти");
            System.out.println("6. Выйти без сохранения");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
                if (choice == 1)
                {
                    String name;
                    String author;
                    int year;
                    String path;
                    System.out.println("Введите название книги: ");
                    name = scanner.nextLine();
                    System.out.println("Укажите автора: ");
                    author = scanner.nextLine();
                    System.out.println("Укажите дату создания: ");
                    while (!scanner.hasNextInt())
                    {
                        System.out.println("Ошибка! Введите число: ");
                        scanner.next(); 
                    }
                    year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Укажите путь до книги: ");
                    path = scanner.nextLine();
                    Book boka = new Book(name, author, year, path);
                    bibl.add_book(boka);
                }
                else if (choice == 2)
                {
                    System.out.println("\nВсе книги в библиотеке:");
                    bibl.list();
                }
                else if (choice == 3)
                {
                    System.out.print("Введите название книги: ");
                    String searchName = scanner.nextLine();
                    if (bibl.find(searchName))
                    {
                        System.out.println("Такая книга есть в библиотеке");
                    }
                    else
                    {
                        System.out.println("Такой книги в библиотеке нет");
                    }
                }
                else if (choice ==  4)
                {
                    System.out.print("Введите значение для поиска: ");
                    String search = scanner.nextLine();
                    System.out.println(search);
                    System.out.print("Выберите атрибут (0-название, 1-автор, 2-год): ");
                    int attribute = scanner.nextInt();
                    bibl.find_with_atr(search, attribute);
                }
                else if (choice == 5)
                {
                    bibl.savetofile();
                    scanner.close();
                    break;
                }
                else if (choice == 6)
                {
                    scanner.close();
                    break;
                }
                else{System.out.println("Неверный выбор!");}               
            }
        scanner.close();
        
    }
}
