class Book { //represents a book in the library

    //declare fields
    private String title;
    private String author;
    private int publicationYear;
    private float rating;
    private long isbn;
    private String status = "Available"; //Available by default
    private Reader[] readersHistory; //list of readers who rented the book
    private int[] ratingsHistory; //list of ratings provided by readers when returning the book

    //Constructor that takes 4 parameters
    public Book(String title, String author, int publicationYear, long isbn) {
            this.title = title;
            this.author = author;
            this.publicationYear = publicationYear;
            this.isbn = isbn;
            this.status = "Available"; //Available by default
            this.readersHistory = null; //null by default
            this.ratingsHistory = null; //null by default
    }

    //5 setter methods to change the value of attributes
    //Validation rules: The title cannot be null and must be at least 2-character long
    public void setTitle(String title) { 
        if (title != null && title.length() > 1) {
            this.title = title;
        }
    }

    //Validation rules: The author cannot be null and must be at least 5-character long
    public void setAuthor(String author) {
        if (author != null && author.length() > 4) {
            this.author = author;
        }
    }

    //Validation rules: The year of publication must be between 1700 and 2023 (inclusive)
    public void setPublicationYear(int publicationYear) {
        if (publicationYear > 1699 && publicationYear < 2024) {
            this.publicationYear = publicationYear;
        }
    }

    // Validation rules: For books published before 2007, the ISBN must be 10-digit long
    public void setIsbn(long isbn) {
        if (publicationYear < 2006 && Long.toString(isbn).length() == 10) {
            this.isbn = isbn;
        }
        // From 2007 and later, the ISBN is 13-digit long.
        else if (publicationYear > 2006 && Long.toString(isbn).length() == 13) {
            this.isbn = isbn;
        }
    }

    //Validation rules: It can only be one of those three values: Available, Rented, or Archived
    public void setStatus(String status) {
        if  ("Available".equals(status) || "Rented".equals(status) || "Archived".equals(status)) {
            this.status = status;
        }
    }

    //6 getter methods to retreive the value of attributes
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public float getRating() {
        return rating;
    }
    public long getIsbn() {
        return isbn;
    }
    public String getStatus() {
        return status;
    }

    //Set the status of the book to “Archived"
    public boolean archive() { 
         if ("Available".equals(status)) { //check availibility. Rented books can't be archived.
            status = "Archived"; //set new status. Archived books can't be rented anymore.
            return true; //book is now archived
            } else {
                return false; //book is not available to archive
                }
    }

    //add a reader to the list of readers
    public boolean rent(Reader reader) {
        if ("Available".equals(status)){ //check availibility. Only available books can be rented.
            for (int i = 0; i < readersHistory.length; i++) {
            if (readersHistory[i] == null) {
                readersHistory[i] = reader; // +1 to reader's list
                status = "Rented"; //change status
                return true;
                }
            }
        }
        return false;
    }

    //return the last reader
    public Reader getLastReader() {
        if (readersHistory != null) { //make sure there is atleast 1 reader
            for (int i = readersHistory.length - 1; i >= 0; i--) { //find the last reader using reverse iteration
            if (readersHistory[i] != null) {
                return readersHistory[i];
                }
            }
        }
        return null;//no one has read this book 
        }
    
    //record rating from readers
    public boolean addRating(Reader reader, int rating) { 
        if (ratingsHistory != null) { //checks if the reader is in readersHistory
            for (int i = 0; i < ratingsHistory.length; i++) { //iterates to update last corresponding location
                if (ratingsHistory[i] == 0) { 
                    ratingsHistory[i] = rating;
                    return true; 
                    }
                }
            }
    return false; 
}

    public String toString() { //represents book in format -> "Harry Potter" by J.K. Rowling (1997) - Rating:3.6 - Available
        return "\"" + title + "\" by " + author + " (" + publicationYear + ") - Rating:" + this.rating + " - " + status;
    }
}