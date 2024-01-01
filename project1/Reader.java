class Reader { //represents a buyer or reader of the book

    //declare fields
    private String fullName;
    private int yearOfBirth;
    private int zipCode;

    ///Constructor that takes 3 parameters; reusable for initializing the fields
    public Reader(String fullName, int yearOfBirth, int zipCode) { 
        //Validation Rule: The length of the full name must be at least 3 characters and no longer than 20 characters.
        if (fullName != null && fullName.length() > 2 && fullName.length() < 21) {
            this.fullName = fullName;
        }

        //Validation Rule: The year of birth must be between 1923 and 2013.
        if (yearOfBirth > 1922 && yearOfBirth < 2014) {
            this.yearOfBirth = yearOfBirth;
        }
        
        this.zipCode = zipCode; 
    }

    //3 Getter methods
    public String getFullName() {
        return fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getZipCode() {
        return zipCode;
    }

    //3 Setter methods
    public void setFullName(String fullName) {
        if (fullName != null && fullName.length() > 2 && fullName.length() < 21) {
            this.fullName = fullName;
        }
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth > 1922 && yearOfBirth < 2014) {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
