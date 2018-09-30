import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DecimalToBase {
    /*
     * Declarers variables for class.
     * Global variables are used here because these variables are used in several different methods.
     */
    private static int quotient;
    /**
     * Main method to call the run() method.
     * @param args
     */
    public static void main(String[] args) {
        run();
    }
    /**
     * Run method runs all calculations and prints messages.
     */
    private static void run(){
        Scanner scanner = new Scanner(System.in);
        /*
         * Do while loop for asking the user to enter a number in base 10.
         * The only check for this method is to validate if the input is a number.
         */
        boolean valid = false;
        do{
            if(printMessage(scanner)){
                valid = true;
            }
        }while (!valid);
        /*
         * Calls the function to convert the number in each base.
         */
        convertToBase(quotient,2);
        convertToBase(quotient,8);
        /*
         * Base 16 involves letters, therefore there needs to involve a different function.
         */
        convertToBase16(quotient);
    }

    /**
     * Converts the decimal number into the specified base.
     * @param number
     * @param base
     */
    private static void convertToBase(int number, int base){
        /*
         * An array list is used here to keep track of each digit.
         */
        ArrayList<Integer> remainder = new ArrayList<>();
        /*
         * Performs the calculation of the number in the base.
         */
        while (number !=0){
            remainder.add(number % base);
            number = number / base;
        }
        /*
         * The digits in the array are entered in backwards because the number starts at the final number.
         * Therefore, the Collection.reverse() method reverses the order and displays the number in the correct order.
         */
        Collections.reverse(remainder);
        print("Base " + base + ": " );
        /*
         * Prints the array.
         */
        for (int entry : remainder){
            print(entry + " ");
        }
        /*
         * Add an empty line for neatness.
         */
        println("");
    }
    private static void convertToBase16(int number){
        /*
         * An array list is used here to keep track of each digit/letter.
         */
        ArrayList<String> result = new ArrayList<>();
        int base16;
        /*
         * Performs the calculations.
         */
        while (number != 0){
            base16 = number % 16;
            /*
             * If the remainder of the calculation is greater than 9, the program interprets the remainder as a letter.
             */
            if (base16 > 9){
                base16 %= 10;
                switch(base16){
                    case 0:
                        result.add("A");
                        number /= 16;
                        break;
                    case 1:
                        result.add("B");
                        number /= 16;
                        break;
                    case 2:
                        result.add("C");
                        number /= 16;
                        break;
                    case 3:
                        result.add("D");
                        number /= 16;
                        break;
                    case 4:
                        result.add("E");
                        number /= 16;
                        break;
                    case 5:
                        result.add("F");
                        number /= 16;
                        break;
                }
            }else{
                /*
                 * Occurs when the remainder will still be a number instead of a letter.
                 */
                result.add(Integer.toString(number % 16));
                number /= 16;
            }
        }
        print("Base 16: ");
        /*
         * Prints each value in the result.
         */
        Collections.reverse(result);
        for (String str : result){
            print(str + " ");
        }
        println("");
    }
    private static boolean printMessage(Scanner scanner){
        print("Please enter a base 10 number: ");
        /*
         * Handles an input mismatch exception.
         * This occurs when the user inputs a letter instead of a number.
         */
        try{
            quotient = scanner.nextInt();}
        catch (InputMismatchException e){
            print("Incorrect base system. ");
            /*
             * Consumes whatever the user has input to the function.
             * If in the catch, whatever the user input, the program does not want.
             */
            scanner.next();
            return false;
        }
        return true;
    }
    /**
     * Shortcut to the System.out.print()
     * @param obj the object to print.
     */
    private static void print(Object obj){
        System.out.print(obj);
    }
    /**
     * Shortcut to the System.out.println()
     * @param obj the object to print.
     */
    private static void println(Object obj){
        System.out.println(obj);
    }
}
