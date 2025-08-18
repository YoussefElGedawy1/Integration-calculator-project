import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CalcIn {
    float opA;
    float opB;
    char operation;

    public CalcIn(float opA, float opB, char operation) {
        this.opA = opA;
        this.opB = opB;
        this.operation = operation;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "C:\\Users\\ammar\\OneDrive\\Desktop\\INPUT\\CalcReadInput.txt";

   
        boolean fileCleared = false;
        while (true) {
            System.out.print("Enter 1 to clear existing file or 2 to continue appending to it: ");
            try {
                int fileChoice = sc.nextInt();
                if (fileChoice == 1) {
                    try {
                        FileWriter w = new FileWriter(filePath); 
                        w.write(""); 
                        w.close();
                        System.out.println("File cleared.");
                        fileCleared = true;
                        break;
                    } catch (IOException e) {
                        System.out.println("Error clearing the file:");
                        e.printStackTrace();
                        return;
                    }
                } else if (fileChoice == 2) {
                    System.out.println("Continuing with existing file.");
                    break;
                } else {
                    System.out.println("Please enter only 1 or 2.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                sc.nextLine(); 
            }
        }

        boolean flag = true;
        while (flag) {
            float a = 0;
            float b = 0;
            char x = ' ';

           
            while (true) {
                try {
                    System.out.print("Enter 1st float: ");
                    a = sc.nextFloat();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid float number.");
                    sc.nextLine();
                }
            }

            
            while (true) {
                try {
                    System.out.print("Enter 2nd float: ");
                    b = sc.nextFloat();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid float number.");
                    sc.nextLine(); 
                }
            }

            
            while (true) {
                System.out.print("Enter operation (+, -, *, /): ");
                String input = sc.next();
                if (input.length() != 1) {
                    System.out.println("Please enter a single character operation.");
                    continue;
                }
                x = input.charAt(0);
                if (x== '+' || x == '-' || x == '*' || x == '/') {
                    break;
                } else {
                    System.out.println("Invalid operation. Please enter +, -, *, or /.");
                }
            }

           
            try {
                FileWriter w = new FileWriter(filePath, true); 
                w.write(a + "|" + b + "|" + x + "\r\n");
                w.close();
                System.out.println("Data appended to file CalcReadInput.txt");
            } catch (IOException e) {
                System.out.println("Error occurred while writing to file:");
                e.printStackTrace();
            }

            
            int choice = 0;
            while (true) {
                System.out.print("Enter 1 to add another operation or 2 to exit: ");
                try {
                    choice = sc.nextInt();
                    if (choice == 1 || choice == 2) {
                        break;
                    } else {
                        System.out.println("Please enter only 1 or 2.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number: 1 or 2.");
                    sc.nextLine(); 
                }
            }

            flag = (choice == 1);
            if (!flag) {
                System.out.println("Goodbye!");
            }
        }

        sc.close();
    }
}
