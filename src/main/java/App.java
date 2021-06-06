import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Erica Joseph
 */
public class App {
    public static void main(String[] args) {
        //initiate scannner
        Scanner sc = new Scanner(System.in);
        DecimalFormat df2 = new DecimalFormat("#.#####");
//input
        System.out.print("How much alcohol have you consumed? (oz) ");
        int consumed = sc.nextInt();
        System.out.print("What is your weight? (lb) ");
        int weight = sc.nextInt();
        System.out.print("What is your gender? (male or female) ");
        String gender = sc.next().toLowerCase();
        System.out.print("How many hours have elapsed since consumption? ");
        int hours = sc.nextInt();
//calculation
        if(gender.equals("male")){
            double alcdis = 0.73;
            double BACmale = (consumed *( 5.14 / weight) * alcdis) - .015 * hours;
            if(BACmale>0.08){
                System.out.println("Your BAC is " + df2.format(BACmale));
                System.out.println("It is not legal for you to drive.");
            }
            else if(BACmale<0.08){
                System.out.println("Your BAC is " + df2.format(BACmale));
                System.out.println("It is legal for you to drive.");
            }
        }
        else if(gender.equals("female")){
            double alcdis = 0.66;
            double BACfemale = (consumed * 5.14 / weight * alcdis) - .015 * hours;
            if(BACfemale>0.08){
                System.out.println("Your BAC is " + df2.format(BACfemale));
                System.out.println("It is not legal for you to drive.");
            }
            else if(BACfemale<0.08){
                System.out.println("Your BAC is " + df2.format(BACfemale));
                System.out.println("It is legal for you to drive.");
            }
        }

        if(!gender.equals("female") && !gender.equals("male")){
            System.out.println("Please enter a valid gender.");
        }
    }
}
