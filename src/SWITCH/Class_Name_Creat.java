package SWITCH;

import java.util.Scanner;

public class Class_Name_Creat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        String output = str
                .replace(' ', '_')      // replace spaces with underscores
                .replaceAll("_+$", ""); // remove trailing underscores

        System.out.println(output);
    }
}