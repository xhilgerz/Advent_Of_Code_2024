import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;

public class DayOne {
    public static void Day_1A() {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int total = 0;
        int count = 0;
        int multiple =0;
        //read the file
        try {
            File myObj = new File("AOC_D1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] numbers = data.split("   ");
                for (int i = 0; i<2; i++) {

                    int value = Integer.parseInt(numbers[i]);

                    if(i == 0){
                        left.add(value);
                    }
                    else{
                        right.add(value);
                    }

                }
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        //comparison

        int[] rightArray = new int[count];
        //moves sorted queue into an array
        for (int i = 0; i< count; i++){
            int rightNum = right.remove();
            rightArray[i] = rightNum;
        }

        while(!left.isEmpty()){
            int leftNum =left.remove();
            for (int i = 0; i< count; i++){
                if(rightArray[i] == leftNum){
                    multiple++;
                }

            }
            int similarity;
            similarity = leftNum * multiple;
            multiple = 0;
            total = total + similarity;
        }
        System.out.println(total);

    }
    public static void  Day_1B(){
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int total = 0;
        int count = 0;
        int multiple =0;
        //read the file
        try {
            File myObj = new File("AOC_D1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] numbers = data.split("   ");
                for (int i = 0; i<2; i++) {

                    int value = Integer.parseInt(numbers[i]);

                    if(i == 0){
                        left.add(value);
                    }
                    else{
                        right.add(value);
                    }

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        //comparison
        //moves sorted queue into an array
        while(!left.isEmpty() && !right.isEmpty()){
            int leftNum =left.remove();
            int rightNum = right.remove();

            int difference;
            difference = Math.abs(leftNum - rightNum);
            total = total + difference;
        }
        System.out.println(total);

    }


}
