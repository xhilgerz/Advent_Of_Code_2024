
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;
import java.util.Queue;
import java.util.LinkedList;


public class DayTwo {
    public static void Day_2A(){
        int count = 0;
        int j;
        int rows =  0;
        int[][] values = new int [2000][9];
        boolean safe = false;
        int direction = 3; //true positive false negative
        int comparison;

//counts the number of lines in order to delcare the size of the 2d array

        try {
            File myObj = new File("Inputs/AOC_D2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] numbers = data.split(" ");

                for(j = 0; j < numbers.length-1; j++ ) {
                    int value = Integer.parseInt(numbers[j]);
                    int nextValue = Integer.parseInt(numbers[j+1]);
                    int difference = value - nextValue;
                    System.out.print(value + " - " + nextValue +" is " + "(" + difference +")" + " ");
                    if(j == 0) {

                        if (difference > 0) {
                            direction = 1;
                        } else if (difference < 0) {
                            direction = -1;
                        } else {
                            break;
                        }
                    }

                        if ((direction == 1 && (difference >= 1 && difference <= 3)) ||
                                (direction == -1 && (difference <= -1 && difference >= -3)))
                        {
                            safe = true;
                        }
                        else{
                            safe = false;
                            System.out.print("-break-");

                            break;
                        }


                }
                if(safe) {
                    System.out.println(" Safe");
                    count++;
                }
                else{
                    System.out.println(" Not Safe");
                }
                safe = false;
                System.out.println();
                rows++;
                System.out.println("Count: " + count);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }

    public static void Day_2B(){
        int count = 0;
        int j;
        int rows =  0;
        int[][] values = new int [2000][9];
        boolean safe = false;
        int direction = 3; //true positive false negative
        int comparison;
        Queue<Integer> queue = new LinkedList<>();
        int dampener = 0;

//counts the number of lines in order to delcare the size of the 2d array

        try {
            File myObj = new File("Inputs/AOC_D2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] numbers = data.split(" ");

                for(j = 0; j < numbers.length-1; j++ ) {

                    int value = Integer.parseInt(numbers[j]);
                    int nextValue = Integer.parseInt(numbers[j+1]);



                    int difference = value - nextValue;
                    System.out.print(value + " - " + nextValue +" is " + "(" + difference +")" + " ");
                    if(j == 0) {
                        queue.add(value);
                        if (difference > 0) {
                            direction = 1;
                        } else if (difference < 0) {
                            direction = -1;
                        } else {
                            break;
                        }
                    }
                    queue.add(nextValue);
                    if ((direction == 1 && (difference >= 1 && difference <= 3)) ||
                            (direction == -1 && (difference <= -1 && difference >= -3)))
                    {
                        safe = true;
                    }
                    else{
                        safe = false;
                        dampener++;
                        System.out.print("-dampen-");
                        queue.remove();
                    }


                }
                if(safe) {
                    System.out.println(" Safe");
                    count++;
                }
                else{
                    System.out.println(" Not Safe");
                }
                safe = false;
                System.out.println();
                rows++;
                System.out.println("Count: " + count);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
