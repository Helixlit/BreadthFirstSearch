public class Edge {
    private int value;
    private int[] verticesIndex;

    public Edge(int[] verticesIndex, int value) {
        this.value = value;
        this.verticesIndex = verticesIndex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getVerticesIndex() {
        return verticesIndex;
    }

    public void setVerticesIndex(int[] verticesIndex) {
        this.verticesIndex = verticesIndex;
    }
}
