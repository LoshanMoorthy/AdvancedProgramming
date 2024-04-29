import java.util.ArrayList;
import java.util.List;

public class AdjacentEdgeListGraph<V> implements Graph<V> {
    protected List<List<Edge>> adjList = new ArrayList<>();

    public AdjacentEdgeListGraph() { }


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getNumEdges() {
        return 0;
    }

    @Override
    public List<V> getVertices() {
        return null;
    }

    @Override
    public List<Edge> getEdges() {
        return null;
    }

    @Override
    public V getVertex(int index) {
        return null;
    }

    @Override
    public V getMaxVertex() {
        return null;
    }

    @Override
    public int getIndex(V v) {
        return 0;
    }

    @Override
    public List<V> getNeighbors(V v) {
        return null;
    }

    @Override
    public List<Integer> getNeighborsIndex(V v) {
        return null;
    }

    @Override
    public List<Edge> getIncidentEdges(V v) {
        return null;
    }

    @Override
    public int getDegree(V v) {
        return 0;
    }

    @Override
    public void printEdges() {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean addVertex(V vertex) {
        return false;
    }

    @Override
    public boolean addEdge(int u, int v, int e) {
        return false;
    }

    @Override
    public boolean addEdge(int u, int v) {
        return false;
    }

    @Override
    public boolean remove(V v) {
        return false;
    }

    @Override
    public boolean remove(int u, int v) {
        return false;
    }
}
