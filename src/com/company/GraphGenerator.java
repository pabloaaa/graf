package com.company;

import java.util.Random;

/**
 * Created by user on 5/28/16.
 */
public class GraphGenerator {
    Random r =  new Random(10);
    public AbstractGraph generateListGraph(int vertex_nr, int density){
        AbstractGraph g =  generateMatrixGraph(vertex_nr,density);
        AbstractGraph final_graph = new ListGraph();
        for (Conection c: g.getAllConections()){
            final_graph.addConection(c);
        }
        return final_graph;
    }

    public AbstractGraph generateMatrixGraph(int vertex_nr, int density){
        AbstractGraph graph;
        graph = new MatrixGraph(vertex_nr);
        int avaible_conn_nr = vertex_nr*vertex_nr/2;
        int added_conn = 0;

        for(int i = 0 ; i < vertex_nr ; ++i){
            if(i+1 < vertex_nr) {
                graph.addConection(new Conection(new Vertex(i), new Vertex(i + 1), r.nextInt(100)));
            }
        }

        for(int i = 0 ; i < vertex_nr; ++i){
            for(int j =0; j < i ; ++j){
                if(generationCompleted(added_conn,avaible_conn_nr,density)) {
                    return graph;
                }
                graph.addConection(new Conection(new Vertex(i), new Vertex(j), r.nextInt(100)));
                added_conn++;
            }
        }
        return graph;
    }

    private boolean generationCompleted(int added_conn, int avaible_conn_nr, int density) {
        int current_density = added_conn*100/avaible_conn_nr;
        return current_density >= density;
    }
}
