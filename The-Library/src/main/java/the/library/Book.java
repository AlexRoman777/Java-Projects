package the.library;

public class Book implements Item, Comparable<Book> {
    // Interface variables
    private int copy;
    private int available;
    private String title;
    private String genre;
    private float price;
    private int year;
    // Book variables
    private String author;
    private String condition;
    private int pages;

    public Book(int copy, int available, String title, String genre, float price, int year, String author,
            String condition, int pages) {

        this.copy = copy;
        this.available = available;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.year = year;
        this.author = author;
        this.condition = condition;
        this.pages = pages;
    }

    public Book(String[] row) {
        this.copy = Integer.parseInt(row[1]);
        this.available = Integer.parseInt(row[2]);
        this.title = row[3];
        this.genre = row[4];
        this.price = Float.parseFloat(row[5]);
        this.year = Integer.parseInt(row[6]);
        this.author = row[7];
        this.condition = row[8];
        this.pages = Integer.parseInt(row[9]);
    }

    public Book(String title, String author, int available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }

    @Override
    public void setCopy(int copy) {
        if (copy < 0) {
            throw new IllegalArgumentException("Copy cannot be negative");
        } else {
            this.copy = copy;
        }
    }

    @Override
    public int getCopy() {
        return copy;
    }

    @Override
    public void setAvailable(int available) {
        if (available < 0) {
            throw new IllegalArgumentException("Available cannot be negative");
        } else {
            this.available = available;
        }
    }

    @Override
    public int getAvailable() {
        return available;
    }

    @Override
    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        } else {
            this.title = title;
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setGenre(String genre) {
        if (genre.isEmpty()) {
            genre = "Unknown";
        }
        this.genre = genre;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void setPrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else {
            this.price = price;
        }
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setYear(int year) {
        if (year < 1900 || year > 2023) {
            throw new IllegalArgumentException("Year must be between 1900 and 2023");
        } else {
            this.year = year;
        }
    }

    @Override
    public int getYear() {
        return year;
    }

    public void setAuthor(String author) {
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        } else {
            this.author = author;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setCondition(String condition) {
        if (condition.isEmpty()) {
            condition = "Unknown";
        }
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setPages(int pages) {
        if (pages < 1 || pages > 10000) {
            throw new IllegalArgumentException("Pages must be between 1 and 10000");
        } else {
            this.pages = pages;
        }
    }

    public int getPages() {
        return pages;
    }

    @Override
    public int compareTo(Book b) {

        return this.title.compareTo(b.title);
    }

    public String[] getDetailsArray() {
        String[] details = new String[9];
        details[0] = title;
        details[1] = author;
        details[2] = genre;
        details[3] = Integer.toString(year);
        details[4] = Float.toString(price);
        details[5] = Integer.toString(copy);
        details[6] = condition;
        details[7] = Integer.toString(pages);
        details[8] = Integer.toString(available);
        return details;
    }

    public String printBadCondition() {
        while (!condition.equals("Good") && !condition.equals("Excellent")) {
            return "Book copy nr. " + copy + ", " + title + " (" + year + ") is in " + condition + " condition.";
        }
        // Go up on row in terminal
        return Utils.MOVEUP;
    }

    public String[] getFewerDetails() {
        String[] details = new String[4];
        details[0] = "Copy nr: " + Utils.RED + copy + Utils.RESET;
        details[1] = "Title: " + Utils.RED + title + Utils.RESET;
        details[2] = "Year: " + Utils.RED + year + Utils.RESET;
        details[3] = "Author: " + Utils.RED + author + Utils.RESET;
        return details;
    }

    public String toStringShort() {
        return "Title: " + title + ", Author: " + author + ", Available: " + available;
    }

}
