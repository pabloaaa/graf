package com.company;


import java.util.*;

public class ListGraph implements AbstractGraph {
    Map<Vertex,ArrayList<Conection>> graph;

    public ListGraph(){
        graph = new HashMap<Vertex,ArrayList<Conection>>();
    }
    @Override
    public void addConection(Conection c) {
        if(graph.containsKey(c.getA())){
            ArrayList<Conection> tmp = graph.get(c.getA());
            tmp.add(c);
        }else{
            ArrayList<Conection> con = new ArrayList<Conection>();
            con.add(c);
            graph.put(c.getA(),con);
        }
        if(graph.containsKey(c.getB())){
            ArrayList<Conection> tmp = graph.get(c.getB());
            tmp.add(c);
        }else{
            ArrayList<Conection> con = new ArrayList<Conection>();
            con.add(c);
            graph.put(c.getB(),con);
        }
    }

    @Override
    public int getDistance(Vertex uno, Vertex dos) {
        if(graph.containsKey(uno)){
            ArrayList<Conection> connections = graph.get(uno);
            for(int i=0; i<connections.size(); i++){
                Conection c = connections.get(i);
                if( (c.getA().equals(uno) && c.getB().equals(dos)) ||
                    (c.getA().equals(dos) && c.getB().equals(uno)) ){
                    return connections.get(i).getLength();
                }
            }
            return -1;
        }else{
            System.out.println("Nie ma takiego polaczenia");
            return -1;
        }
    }
    @Override
    public ArrayList<Conection> getConections(Vertex uno){
        if(graph.containsKey(uno)){
            return graph.get(uno);
        }else{
            return null;
        }
    }
    @Override
    public void removeConection(Conection conection) {
        if(graph.containsKey(conection.getA())){
            ArrayList<Conection> tmp = graph.get(conection.getA());
            for(int i =0; i<tmp.size(); i++){
                Conection c = tmp.get(i);
                if(c.getA().equals(conection.getA()) && c.getB().equals(conection.getB()) ||
                        c.getA().equals(conection.getB()) && c.getB().equals(conection.getA())){
                    tmp.remove(i);
                }
            }
        }else{
            System.out.println("nie ma polaczenia");
        }
        if(graph.containsKey(conection.getB())){
            ArrayList<Conection> tmp = graph.get(conection.getB());
            for(int i =0; i<tmp.size(); i++){
                Conection c = tmp.get(i);
                if(c.getA().equals(conection.getA()) && c.getB().equals(conection.getB()) ||
                        c.getA().equals(conection.getB()) && c.getB().equals(conection.getA())){
                    tmp.remove(i);
                }
            }
        }else{
            System.out.println("nie ma polaczenia");
        }
    }

    @Override
    public HashSet<Conection> getAllConections() {
        HashSet<Conection> all_connections = new HashSet<>();
        Set<Vertex> keys = graph.keySet();
        for(Vertex k: keys){
            ArrayList<Conection> tmp = graph.get(k);
            for(Conection c: tmp){
                all_connections.add(c);
            }
        }
        return all_connections;
    }
}
