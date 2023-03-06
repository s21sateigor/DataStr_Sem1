package service;

import datastr.MyArrayList;
import datastr.SortingType;
import model.Faculty;
import model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MainService {
    public static void main(String[] args) {

        MyArrayList charList = new MyArrayList();
        try{
            charList.add('a');
            charList.add('f');
            charList.add('b');
            charList.add('z', 0);
            System.out.println(charList.howManyElements());
            charList.remove(1);
            charList.print();
            System.out.println(charList.retrieve(1));
            System.out.println("Search: " + charList.search('b'));
            charList.add('d');
            charList.add('z');
            charList.add('a');
            charList.add('z');
            System.out.println(Arrays.toString(charList.retrieveNextNeighbour('z')));
            System.out.println(charList.sort(SortingType.ASC));
            charList.print();
            charList.makeEmpty();
            //charList.print(); // ja būs, tad būs exceptions, neredzēs tālākās rindas.
            charList.add('d');
            charList.print();
            MyArrayList fileList = getArrayElementsFromFile("C:/Users/sater/Documents/javamacibas/dataStr/DatuStr/resources/numbers.txt");
            fileList.print();
            fileList.add('z');
            fileList.remove(2);
            fileList.print();

            MyArrayList<String> stringList = new MyArrayList<>();
            stringList.add("Karina");
            stringList.add("Jānis");
            stringList.add("Žanis", 0);
            stringList.print();
            stringList.remove(1);
            stringList.print();

            MyArrayList<Student> studentList = new MyArrayList<>();
            studentList.add(new Student("Jānis", "Bērziņš", Faculty.ITF, "123456-12345"));
            studentList.add(new Student("Zanis", "Zarins", Faculty.TSF, "299999-12314"));
            studentList.print();
            
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public static MyArrayList getArrayElementsFromFile(String path) throws FileNotFoundException {
        File myFile = new File(path);
        FileInputStream myInputStream = new FileInputStream(myFile);
        Scanner myScanner = new Scanner(myInputStream);
        MyArrayList listFromPile = new MyArrayList();

        while(myScanner.hasNextLine()){
            String line = myScanner.nextLine();
            char element = line.charAt(0);
            listFromPile.add(element);
        }
        myScanner.close();
        return listFromPile;
    }
}


