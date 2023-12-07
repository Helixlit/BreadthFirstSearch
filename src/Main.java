public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(new Vertex("Berlin"));
        g.addVertex(new Vertex("Hamburg"));
        g.addVertex(new Vertex("Bremen"));
        g.addVertex(new Vertex("--Lol--"));
        g.addEdge(new String[]{"Berlin", "Hamburg"}, 5);
        g.addEdge(new String[]{"--Lol--", "Bremen"}, 4);
        System.out.println(g.getEdgeValue(new String[]{"Berlin", "Hamburg"}));
        g.printMatrix();
    }
}
