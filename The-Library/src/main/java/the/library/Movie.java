package the.library;

public class Movie implements Item, Comparable<Movie> {
    // Interface variables
    private int copy;
    private int available;
    private String title;
    private String genre;
    private float price;
    private int year;

    // Film variables
    private String director;
    private int runtime;
    private String agerating;

    public Movie(int copy, int available, String title, String genre, float price, int year,
            String director,
            int runtime, String agerating) {
        this.copy = copy;
        this.available = available;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.year = year;
        this.director = director;
        this.runtime = runtime;
        this.agerating = agerating;
    }

    public Movie(String[] row) {
        this.copy = Integer.parseInt(row[1]);
        this.available = Integer.parseInt(row[2]);
        this.title = row[3];
        this.genre = row[4];
        this.price = Float.parseFloat(row[5]);
        this.year = Integer.parseInt(row[6]);
        this.director = row[7];
        this.runtime = Integer.parseInt(row[8]);
        this.agerating = row[9];
    }

    public Movie(String title, int year, int available) {
        this.title = title;
        this.year = year;
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

    public void setDirector(String director) {
        if (director.isEmpty()) {
            throw new IllegalArgumentException("Director cannot be empty");
        } else {
            this.director = director;
        }
    }

    public String getDirector() {
        return director;
    }

    public void setRuntime(int runtime) {
        if (runtime < 1 || runtime > 999) {
            throw new IllegalArgumentException("Runtime must be between 1 and 999 minutes");
        } else {
            this.runtime = runtime;
        }
    }

    public int getRuntime() {
        return runtime;
    }

    public void setAgeRating(String agerating) {
        this.agerating = agerating;
    }

    public String getAgeRating() {
        return agerating;
    }

    @Override
    public int compareTo(Movie b) {
        return this.title.compareTo(b.title);
    }

    public String printMovieRuntime() {
        return title + " (" + year + ") - Runtime: " + runtime + " minutes";
    }

    public String[] getDetailsArray() {
        String[] details = new String[8];
        details[0] = Integer.toString(copy);
        details[1] = title;
        details[2] = genre;
        details[3] = Float.toString(price);
        details[4] = Integer.toString(year);
        details[5] = director;
        details[6] = Integer.toString(runtime);
        details[7] = agerating;
        return details;
    }

    public String[] getFewerDetails() {
        String[] details = new String[4];
        details[0] = "Copy nr.: " + Utils.RED + copy + Utils.RESET;
        details[1] = "Title: " + Utils.RED + title + Utils.RESET;
        details[2] = "Year: " + Utils.RED + year + Utils.RESET;
        details[3] = "Age Rating: " + Utils.RED + agerating + Utils.RESET;
        return details;
    }

}
