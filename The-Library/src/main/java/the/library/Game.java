package the.library;

public class Game implements Item, Comparable<Game> {
    private int copy;
    private int available;
    private String title;
    private String genre;
    private float price;
    private int year;
    private String publisher;
    private String platform;
    private int playtime;
    private String ageRating;

    public Game(int copy, int available, String title, String genre, float price, int year,
            String publisher,
            String platform, int playtime, String ageRating) {
        this.copy = copy;
        this.available = available;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.year = year;
        this.publisher = publisher;
        this.platform = platform;
        this.playtime = playtime;
        this.ageRating = ageRating;
    }

    public Game(String[] row) {
        this.copy = Integer.parseInt(row[1]);
        this.available = Integer.parseInt(row[2]);
        this.title = row[3];
        this.genre = row[4];
        this.price = Float.parseFloat(row[5]);
        this.year = Integer.parseInt(row[6]);
        this.publisher = row[7];
        this.platform = row[8];
        this.playtime = Integer.parseInt(row[9]);
        this.ageRating = row[10];
    }

    public Game(String title, String platform, int available) {
        this.title = title;
        this.platform = platform;
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

    public void setYear(int year) {
        if (year < 1900 || year > 2023) {
            throw new IllegalArgumentException("Year must be between 1900 and 2023");
        } else {
            this.year = year;
        }
    }

    public int getYear() {
        return year;
    }

    public void setPublisher(String publisher) {
        if (publisher.isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be empty");
        } else {
            this.publisher = publisher;
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPlatform(String platform) {
        if (platform.isEmpty()) {
            throw new IllegalArgumentException("Platform cannot be empty");
        } else {
            this.platform = platform;

        }
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlaytime(int playtime) {
        if (playtime < 0) {
            throw new IllegalArgumentException("Playtime cannot be negative");
        } else {
            this.playtime = playtime;
        }
    }

    public int getPlaytime() {
        return playtime;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getAgeRating() {
        return ageRating;
    }

    @Override
    public int compareTo(Game b) {

        return this.title.compareTo(b.title);
    }

    public String[] getDetailsArray() {
        String[] details = new String[10];
        details[0] = title;
        details[1] = genre;
        details[2] = Float.toString(price);
        details[3] = Integer.toString(year);
        details[4] = publisher;
        details[5] = platform;
        details[6] = Integer.toString(playtime);
        details[7] = ageRating;
        details[8] = Integer.toString(copy);
        details[9] = Integer.toString(available);
        return details;
    }

    public String[] getFewerDetails() {
        String[] details = new String[4];
        details[0] = "Copy nr.: " + Utils.RED + copy + Utils.RESET;
        details[1] = "Title: " + Utils.RED + title + Utils.RESET;
        details[2] = "Platform: " + Utils.RED + platform + Utils.RESET;
        details[3] = "Available: " + Utils.BLUE + available + Utils.RESET;
        return details;
    }
}
