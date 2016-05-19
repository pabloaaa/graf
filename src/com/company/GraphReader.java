package com.company;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class GraphReader {
    AbstractGraph g;
    GraphReader(AbstractGraph graph){ this.g = graph; }

    public AbstractGraph loadFromFile(String filename){
        Set<Conection> s;
        Conection c;
        try {
            FileReader file = new FileReader(filename);
            Scanner sc = new Scanner(file);
            while(sc.hasNextInt()) {
                c = new Conection(new Vertex(sc.nextInt()),new Vertex(sc.nextInt()),sc.nextInt());
                g.addConection(c);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return g;
    }

}
//    public int[] load_tab(String file_path) throws FileNotFoundException {
//        int i = 0;
//        int number;
//        int cnt = 0;
//
//        FileReader file = new FileReader(file_path);
//        Scanner sc = new Scanner(file);
//        cnt = getNumbersCount(sc, cnt);
//        sc.close();
//
//        file = new FileReader(file_path);
//        sc = new Scanner(file);
//
//        int[] tab = new int[cnt];
//        while (sc.hasNextInt()) {
//            number = sc.nextInt();
//            tab[i] = number;
//            ++i;
//        }
//        return tab;
//    }