package EnrolmentSystem;

import java.util.Scanner;

public class Menu {
    //Instance Variables
    static StudentList studentList = StudentList.getInstance();
    static CourseList courseList = CourseList.getInstance();
    static StudentEnrolmentList studentEnrolmentList = StudentEnrolmentList.getInstance();
    boolean exit;

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice(0, 7);
            doAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("Welcome to Student Enrolment System");
    }

    private void printMenu() {
        System.out.println("\n1) Add new enrolment");
        System.out.println("2) Edit an enrolment");
        System.out.println("3) View an enrolment");
        System.out.println("4) View all enrolments");
        System.out.println("5) Delete an enrolment");
        System.out.println("6) Update enrolments in a semester");
        System.out.println("7) View and generate enrolment report");
        System.out.println("0) Exit");
    }

    private int getMenuChoice(int lowerBound, int upperBound) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("\nEnter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Only number allowed.");
            }
            if (choice < lowerBound || choice > upperBound) {
                System.out.println("Input out of range.");
            }
        } while (choice < lowerBound || choice > upperBound);
        return choice;
    }

    private void doAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            case 1: {
                if (studentEnrolmentList.add(new StudentEnrolment(studentList.getStudent(),
                        courseList.getCourse(), getSemester()))) {
                    System.out.println("Enrolment added successfully.");
                } else {
                    System.out.println("This enrolment already exists!");
                }
            }
            break;
            case 2:
                StudentEnrolment studentEnrolment = studentEnrolmentList.getOne();
                if (studentEnrolment == null){
                    break;
                }
                System.out.println("1) Change the student");
                System.out.println("2) Change the course");
                System.out.println("2) Change the semester");
                int option = getMenuChoice(1, 3);
                switch (option) {
                    case 1 -> {
                        Student student = studentList.getStudent();
                        StudentEnrolment newStudentEnrolment = new StudentEnrolment(student, studentEnrolment.getCourse(), studentEnrolment.getSemester());
                        studentEnrolmentList.update(studentEnrolment, newStudentEnrolment);
                    }
                    case 2 -> {
                        Course course = courseList.getCourse();
                        StudentEnrolment newStudentEnrolment = new StudentEnrolment(studentEnrolment.getStudent(), course, studentEnrolment.getSemester());
                        studentEnrolmentList.update(studentEnrolment, newStudentEnrolment);
                    }
                    case 3 -> {
                        String semester = getSemester();
                        StudentEnrolment newStudentEnrolment = new StudentEnrolment(studentEnrolment.getStudent(), studentEnrolment.getCourse(), semester);
                        studentEnrolmentList.update(studentEnrolment, newStudentEnrolment);
                    }
                }
                break;
            case 3:
                System.out.println(studentEnrolmentList.getOne());
                break;
            case 4:
                studentEnrolmentList.getAll();
                break;
            case 5:
                studentEnrolment = studentEnrolmentList.getOne();
                if(studentEnrolment != null){
                    studentEnrolmentList.delete(studentEnrolment);
                    System.out.println("Enrolment is successfully deleted.");
                }
                break;
            case 6:
                Student student = studentList.getStudent();
                String semester = getSemester();
                Course course;
                studentEnrolmentList.getCourseInASemester(student, semester);
                System.out.println("1) Add new course");
                System.out.println("2) Delete a course");
                option = getMenuChoice(1, 2);

                switch (option) {
                    case 1 -> {
                        course = courseList.getCourse();
                        if (studentEnrolmentList.add(new StudentEnrolment(student, course, semester))) {
                            System.out.println("Successfully added new course enrolment for student with id "
                                    + student.getStudentId() + " in semester " + semester + ".");
                        } else {
                            System.out.println("This enrolment already exists!");
                        }
                        studentEnrolmentList.getCourseInASemester(student, semester);
                    }
                    case 2 -> {
                        System.out.println("Please enter the course you want to delete");
                        course = courseList.getCourse();
                        StudentEnrolment studentEnrolment1 = studentEnrolmentList.get(student, course, semester);
                        if(studentEnrolment1 != null){
                            studentEnrolmentList.delete(studentEnrolment1);
                            System.out.println("Enrolment is successfully deleted.");
                        } else {
                            System.out.println("This enrolment does not exist");
                        }
                    }
                }
                break;
            case 7:
                System.out.println("1) View all courses for one student in a semester");
                System.out.println("2) View all students for one course in a semester");
                System.out.println("3) View all courses offered in a semester");
                option = getMenuChoice(1, 3);

                switch (option) {
                    case 1:
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Please enter the student id");
                        student = studentList.get(scanner.nextLine());
                        System.out.println("Please enter the semester");
                        semester = scanner.nextLine();
                        studentEnrolmentList.getCourseInASemester(student, semester);
                        break;
                    case 2:
                        scanner = new Scanner(System.in);
                        System.out.println("Please enter the course id");
                        course = courseList.get(scanner.nextLine());
                        System.out.println("Please enter the semester");
                        semester = scanner.nextLine();
                        studentEnrolmentList.getStudentInACourse(course, semester);
                        break;
                    case 3:
                        //test
                        break;
                }
            default:
                System.out.println("Unknown error has occured.");
        }
    }

//    private String askQuestion(String question, List<String> answers) {
//        String response = "";
//        Scanner keyboard = new Scanner(System.in);
//        boolean choices = ((answers == null) || answers.size() == 0) ? false : true;
//        boolean firstRun = true;
//        do {
//            if (!firstRun) {
//                System.out.println("Invalid selection. Please try again.");
//            }
//            System.out.print(question);
//            if (choices) {
//                System.out.print("(");
//                for (int i = 0; i < answers.size() - 1; ++i) {
//                    System.out.print(answers.get(i) + "/");
//                }
//                System.out.print(answers.get(answers.size() - 1));
//                System.out.print("): ");
//            }
//            response = keyboard.nextLine();
//            firstRun = false;
//            if (!choices) {
//                break;
//            }
//        } while (!answers.contains(response));
//        return response;
//    }
//
//    private double getDeposit(String accountType) {
//        Scanner keyboard = new Scanner(System.in);
//        double initialDeposit = 0;
//        Boolean valid = false;
//        while (!valid) {
//            System.out.print("Please enter an initial deposit: ");
//            try {
//                initialDeposit = Double.parseDouble(keyboard.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println("Deposit must be a number.");
//            }
//            if (accountType.equalsIgnoreCase("checking")) {
//                if (initialDeposit < 100) {
//                    System.out.println("Checking accounts require a minimum of $100 dollars to open.");
//                } else {
//                    valid = true;
//                }
//            } else if (accountType.equalsIgnoreCase("savings")) {
//                if (initialDeposit < 50) {
//                    System.out.println("Savings accounts require a minimum of $50 dollars to open.");
//                } else {
//                    valid = true;
//                }
//            }
//        }
//        return initialDeposit;
//    }
//
//    private void createAnAccount() throws InvalidAccountTypeException {
//        displayHeader("Create an Account");
//        //Get account information
//        String accountType = askQuestion("Please enter an account type: ", Arrays.asList("checking", "savings"));
//        String firstName = askQuestion("Please enter your first name: ", null);
//        String lastName = askQuestion("Please enter your last name: ", null);
//        String ssn = askQuestion("Please enter your social security number: ", null);
//        double initialDeposit = getDeposit(accountType);
//        //We can create an account now;
//        Account account;
//        if (accountType.equalsIgnoreCase("checking")) {
//            account = new Checking(initialDeposit);
//        } else if (accountType.equalsIgnoreCase("savings")) {
//            account = new Savings(initialDeposit);
//        } else {
//            throw new InvalidAccountTypeException();
//        }
//        Customer customer = new Customer(firstName, lastName, ssn, account);
//        bank.addCustomer(customer);
//    }
//
//    private double getDollarAmount(String question) {
//        Scanner keyboard = new Scanner(System.in);
//        System.out.print(question);
//        double amount = 0;
//        try {
//            amount = Double.parseDouble(keyboard.nextLine());
//        } catch (NumberFormatException e) {
//            amount = 0;
//        }
//        return amount;
//    }
//
//    private void makeADeposit() {
//        displayHeader("Make a Deposit");
//        int account = selectAccount();
//        if (account >= 0) {
//            double amount = getDollarAmount("How much would you like to deposit?: ");
//            bank.getCustomer(account).getAccount().deposit(amount);
//        }
//    }
//
//    private void makeAWithdrawal() {
//        displayHeader("Make a Withdrawal");
//        int account = selectAccount();
//        if (account >= 0) {
//            double amount = getDollarAmount("How much would you like to withdraw?: ");
//            bank.getCustomer(account).getAccount().withdraw(amount);
//        }
//    }
//
//    private void listBalances() {
//        displayHeader("List Account Details");
//        int account = selectAccount();
//        if (account >= 0) {
//            displayHeader("Account Details");
//            System.out.println(bank.getCustomer(account).getAccount());
//        }
//    }

//    private void displayHeader(String message){
//        System.out.println();
//        int width = message.length() + 6;
//        StringBuilder sb = new StringBuilder();
//        sb.append("+");
//        for(int i = 0; i < width; ++i){
//            sb.append("-");
//        }
//        sb.append("+");
//        System.out.println(sb.toString());
//        System.out.println("|   " + message + "   |");
//        System.out.println(sb.toString());
//    }

//    private int selectAccount() {
//        Scanner keyboard = new Scanner(System.in);
//        ArrayList<Customer> customers = bank.getCustomers();
//        if (customers.size() <= 0) {
//            System.out.println("No customers at your bank.");
//            return -1;
//        }
//        System.out.println("Select an account:");
//        for (int i = 0; i < customers.size(); i++) {
//            System.out.println("\t" + (i + 1) + ") " + customers.get(i).basicInfo());
//        }
//        int account;
//        System.out.print("Please enter your selection: ");
//        try {
//            account = Integer.parseInt(keyboard.nextLine()) - 1;
//        } catch (NumberFormatException e) {
//            account = -1;
//        }
//        if (account < 0 || account > customers.size()) {
//            System.out.println("Invalid account selected.");
//            account = -1;
//        }
//        return account;
//    }

    public static String getSemester(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the semester: ");
        return scanner.nextLine();
    }
}
