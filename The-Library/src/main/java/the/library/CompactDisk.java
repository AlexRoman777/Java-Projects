package the.library;

public class CompactDisk implements Item {
    private int copy;
    private int available;
    private String title;
    private String genre;
    private float price;
    private int year;
    private String artist;
    private int tracks;
    private String ageRating;

    public CompactDisk(int copy, int available, String title, String genre, float price, int year,
            String artist, int tracks, String ageRating) {
        this.copy = copy;
        this.available = available;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.year = year;
        this.artist = artist;
        this.tracks = tracks;
        this.ageRating = ageRating;
    }

    public CompactDisk(String[] row) {
        this.copy = Integer.parseInt(row[1]);
        this.available = Integer.parseInt(row[2]);
        this.title = row[3];
        this.genre = row[4];
        this.price = Float.parseFloat(row[5]);
        this.year = Integer.parseInt(row[6]);
        this.artist = row[7];
        this.tracks = Integer.parseInt(row[8]);
        this.ageRating = row[9];
    }

    public CompactDisk(String title, String artist, int available) {
        this.title = title;
        this.artist = artist;
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

    public void setArtist(String artist) {
        if (artist.isEmpty()) {
            throw new IllegalArgumentException("Artist cannot be empty");
        } else {
            this.artist = artist;
        }
    }

    public String getArtist() {
        return artist;
    }

    public void setTracks(int tracks) {
        if (tracks < 1 || tracks > 99) {
            throw new IllegalArgumentException("Tracks must be between 1 and 99");
        } else {
            this.tracks = tracks;
        }
    }

    public int getTracks() {
        return tracks;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public String toStringShort() {
        return "Title: " + title + ", Genre: " + genre + ", Available: " + available;
    }

    public String[] getDetailsArray() {
        String[] details = new String[9];
        details[0] = Integer.toString(copy);
        details[1] = Integer.toString(available);
        details[2] = title;
        details[3] = genre;
        details[4] = Float.toString(price);
        details[5] = Integer.toString(year);
        details[6] = artist;
        details[7] = Integer.toString(tracks);
        details[8] = ageRating;

        return details;
    }

    public String[] getFewerDetails() {
        String[] details = new String[4];
        details[0] = "Copy nr.: " + Utils.RED + copy + Utils.RESET;
        details[1] = "Title: " + Utils.RED + title + Utils.RESET;
        details[2] = "Artist: " + Utils.RED + artist + Utils.RESET;
        details[3] = "Available: " + Utils.BLUE + available + Utils.RESET;
        return details;
    }
}
