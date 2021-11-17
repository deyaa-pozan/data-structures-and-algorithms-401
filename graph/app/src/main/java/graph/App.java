/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws NodeNotFoundException {
//        Graph<String> graph1 = new Graph<>();
//        graph1.addNode("A");
//        graph1.addNode("B");
//        graph1.addNode("C");
//        graph1.addNode("D");
//        graph1.addNode("E");
//        graph1.addNode("F");
//        graph1.addNode("G");
//        graph1.addNode("H");
//
//        try {
//            graph1.addEdge("A","B",0);
//            graph1.addEdge("A","D",0);
//            graph1.addEdge("B","C",0);
//            graph1.addEdge("B","D",0);
//
//            graph1.addEdge("C","G",0);
//            graph1.addEdge("D","E",0);
//            graph1.addEdge("D","H",0);
//
//            graph1.addEdge("D","F",0);
//            graph1.addEdge("F","H",0);
//
//            List<String> bft = graph1.BFT("A");
//            System.out.println(bft);
//        }
//        catch(NodeNotFoundException ex){
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(graph1);
//        System.out.println(graph1.getSize());
//        System.out.println(graph1.getNodes());

        Graph graph2 = new Graph();

        graph2.addNode("Pandora");
        graph2.addNode("Arendelle");
        graph2.addNode("Metroville");
        graph2.addNode("Monstropolis");
        graph2.addNode("Narnia");
        graph2.addNode("Naboo");

        graph2.addEdge("Pandora", "Arendelle", 150);
        graph2.addEdge("Pandora", "Metroville", 82);
        graph2.addEdge("Arendelle", "Metroville",99);
        graph2.addEdge("Arendelle", "Monstropolis",42);
        graph2.addEdge("Metroville", "Narnia",37);
        graph2.addEdge("Metroville", "Naboo",26);
        graph2.addEdge("Metroville", "Monstropolis",105);
        graph2.addEdge("Monstropolis", "Naboo",73);
        graph2.addEdge("Narnia", "Naboo",250);

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Pandora");
        cities.add("Arendelle");
        cities.add("Metroville");

        List<String> cities1 = new ArrayList<>();
        cities1.add("Pandora");
        cities1.add("Naboo");
        cities1.add("Metroville");


        System.out.println("First Trip ---> " + graph2.businessTrip(graph2, cities));
        System.out.println("Second Trip ---> " + graph2.businessTrip(graph2, cities1));
    }
}
