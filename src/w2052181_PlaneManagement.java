import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;


public class w2052181_PlaneManagement {
    // make ticket object list
    private static Ticket[] ticketList = new Ticket[52];
    private static int ticketCount = 0;

    // show main menu of plane management( task 02)
    static void Menu() {
        System.out.println("***************************************************" + "\n" +
                "*                     MENU                        *" + "\n" +
                "***************************************************" + "\n" +
                "    1) Buy a seat " + "\n" +
                "    2) Cancel a seat " + "\n" +
                "    3) Find first available seat " + "\n" +
                "    4) Show seating plan " + "\n" +
                "    5) Print tickets information and total sales " + "\n" +
                "    6) Search ticket " + "\n" +
                "    0) Quit    " + "\n" +
                "***************************************************");

    }

    // mark on seat plan after buy ticket(task 8)
    public static void seatArrange(char[][] seatPlan, int seatNum, int row) {
        char seat = seatPlan[row][seatNum - 1];
        if (seat == 'O') {
            System.out.println("Seat availability : 1");
            seatPlan[row][seatNum - 1] = 'X';
            System.out.println("Seat booking was successful !!!");
        } else {
            System.out.println("0");
        }
    }

    // change seat plan and delete ticket from ticket array ( task 9 ,task 4)
    public static void seatArrangeC(char[][] seatPlan, int seatNum, int row) {
        char seat = seatPlan[row][seatNum - 1];
        if (seat == 'X') {
            System.out.println("0");
            seatPlan[row][seatNum - 1] = 'O';
            System.out.println("Seat booking removed successfully !!!");
            for (int i = 0; i < ticketList.length; i++) {
                Ticket ticket1 = ticketList[i];
                if (ticket1 != null && ticket1.getSeat() == seatNum && ticket1.getRow() == row) {
                    // Remove the ticket by shifting elements
                    for (int j = i; j < ticketList.length - 1; j++) {
                        ticketList[j] = ticketList[j + 1];
                    }
                    ticketList[ticketList.length - 1] = null;
                    ticketCount--;// Set the last element to null
                    break; // Break the loop once the ticket is removed
                }
            }
        } else {
            System.out.println("0");
        }
    }


    // get personal data and make person and ticket objects(task 7 and task 8)
    private static final String emailFormat = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String nameFormat = "^[A-Za-z]+(?:[ -][A-Za-z]+)*$";

    private static final Pattern emailPattern = Pattern.compile(emailFormat);
    private static final Pattern namePattern = Pattern.compile(nameFormat);

    public static boolean validateEmail(final String email) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validateName(final String name) {
        Matcher matcher = namePattern.matcher(name);
        return matcher.matches();
    }

    public static void arrayArrange(int seatNum, int seatRow, int price) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String name = scanner.nextLine();
        if (validateName(name)) {
            System.out.println("Saved *");
        } else {
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter your surname:");
        String surname = scanner.nextLine();
        if (validateName(surname)) {
            System.out.println("Saved *");
        } else {
            System.out.println("Invalid name");
            return; // Exit the method if name is invalid
        }

        System.out.println("Enter your email address:");
        String email = scanner.nextLine();
        if (validateEmail(email)) {
            System.out.println("Valid email address");
        } else {
            System.out.println("Invalid email address");
        }

        Person person = new Person(name, surname, email);
        char seatRowLetter = Ticket.getSeatRow(seatRow);
        Ticket ticket = new Ticket(seatRowLetter, seatNum, price, person);
        ticketCount++;
        ticketList[ticketCount] = ticket;


    }

    //Get input from user for booking seat (task 4, task 9)
    public static void BuySeat(char[][] seatPlan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Seat Row : ");
        String seatRow = scanner.next();

        if (seatRow.equalsIgnoreCase("A")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (seatNum == 1 || seatNum == 2 || seatNum == 3 || seatNum == 4 || seatNum == 5) {
                int price = 200;
                arrayArrange(seatNum, 0, price);
                seatArrange(seatPlan, seatNum, 0);
                save(seatPlan, seatNum, 0, seatRow.charAt(0));

            } else if (seatNum == 6 || seatNum == 7 || seatNum == 8 || seatNum == 9) {
                int price = 150;
                arrayArrange(seatNum, 0, price);
                seatArrange(seatPlan, seatNum, 0);
                save(seatPlan, seatNum, 0, seatRow.charAt(0));
            } else if (seatNum==10||seatNum==11||seatNum==12||seatNum==13|| seatNum==14){
                int price = 180;
                arrayArrange(seatNum, 0, price);
                seatArrange(seatPlan, seatNum, 0);
                save(seatPlan, seatNum, 0, seatRow.charAt(0));
            }else {
                System.out.println("Enter a valid Seat number ");
            }

        } else if (seatRow.equalsIgnoreCase("B")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 12) {
                if (seatNum == 1 || seatNum == 2 || seatNum == 3 || seatNum == 4 || seatNum == 5) {
                    int price = 200;
                    arrayArrange(seatNum, 1, price);
                    seatArrange(seatPlan, seatNum, 1);
                    save(seatPlan, seatNum, 1, seatRow.charAt(0));

                } else if (seatNum == 6 || seatNum == 7 || seatNum == 8 || seatNum == 9) {
                    int price = 150;
                    arrayArrange(seatNum, 1, price);
                    seatArrange(seatPlan, seatNum, 1);
                    save(seatPlan, seatNum, 1, seatRow.charAt(0));
                } else {
                    int price = 180;
                    arrayArrange(seatNum, 1, price);
                    seatArrange(seatPlan, seatNum, 1);
                    save(seatPlan, seatNum, 1, seatRow.charAt(0));
                }

            } else {
                System.out.println("Enter a valid Seat number ");
                }

        } else if (seatRow.equalsIgnoreCase("C")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 12) {
                if (seatNum == 1 || seatNum == 2 || seatNum == 3 || seatNum == 4 || seatNum == 5) {
                    int price = 200;
                    arrayArrange(seatNum, 2, price);
                    seatArrange(seatPlan, seatNum, 2);
                    save(seatPlan, seatNum, 2, seatRow.charAt(0));

                } else if (seatNum == 6 || seatNum == 7 || seatNum == 8 || seatNum == 9) {
                    int price = 150;
                    arrayArrange(seatNum, 2, price);
                    seatArrange(seatPlan, seatNum, 2);
                    save(seatPlan, seatNum, 2, seatRow.charAt(0));
                } else {
                    int price = 180;
                    arrayArrange(seatNum, 2, price);
                    seatArrange(seatPlan, seatNum, 2);
                    save(seatPlan, seatNum, 2, seatRow.charAt(0));
                }

            } else {
                System.out.println("Enter a valid Seat number ");

            }

        } else if (seatRow.equalsIgnoreCase("D")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 14) {
                if (seatNum == 1 || seatNum == 2 || seatNum == 3 || seatNum == 4 || seatNum == 5) {
                    int price = 200;
                    arrayArrange(seatNum, 3, price);
                    seatArrange(seatPlan, seatNum, 3);
                    save(seatPlan, seatNum, 3, seatRow.charAt(0));

                } else if (seatNum == 6 || seatNum == 7 || seatNum == 8 || seatNum == 9) {
                    int price = 150;
                    arrayArrange(seatNum, 3, price);
                    seatArrange(seatPlan, seatNum, 3);
                    save(seatPlan, seatNum, 3, seatRow.charAt(0));
                } else {
                    System.out.println("Enter a valid Seat number ");

                }

            } else {
                System.out.println("Enter a valid Seat number ");

            }
        } else {
            System.out.println("Enter Valid Input ");

        }

    }

    // Get Get input from user for cancel seat (task 4, task 9))
    public static void cancelSeat(char[][] seatPlan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Seat Row : ");
        String seatRow = scanner.next();
        if (seatRow.equalsIgnoreCase("A")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 14) {
                seatArrangeC(seatPlan, seatNum, 0);
            } else {
                System.out.println("Enter a valid Seat number ");
            }
        } else if (seatRow.equalsIgnoreCase("B")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 12) {
                seatArrangeC(seatPlan, seatNum, 1);
            } else {
                System.out.println("Enter a valid Seat number ");
            }
        } else if (seatRow.equalsIgnoreCase("C")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 12) {
                seatArrangeC(seatPlan, seatNum, 2);
            } else {
                System.out.println("Enter a valid Seat number ");
                return;
            }
        } else if (seatRow.equalsIgnoreCase("D")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 14) {
                seatArrangeC(seatPlan, seatNum, 3);
            } else {
                System.out.println("Enter a valid Seat number ");
                return;
            }
        } else {
            System.out.println("Enter Valid Input ");
            return;
        }
    }

    public static void find_first_available(char[][] seatPlan) {
        for (int i = 0; i < seatPlan.length; i++) {
            for (int j = 0; j < seatPlan[i].length; j++) {
                if (seatPlan[i][j] == 'O') {
                    if (i == 0) {
                        System.out.println("Seat Available on A Seat row");
                        return;
                    } else if (i == 1) {
                        System.out.println("Seat Available on B Seat row");
                        return;
                    } else if (i == 2) {
                        System.out.println("Seat Available on C Seat row");
                        return;
                    } else if (i == 3) {
                        System.out.println("Seat Available on D Seat row");
                        return;
                    }
                }
            }
        }
    }


    // Display seat plan
    public static void show_seating_plan(char[][] seatPlan) {
        for (int i = 0; i < seatPlan.length; i++) {
            for (int j = 0; j < seatPlan[i].length; j++) {
                System.out.print(seatPlan[i][j] + " ");

            }
            System.out.println();
        }

    }


    // Display ticket information
    public static void print_ticket_info() {
        int totalPrice = 0;
        for (Ticket ticket : ticketList) {

            if (ticket != null) {
                System.out.println(ticket.toStrige());
                totalPrice += ticket.getPrice();
                System.out.println("total amount £ :" + totalPrice);

            }

        }
    }

    // search seat and Show details of ticket
    public static void search_ticket(char[][] seatPlan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Seat Row : ");
        String seatRow = scanner.next();
        if (seatRow.equalsIgnoreCase("A")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 14) {
                System.out.println(seatDetail(seatPlan, seatNum, 0));


            } else {
                System.out.println("Enter a valid Seat number ");
            }
        } else if (seatRow.equalsIgnoreCase("B")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 12) {
                System.out.println(seatDetail(seatPlan, seatNum, 1));

            } else {
                System.out.println("Enter a valid Seat number ");
            }
        } else if (seatRow.equalsIgnoreCase("C")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 12) {
                System.out.println(seatDetail(seatPlan, seatNum, 2));

            } else {
                System.out.println("Enter a valid Seat number ");
                return;
            }
        } else if (seatRow.equalsIgnoreCase("D")) {
            System.out.println("Enter The Seat Number : ");
            int seatNum = scanner.nextInt();
            if (0 < seatNum && seatNum <= 14) {
                System.out.println(seatDetail(seatPlan, seatNum, 3));


            } else {
                System.out.println("Enter a valid Seat number ");
                return;
            }
        } else {
            System.out.println("Enter Valid Input ");
            return;
        }

    }
// check ticket array and display ticket detail

    public static String seatDetail(char[][] seatPlan, int seatNum, int row) {
        char seat = seatPlan[row][seatNum - 1];
        if (seat == 'X') {
            for (int i = 0; i < ticketList.length; i++) {
                Ticket ticket1 = ticketList[i];
                if (ticket1 != null && ticket1.getSeat() == seatNum && ticket1.getRowInChar() == row) {
                    // Remove the ticket by shifting elements
                    String output = ticket1.toStrige() + "\n" + ticket1.toStrigePerson();
                    return output;

                }

            }

        }
        return "Cant find any details";
    }

    // make file and write detail of ticket
    public static void save(char[][] seatPlan, int seatNum, int row, char seatRow) {
        String fileName = String.valueOf(seatRow);
        File file = new File(fileName + seatNum + ".txt");
        try {
            boolean file_created = file.createNewFile();
            if (file_created) {
                FileWriter writer = new FileWriter(fileName + seatNum + ".txt");

                String details = seatDetail(seatPlan, seatNum, row);
                writer.write(details);
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("ERROR:File could not be created ");
        }

    }

    public static void main(String[] args) {
        char[][] seatPlan = new char[4][];

        seatPlan[0] = new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};
        seatPlan[1] = new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};
        seatPlan[2] = new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};
        seatPlan[3] = new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};
        boolean flow = true;
        while (flow) {
            try {

                System.out.println("Welcome to the Plane Management application");
                Menu();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please select an option :");
                int Option = scanner.nextInt();
                switch (Option) {
                    case 1:
                        BuySeat(seatPlan);
                        break;
                    case 2:
                        cancelSeat(seatPlan);
                        break;
                    case 3:
                        find_first_available(seatPlan);
                        break;
                    case 4:
                        show_seating_plan(seatPlan);
                        break;
                    case 5:
                        print_ticket_info();
                        break;
                    case 6:
                        search_ticket(seatPlan);
                        break;
                    case 0:
                        System.out.println(" Thank you !!!");
                        flow = false;
                        break;
                    default:
                }
            } catch (Exception ex) {
                System.out.println("Enter Valid Number ");
            }
        }
    }
}
