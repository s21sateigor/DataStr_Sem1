package service;

import datastr.MyArrayList;
import datastr.SortingType;

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


