import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final List<Edge> edges;
    private final List<Vertex> vertices;

    private int[][] matrix;

    public Graph() {
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    private void generateMatrix() {
        int matrixSize = vertices.size();
        this.matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (i == j) ? 0 : -1;
            }
        }
        for (Edge e:
             edges) {
            int[] verticesIndex = e.getVerticesIndex();
            matrix[verticesIndex[0]][verticesIndex[1]] = e.getValue();
            matrix[verticesIndex[1]][verticesIndex[0]] = e.getValue();
        }
    }

    public void printMatrix() {
        generateMatrix();

        System.out.print("\t\t");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(vertices.get(i).getValue() + "\t");
        }
        System.out.println("");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(vertices.get(i).getValue()+"\t");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"\t\t");
            }
            System.out.println("");
        }
    }

    public void breadthFirstSearch(String root) {
        generateMatrix();
        List<Integer> queue = new ArrayList<>();

        vertices.get(getVertexIndex(root)).explored = true;
        queue.add(getVertexIndex(root));
        System.out.print("Queue: "+root+", ");
        int distance = 1;
        while (queue.size() > 0) {
            int selectedVert = queue.get(0);
            for (int j = 0; j < vertices.size(); j++) {
                if (matrix[selectedVert][j] > 0 && !(vertices.get(j).explored)) {
                    vertices.get(j).explored = true;
                    queue.add(j);
                    System.out.print(vertices.get(j).getValue()+", ");
                }

            }
            queue.remove(0);

        }
    }

    public void addVertex(Vertex vertex) { vertices.add(vertex);}

    public void addEdge(Edge edge) {edges.add(edge);}

    public void addEdge(String[] verticesVal, int value) {
        addEdge(new Edge(new int[]{getVertexIndex(verticesVal[0]), getVertexIndex(verticesVal[1])}, value));
    }

    public void removeVertex(String vertexValue) {
        int vertexIndex = getVertexIndex(vertexValue);
        vertices.remove(vertexIndex);
    }

    public void removeEdge(String[] verticesVal) {
        int edgeIndex = getEdgeIndex(verticesVal);
        edges.remove(edgeIndex);
    }


    public void setVertexValue(String vertexValue) {
        int vertIndex = getVertexIndex(vertexValue);
        vertices.get(vertIndex).setValue(vertexValue);
    }

    public int getEdgeValue(String[] verticesVal) {
        int edgeIndex = getEdgeIndex(verticesVal);
        return edges.get(edgeIndex).getValue();
    }

    public void setEdgeValue(String[] verticesVal, int value) {
        int edgeIndex = getEdgeIndex(verticesVal);
        edges.get(edgeIndex).setValue(value);
    }

    private int getVertexIndex(String vertexValue) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertexValue.equals(vertices.get(i).getValue())) return i;
        }
        return -1;
    }

    private int getEdgeIndex(String[] verticesVal) {
        int[] vertIndex = new int[]{getVertexIndex(verticesVal[0]), getVertexIndex(verticesVal[1])};
        for (int i = 0; i < edges.size(); i++) {
            //Checks if both vertices match
            if ((edges.get(i).getVerticesIndex()[0] == vertIndex[0] || edges.get(i).getVerticesIndex()[0] == vertIndex[1])
            && (edges.get(i).getVerticesIndex()[1] == vertIndex[0] || edges.get(i).getVerticesIndex()[1] == vertIndex[1])) {
                return i;
            }
        }
        return -1;
    }
}
