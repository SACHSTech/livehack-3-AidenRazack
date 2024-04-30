class Problem1 extends ConsoleProgram {

  /**
  * A program that creates a username using a user's given name and student number and validates a given password.
  * @author: A. Razack 
  */
  
  public void run() {
    // Prompt the user for name, student number, and password
    System.out.println("***** Student Account Registration *****");
    String firstName = readLine("Enter your first name: ");
    String lastName = readLine("Enter your last name: ");
    String studentNumber = readLine("Enter your student number: ");
    String password = readLine("Enter a new password: ");
    System.out.println("");

    // Display username and password validation
    String userName = createUserName(firstName, lastName, studentNumber);
    println("Your username is: " + userName);

    boolean isValidPassword = validatePassword(password);
    println("Valid password: " + isValidPassword);
  }

  private String createUserName(String firstName, String lastName, String studentNumber) {

    // Throw an IllegalArguementException if the arguements are blank or if the student number is non 9 characters long
     if (firstName.isBlank() || lastName.isBlank() || studentNumber.isBlank()) {
        throw new IllegalArgumentException("incorrect parameter(s)");
    }

    if (studentNumber.length() != 9) {
        throw new IllegalArgumentException("incorrect parameter(s)");
    }

    // Create the username user the uppercase first inital of firstname, lowercase first 4 initials of last name, and last 3 digits of student number
    char firstInitial = firstName.charAt(0);
    firstInitial = Character.toUpperCase(firstInitial);

    String lastNameInitials = lastName.substring(0, Math.min(lastName.length(), 4)).toLowerCase();

    String lastThreeDigits = studentNumber.substring(Math.max(studentNumber.length() - 3, 0));

    String userName = firstInitial + lastNameInitials + lastThreeDigits;
    return userName; 
  }

  private boolean validatePassword(String password) {

    // Validate password if it has at least 7 characters, one uppercase letter, and consists of only letters and digits
    if (password.length() < 7) {
        return false;
    }
    
    boolean hasUppercase = false;
    boolean hasLetterOrDigit = false;
    
    for (char x : password.toCharArray()) {
        if (Character.isUpperCase(x)) {
            hasUppercase = true;
        }
        if (Character.isLetterOrDigit(x)) {
            hasLetterOrDigit = true;
        }
        if (hasUppercase && hasLetterOrDigit) {
            return true;
        }
    }

    return false;
  }
}