public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(new Vertex("Berlin"));
        g.addVertex(new Vertex("Hamburg"));
        g.addVertex(new Vertex("Bremen"));
        g.addVertex(new Vertex("Lol"));
        g.addVertex(new Vertex("Amsterdam"));
        g.addEdge(new String[]{"Amsterdam", "Berlin"}, 10);
        g.addEdge(new String[]{"Berlin", "Hamburg"}, 5);
        g.addEdge(new String[]{"Lol", "Bremen"}, 4);
        g.addEdge(new String[]{"Berlin", "Lol"}, 1);
        g.addEdge(new String[]{"Bremen", "Amsterdam"}, 4);
        g.printMatrix();
        g.breadthFirstSearch("Berlin");
    }
}
