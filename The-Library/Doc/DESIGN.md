# Design Document

## UML Class Diagram

```mermaid
classDiagram
    class Item{
        +int copy
        +int available
        +String title
        +String genre
        +float price
        +int year
    }
    class Book {
        +int copy
        +int available
        +String title
        +String genre
        +float price
        int pages
        String author
        String condition
        int pages
        -compareTo(Book book)
        -getDetailsArray()
        -printBadCondition()
        -getFewerDetails()
    }

    class CompactDisk{
        +int copy
        +int available
        +String title
        +String genre
        +float price
        +int year
        String artist
        int tracks
        String ageRating
        -toStringShort()
        -getDetailsArray()
        -getFewerDetails()

    }
    class Movie{
        +int copy
        +int available
        +String title
        +String genre
        +float price
        +int year
        String director
        String ageRating
        int duration
        -compareTo(Movie movie)
        -printMovieRuntime()
        -getDetailsArray()
        -getFewerDetails()

    }

    class Game{
        +int copy
        +int available
        +String title
        +String genre
        +float price
        +int year
        String platform
        String ageRating
        int playtime
        String publisher
        -getDetailsArray()
        -getFewerDetails()
        -compareTo(Game game)
    }

    class DatabaseIO{
        +String url
        +String username
        +String password
        +Connection conn
        getConnection()
        createDatabase(Connection conn, String name)
        deleteBook(String id)
        readLastFiveBooks()
        readTotalValue(String type)
        readTotalValue()
    }

    class Menu{
        -showMenu(String menu)
        -mainMenu()
        -loadUserList()
        -saveUserListFromDatabase()
        -listSchema()
        -specialMenu()
        -sendReminderMenu()
        -lendMenu()
        -calculateMenu()
        -searchMenu()
    }

    class Utils{
        -pressEnterToContinue()
        -printSeparator()
        -printWithDelay()
        -delayRun()
        -clearTerminal()
        -printRed()
        -printString()
    }

    class SaveLoadToFile{
        -saveToFile()
        -loadFromFile()
        -deleteFile()
    }

    class SendReminder{
        -sendThePost()
        -readReceipts()
    }

    class App{
        main(String[] args)
    }

    class Person {

    }

    class PrintOut{
        -printTitle()
        -printInstructions()
        -outroScreen()
    }

   

    App "1" -- "1" Menu
    App "1" -- "1" Utils
    Menu "1" -- "1" Utils
    Menu "1" -- "0..*" DatabaseIO
    Menu "1" -- "0..*" Person
    Menu "1" -- "0..*" Book
    Menu "1" -- "0..*" CompactDisk
    Menu "1" -- "0..*" Movie
    Menu "1" -- "0..*" Game
    Menu "1" -- "0..*" SaveLoadToFile
    Menu "1" -- "0..*" SendReminder
    DatabaseIO "1" -- "0..*" Person
    DatabaseIO "1" -- "0..*" Book
    DatabaseIO "1" -- "0..*" CompactDisk
    DatabaseIO "1" -- "0..*" Movie
    DatabaseIO "1" -- "0..*" Game

    SaveLoadToFile "1" -- "0..*" Person
    SendReminder "1" -- "0..*" Person


    Item <|-- Book
    Item <|-- CompactDisk
    Item <|-- Movie
    Item <|-- Game

```

---

## Nouns & Verbs

---

### Nouns

- Copy
- Available
- Title
- Author
- Year
- Price
- Platform
- Age Rating
- Pages
- Tracks
- Director
- Playtime
- Publisher
- Condition
- Duration
- Book
- Compact Disk
- Movie
- Game
- Genre

---

### Verbs - Actions

- Create a new item
- Delete an item
- Update an item
- List an item
- Search for an item
- Send a reminder
- Calculate the total value of the library
- Get the total value of a type of item
- Save the user list to a file
- Send a reminder
- Lend an item
- List the schema
- List the conditions of the items
- List the runtime of the movies
- List the number of pages of the books
- List the number of tracks of the CDs
- List the email addresses of the users
- Go back to the main menu
- Add a new table to the database
- Delete a table from the database
- List the last five books added to the database
- List the total value of the library
- Save users to a file
- Load users from a file

---

[Back to main page](README.md)
