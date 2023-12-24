class Library { //represents a library
    
    //declare fields
    private String name;
    private String address;
    private Book[] books; //array of books
    
    //Constructor that takes 2 parameters
    public Library(String name, String address) { //initialize name and address
        this.name = name;
        this.address = address;
        }
    
    //2 Getter methods
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    //2 setter methods
    //Validation rules: The library name must be at least 9 characters and no longer than 20 characters. 
    public void setName(String name) {
        if (name != null && name.length() > 8 && name.length() < 21) { //makes sure name != null, and is valid and is valid based on length()
            this.name = name;
        }
    }

    //Validation rules: The library address must be at least 10 characters and no longer than 25 characters. 
    public void setAddress(String address) {
        if (address != null && address.length() > 9 && address.length() < 26) { //makes sure address != null, and is valid based on length()
            this.address = address;
        }
    }

    //additional methods
    public Book[] getAvailableBooks() { //return list of available books
        int booksAvailable = 0;

        for (Book book : books) { //for loop checks the status of each book to determine availibility
            if ("Available".equals(book.getStatus())) {
                booksAvailable++;
            }
        }
        if (booksAvailable == 0) {
            return null; // no available books
        }

        Book[] availableBooks = new Book[booksAvailable]; //array stores available books
        int i = 0;
        for (Book book : books) {
            if ("Available".equals(book.getStatus())) {
                availableBooks[i++] = book;
        }
    }
    return availableBooks;
    }

    public boolean addBook(Book book) { // Add book to library
    if ("Available".equals(book.getStatus())) {
            for (Book oldBook : books) {
                if (oldBook.equals(book)) { //checks if there's a duplicate/ if the book is already in the library
                    return false; //book already in library
                }
            }

            Book[] newBooks = new Book[books.length + 1]; //new array to accomodate new books
            System.arraycopy(books, 0, newBooks, 0, books.length);
            newBooks[newBooks.length - 1] = book;
            books = newBooks;

            return true;
        }
        return false; // Cannot add a non-available book
    }

    public boolean removeBook(Book book) { //remove archived books from library
        if ("Archived".equals(book.getStatus())) {
            int removeBook = -1; //index that needs to be removed
            for (int i = 0; i < books.length; i++) {
                if (books[i].equals(book)) {
                    removeBook = i;
                    break;
                }
            }
            if (removeBook != -1) {
                Book[] newBook = new Book[books.length - 1]; //new array to accomodate after removing books
                System.arraycopy(books, 0, newBook, 0, removeBook);
                System.arraycopy(books, removeBook + 1, newBook, removeBook, books.length - removeBook - 1);
                books = newBook;
                return true;
                }
            }
        return false; // Cannot remove rented or available books
        }

    public boolean rentBook(int i, Reader reader) { //Rents a book to a reader based on its index in the collection
        if (i >= 0 && i < books.length && "Available".equals(books[i].getStatus())) {
            boolean booksRented = books[i].rent(reader);
            if (booksRented) {
                return true;
            }
        }
        return false; 
    }

    public boolean returnBook(Book book, int rating) { //Handles the return of a rented book and updates its status and rating
         if ("Rented".equals(book.getStatus())) {
            boolean booksReturned = book.addRating(book.getLastReader(), rating);
            if (booksReturned) {
                book.setStatus("Available");
                return true;
            }
        }
        return false;
    }

    public String toString() {
         int booksAvailable = 0;

         for (Book book : books) {
            if ("Available".equals(book.getStatus())) {
                booksAvailable++;
            }
        }
        return "Library " + name + " has " + booksAvailable + " books available";
    }

    public String displayBooks() {

        String finalList = "";

        for (Book book : books) {
            if ("Available".equals(book.getStatus())) { //Extract book details and format them
                String title = book.getTitle();
                String author = book.getAuthor();
                int publicationYear = book.getPublicationYear();
                float rating = book.getRating();
                String status = book.getStatus();
                
                finalList += "\"" + title + "\" by " + author + " (" + publicationYear + ") -- Rating:" + rating + " -- " + status;
            }
        }
        return finalList; //return final list
    }
}