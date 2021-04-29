package uppgift_8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main2 {
    public main2(){
        Path myPath = Paths.get("C:\\Users\\jonte\\IdeaProjects\\mytest\\src\\uppgift_8\\personuppgifter.txt");
        Path resultPath = Paths.get("C:\\Users\\jonte\\IdeaProjects\\mytest\\src\\uppgift_8\\tallPeople.txt");
        List<Person> persons = new ArrayList<>();
        String firstLine;
        String secondLine;
        String[] pData;
        try(PrintWriter w = new PrintWriter(Files.newBufferedWriter(resultPath));
            Scanner fileScanner = new Scanner(myPath);  )
        {
            while(fileScanner.hasNext()){
                Person tempPerson = new Person();
                firstLine = fileScanner.nextLine();
                pData = firstLine.split(",");
                if (fileScanner.hasNext()){
                    secondLine = fileScanner.nextLine();
                    pData = secondLine.split(",");
                    if (Integer.parseInt(pData[2].trim()) > 199){
                        w.print(firstLine + "\n" + secondLine+ "\n");
                    }
                }
            }
        }

        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(0);
        }
        catch (IOException e){
            System.out.println("Can't write to file");
            e.printStackTrace();
            System.exit(0);
        }
        catch (Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        main2 m = new main2();
    }
}
