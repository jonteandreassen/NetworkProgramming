package uppgift_8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class uppgiftMain {
    public uppgiftMain(){
        Path myPath = Paths.get("C:\\Users\\jonte\\IdeaProjects\\mytest\\src\\uppgift_8\\personuppgifter.txt");
        Path resultPath = Paths.get("C:\\Users\\jonte\\IdeaProjects\\mytest\\src\\uppgift_8\\tallPeople.txt");
        List<Person> persons = new ArrayList<>();
        String firstLine;
        String secondLine;
        String[] pData1;
        String[] pData2;
        String[] pArray = new String[6];
        try(PrintWriter w = new PrintWriter(Files.newBufferedWriter(resultPath));
        Scanner fileScanner = new Scanner(myPath);){
            while(fileScanner.hasNext()){
                Person newP = new Person();
                firstLine = fileScanner.nextLine();
                pData1 = firstLine.split(",");
                pArray[0] = pData1[0];
                pArray[1] = pData1[1];
                pArray[2] = pData1[2];

                newP.setName(pData1[0]);
                newP.setAdress(pData1[1]);
                newP.setPostNr(pData1[2]);

                if(fileScanner.hasNext()){
                    secondLine = fileScanner.nextLine();
                    pData2 = secondLine.split(",");
                    pArray[3] = pData2[0];
                    pArray[4] = pData2[1];
                    pArray[5] = pData2[2];
                    newP.setAge(Integer.parseInt(pData2[0].trim()));
                    newP.setWeight(Integer.parseInt(pData2[1].trim()));
                    newP.setLenght(Integer.parseInt(pData2[2].trim()));

                    Person p = new Person(pData1[0].trim(), pData1[1].trim(), pData1[2].trim(),
                            Integer.parseInt(pData2[0].trim()),
                            Integer.parseInt(pData2[1].trim()),
                            Integer.parseInt(pData2[2].trim()));

                    persons.add(newP);
                    if(Integer.parseInt(pData2[2].trim()) > 199){
                        w.print(firstLine + "\n" + secondLine + "\n");
                    }
                    Files.delete(resultPath);
                    Files.createFile(resultPath);
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
    public static void main(String[] args){
        uppgiftMain m = new uppgiftMain();
    }
}
