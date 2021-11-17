/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    @DisplayName("Node can be successfully added to the graph")
    void test1()   {
        Graph<String> graph = new Graph<>();

        graph.addNode("Fellow 1");
        graph.addNode("Fellow 2");
        assertEquals(2, graph.getSize());
    }
    @Test
    @DisplayName("An edge can be successfully added to the graph")
    void test2() throws NodeNotFoundException {
        Graph<String> graph = new Graph<>();
        graph.addNode("Fellow 1");
        graph.addNode("Fellow 2");
        graph.addNode("Fellow 3");
        graph.addEdge("Fellow 1", "Fellow 2",10);
        assertEquals("[ ( Fellow 2 , 10 ) ]", graph.getNeighbors("Fellow 1").toString());
    }
    @Test
    @DisplayName("A collection of all nodes can be properly retrieved from the graph")
    void test3() throws NodeNotFoundException {
        Graph<String> graph = new Graph<>();
        graph.addNode("Fellow 1");
        graph.addNode("Fellow 2");
        graph.addNode("Fellow 3");
        graph.addEdge("Fellow 1", "Fellow 2",10);
        assertEquals("[ value: Fellow 1 ,  Neighbors: [ ( Fellow 2 , 10 ) ] ,  value: Fellow 2 ,  Neighbors: [ ( Fellow 1 , 10 ) ] ,  value: Fellow 3 ,  Neighbors: [] ]", graph.getNodes().toString());
    }
    @Test
    @DisplayName("All appropriate neighbors can be retrieved from the graph")
    void test4() throws NodeNotFoundException {
        Graph<String> graph = new Graph<>();
        graph.addNode("Fellow 1");
        graph.addNode("Fellow 2");
        graph.addNode("Fellow 3");
        graph.addEdge("Fellow 1", "Fellow 2",10);
        graph.addEdge("Fellow 1", "Fellow 3",10);
        assertEquals("[ ( Fellow 2 , 10 ) ,  ( Fellow 3 , 10 ) ]", graph.getNeighbors("Fellow 1").toString());
    }
    @Test
    @DisplayName("Neighbors are returned with the weight between nodes included")
    void test5() throws NodeNotFoundException {
        Graph<String> graph = new Graph<>();
        graph.addNode("Fellow 1");
        graph.addNode("Fellow 2");
        graph.addNode("Fellow 3");
        graph.addEdge("Fellow 1", "Fellow 2",10);
        assertEquals("[ ( Fellow 2 , 10 ) ]", graph.getNeighbors("Fellow 1").toString());
    }
    @Test
    @DisplayName("The proper size is returned, representing the number of nodes in the graph")
    void test6()   {
        Graph<String> graph = new Graph<>();
        graph.addNode("Fellow 1");
        graph.addNode("Fellow 2");
        assertEquals(2, graph.getSize());
    }
    @Test
    @DisplayName("A graph with only one node and edge can be properly returned")
    void test7() throws NodeNotFoundException {
        Graph<String> graph = new Graph<>();
        graph.addNode("Fellow 1");
        graph.addEdge("Fellow 1", "Fellow 1",10);
        assertEquals("Node: --{  value: Fellow 1 ,  Neighbors: [ ( Fellow 1 , 10 ) ,  ( Fellow 1 , 10 ) ]  }-- \n", graph.toString());
    }

    @Test
    @DisplayName("Test BFT in normal case")
    public void test8() {
        try {
            Graph <String> graph1 = new Graph();

            graph1.addNode("Pandora");
            graph1.addNode("Arendelle");
            graph1.addNode("Metroville");
            graph1.addNode("Monstroplolis");
            graph1.addNode("Narnia");
            graph1.addNode("Naboo");

            graph1.addEdge("Pandora","Arendelle",0);
            graph1.addEdge("Arendelle","Metroville",0);
            graph1.addEdge("Arendelle","Monstroplolis",0);

            graph1.addEdge("Metroville","Narnia",0);
            graph1.addEdge("Metroville","Naboo",0);
            graph1.addEdge("Metroville","Monstroplolis",0);

            graph1.addEdge("Monstroplolis","Naboo",0);
            graph1.addEdge("Narnia","Naboo",0);
            ArrayList<String> bft = graph1.BFT("Pandora");
            String expected = "[Pandora, Arendelle, Metroville, Monstroplolis, Narnia, Naboo]";
            assertEquals(expected, bft.toString());
        }
        catch(NodeNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    @DisplayName("Test BFT on empty graph")
    public void test9() {
        Graph <String> graph1 = new Graph();

        try {
            ArrayList<String> bft = graph1.BFT("Pandora");
        }
        catch(NodeNotFoundException ex){
            assertEquals("Node not found..( Pandora )!",ex.getMessage());
        }
    }

    @Test
    @DisplayName("Test BFT on Graph has no edges")
    public void test10() {
        Graph <String> graph1 = new Graph();

        graph1.addNode("Pandora");
        graph1.addNode("Arendelle");
        graph1.addNode("Metroville");
        graph1.addNode("Monstroplolis");
        graph1.addNode("Narnia");
        graph1.addNode("Naboo");

        try {
            ArrayList<String> bft = graph1.BFT("Pandora");
            String expected = "[Pandora]";
            assertEquals(expected, bft.toString());
        }
        catch(NodeNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    @DisplayName("Test BFT on connected partO of the graph")
    public void test11() {
        Graph <String> graph1 = new Graph();

        graph1.addNode("Pandora");
        graph1.addNode("Arendelle");
        graph1.addNode("Metroville");
        graph1.addNode("Monstroplolis");
        graph1.addNode("Narnia");
        graph1.addNode("Naboo");

        try {
            graph1.addEdge("Pandora","Arendelle",0);
            graph1.addEdge("Arendelle","Metroville",0);
            graph1.addEdge("Arendelle","Monstroplolis",0);

            ArrayList<String> bft = graph1.BFT("Pandora");
            String expected = "[Pandora, Arendelle, Metroville, Monstroplolis]";
            assertEquals(expected, bft.toString());
        }
        catch(NodeNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testDifferentPaths() throws NodeNotFoundException {

        Graph graph = new Graph();
        ArrayList<String> path = new ArrayList<>();

        graph.addNode("Pandora");
        graph.addNode("Arendelle");
        graph.addNode("Metroville");
        graph.addNode("Monstroplolis");
        graph.addNode("Narnia");
        graph.addNode("Naboo");

        graph.addEdge("Pandora", "Arendelle", 150);
        graph.addEdge("Pandora", "Metroville", 82);


        graph.addEdge("Arendelle", "Metroville", 99);
        graph.addEdge("Arendelle", "Monstroplolis", 42);

        graph.addEdge("Metroville", "Monstroplolis", 105);
        graph.addEdge("Metroville", "Narnia", 37);
        graph.addEdge("Metroville", "Naboo", 26);

        graph.addEdge("Monstroplolis", "Naboo", 73);
        graph.addEdge("Narnia", "Naboo", 250);

        path.add("Metroville");
        path.add("Pandora");

        assertEquals("True, $82", graph.businessTrip(graph, path));

        ArrayList<String> path1 = new ArrayList<>();
        path1.add("Arendelle");
        path1.add("Monstroplolis");
        path1.add("Naboo");

        assertEquals("True, $115", graph.businessTrip(graph, path1));

        ArrayList<String> path2 = new ArrayList<>();
        path2.add("Naboo");
        path2.add("Pandora");

        assertEquals("False, $0", graph.businessTrip(graph, path2));

        ArrayList<String> path3 = new ArrayList<>();
        path3.add("Narnia");
        path3.add("Arendelle");
        path3.add("Naboo");

        assertEquals("False, $0", graph.businessTrip(graph, path3));
    }

}
