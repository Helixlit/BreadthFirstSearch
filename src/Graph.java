import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Edge> edges;
    private List<Vertex> vertices;

    private int[][] matrix;

    public Graph() {
        this.edges = new ArrayList();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void removeVertex(String vertexVal) {
        int vertexIndex = this.getVertexIndex(vertexVal);
        vertices.remove(vertices.get(vertexIndex));
    }

    public void removeEdge(Vertex[] vertices) {

    }

    public void getVertexValue() {}

    //TODO
    public void setVertexValue() {}

    //TODO
    public void getEdgeValue() {}

    //TODO
    public void setEdgeValue() {}

    private int getEdgeIndex(int[] verticesIndex) {

    }


    public int getVertexIndex(String vertexVal) {
        for (int i = 0; i < vertices.size()-1; i++) {
            if (vertices.get(i).getValue() == vertexVal) return i;
        }
        return -1;
    }


}
