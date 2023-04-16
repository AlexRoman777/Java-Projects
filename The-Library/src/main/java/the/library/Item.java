package the.library;

public interface Item {
    // Declaring the interface variables
    public int copy = 0;
    public int available = 0;
    public String title = null;
    public String genre = null;
    public float price = 0f;
    public int year = 0;

    // Declaring the interface methods
    public void setCopy(int copy);

    public int getCopy();

    public void setAvailable(int available);

    public int getAvailable();

    public void setTitle(String title);

    public String getTitle();

    public void setGenre(String genre);

    public String getGenre();

    public void setPrice(float price);

    public float getPrice();

    public void setYear(int year);

    public int getYear();


}
