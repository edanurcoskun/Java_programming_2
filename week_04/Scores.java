package week_04;
// java_homework # 1
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Scores {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a URL: ");
        String URLString = new Scanner(System.in).next();
        File file = new File("Summary.txt");

        PrintWriter output = new PrintWriter(file);

        try {
            java.net.URL url = new java.net.URL(URLString);
            ArrayList<Integer> scoreArray = new ArrayList<>();
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                int score = input.nextInt();
                scoreArray.add(score);
            }

            int i = 0, total = 0;
            while (i < scoreArray.size()) {
                total = total + scoreArray.get(i);
                i++;
            }
            
            double avg = total / (double) scoreArray.size();;
            output.println("Scores = " + scoreArray + "\n" + "Total = " + total + "\n" + "Average = " + avg);
            output.close();

        } catch (java.net.MalformedURLException ex) {
            System.out.println("Invalid URL");
        }
        
        catch (java.io.IOException ex) {
            System.out.println("IO Errors");
        }

    }
}
