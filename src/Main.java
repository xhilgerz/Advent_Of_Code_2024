//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input Day to present Answer for the Day 1 - 25 Type A or B for part questions");
        String input = s.nextLine();

        switch (input) {
            case "1A":
                DayOne.Day_1A();
                break;

            case "1B":
                DayOne.Day_1B();
                break;

            case "2":

                break;
        }

    }
}


