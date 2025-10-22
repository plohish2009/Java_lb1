import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.util.Arrays;

public class Biblioteka implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SAVE_FILE = "biblioteka.ser";
    private Book arr[];
    private int capacity;
    Biblioteka()
    {
        capacity = 0;
        arr = new Book[0];
    }
    public void savetofile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(this);
            //System.out.println("Библиотека сохранена в файл: " + SAVE_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении библиотеки: " + e.getMessage());
        }
    }
    public static Biblioteka loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            Biblioteka bibl = (Biblioteka) ois.readObject();
            System.out.println("Библиотека загружена из файла: " + SAVE_FILE);
            return bibl;
        } catch (FileNotFoundException e) {
            System.err.println("Файл сохранения не найден. Создана новая библиотека.");
            return new Biblioteka();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке библиотеки: " + e.getMessage());
            return new Biblioteka();
        }
    }
    public void add_book(Book p2)
    {
        if (capacity == 0)
        {
            arr = new Book[1];
            arr[0] = p2;
            capacity = 1;
            return;
        }
        if (!this.find(p2.get_name()))
        {
            Book new_arr[] = new Book [capacity + 1];
            int j = 0;
            boolean pasted = false;
            for (int i = 0; i <= capacity; i++)
            {
                if (j == capacity)
                {
                    new_arr[i] = p2;
                }
                else if (!pasted && arr[j].get_year() > p2.get_year())
                {
                    new_arr[i] = p2;
                    pasted = true;
                }
                else
                {
                    new_arr[i] = arr[j];
                    j++;
                }
            }
            //new_arr[capacity] = p2;
            capacity ++;
            arr = new_arr;
        }
    }
    public void list()
    {
        for (int i = 0; i < capacity; i++)
        {
            arr[i].print_book();
        }
    }
    public boolean find(String search)
    {
        for (int i = 0; i < capacity; i++)
        {
            if (arr[i].get_name().equals(search))
            {
                //arr[i].print_book();
                return true;
            }
        }
        //System.out.println("Книги с таким названием в библиотеки нет!");
        return false;
    }
    public void find_with_atr(String search, int atribut)
    {
        if (atribut == 0)
        {
            for (int i = 0; i < capacity; i++)
            {
                if (arr[i].get_name().equals(search))
                {
                    arr[i].print_book();
                }
                
            }
        }
        else if (atribut == 1) // поиск по автору
        {
            for (int i = 0; i < capacity; i++)
            {
                if (arr[i].get_author().equals(search))
                {
                    arr[i].print_book();
                }
            }
        }
        else // поиск по году
        {
            int temp = Integer.parseInt(search);
            int begin = 0;
            int end = 0;
            int left = 0;
            int right = capacity - 1;
            int mid;
            while (left <= right) 
            {
                mid = (left + right)/2;
                if (arr[mid].get_year() == temp)
                {
                    begin = mid;
                    right = mid - 1;
                }
                else if (temp > arr[mid].get_year())
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid-1;
                }
            }
            left = 0;
            right = capacity - 1;
            while (left <= right) 
            {
                mid = (left + right)/2;
                if (arr[mid].get_year() == temp)
                {
                    end = mid;
                    left = mid + 1;
                }
                else if (temp > arr[mid].get_year())
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid-1;
                }
            }
            for (int i = begin;i<=end;i++)
            {
                arr[i].print_book();
            }
        }
    }
}
