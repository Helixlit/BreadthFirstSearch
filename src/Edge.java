public class Edge {
    private int value;
    private int[] verticesIndex;

    public Edge(int[] verticesIndex, int value) {
        this.verticesIndex = verticesIndex;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
