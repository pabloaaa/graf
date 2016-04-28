package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Set;

/**
 * Created by user on 4/28/16.
 */
public class GraphSaver {
    AbstractGraph g;
    GraphSaver(AbstractGraph graph){
        this.g = graph;
    }

    void saveToFile(String filename){
        Set<Conection> s = g.getAllConections();
        try {
            FileWriter w = new FileWriter(filename);
            for(Conection c: s) {
                w.write(String.valueOf(c) + "\n");
            }
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
