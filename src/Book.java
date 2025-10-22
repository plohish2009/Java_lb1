import java.io.Serializable;
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String author;
    private int year;
    private String path;
    Book ()
    {
        this("", "",  0, "");
    }
    Book (String name, String author, int year, String path)
    {
        this.name = name;
        this.author = author;
        this.year = year;
        this.path = path;
    }
    public void set_name(String newname)
    {
        this.name = newname;
    }
    public void set_author(String newauthor)
    {
        this.author = newauthor;
    }
    public void set_year(int y)
    {
        this.year = y;
    }
    public void set_path(String newpath)
    {
        this.path = newpath;
    }
    public String get_name(){return name;}
    public String get_author(){return author;}
    public int get_year(){return year;}
    public String get_path(){return path;}
    public void print_book()
    {
        System.out.print(this.get_name() + ", ");
        System.out.print(this.get_author() + ", ");
        System.out.print(this.get_year() + ", ");
        System.out.print(this.get_path() + " ");
        System.out.println();
}
}