import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacentEdgeListGraph<V> implements Graph<V> {
    protected List<V> vertices = new ArrayList<>();
    protected List<List<Edge>> adjList = new ArrayList<>();
    protected Map<V, Integer> vertexToIndex = new HashMap<>();

    public AdjacentEdgeListGraph() { }


    @Override
    public int getSize() {
        return vertices.size();
    }

    @Override
    public int getNumEdges() {
        // Counts all edges in the graph
        int numEdges = 0;
        for (List<Edge> edges : adjList) {
            numEdges += edges.size();
        }
        return numEdges / 2;
    }

    @Override
    public List<V> getVertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    public List<Edge> getEdges() {
        // Returns all edges in a list with duplicates
        List<Edge> allEdges = new ArrayList<>();
        for (List<Edge> edges : adjList) {
            for (Edge edge : edges) {
                if (!allEdges.contains(edge)) {
                    allEdges.add(edge);
                }
            }
        }
        return allEdges;
    }

    @Override
    public V getVertex(int index) {
        return vertices.get(index);
    }

    @Override
    public V getMaxVertex() {
        if (vertices.isEmpty())
            return null;

        V maxV = vertices.get(0);
        int maxDegree = adjList.get(0).size();
        for (int i = 1; i < vertices.size(); i++) {
            int currentDegree = adjList.get(i).size();
            if (currentDegree > maxDegree) {
                maxDegree = currentDegree;
                maxV = vertices.get(i);
            }
        }
        return maxV;
    }

    @Override
    public int getIndex(V v) {
        // Returns index or -1 if not found
        return vertexToIndex.getOrDefault(v, -1);
    }

    @Override
    public List<V> getNeighbors(V v) {
        // Returns all vertices adjacent to a given vertex
        List<V> neighbors = new ArrayList<>();
        int index = getIndex(v);
        if (index != -1)
            for (Edge edge : adjList.get(index))
                neighbors.add(vertices.get(edge.v));

        return neighbors;
    }

    @Override
    public List<Integer> getNeighborsIndex(V v) {
        List<Integer> neighborIndices = new ArrayList<>();
        int index = getIndex(v);
        if (index != -1)
            for (Edge edge : adjList.get(index))
                neighborIndices.add(edge.v);

        return neighborIndices;
    }

    @Override
    public List<Edge> getIncidentEdges(V v) {
        // Returns all edges that connect to a specific vertex
        int index = getIndex(v);
        return index != -1 ? new ArrayList<>(adjList.get(index)) : new ArrayList<>();
    }

    @Override
    public int getDegree(V v) {
        int index = getIndex(v);
        return index != -1 ? adjList.get(index).size() : 0;
    }

    @Override
    public void printEdges() {
        for (V vertex : vertices) {
            int index = getIndex(vertex);
            List<Edge> edges = adjList.get(index);
            for (Edge edge : edges) {
                System.out.println(vertices.get(edge.u) + " -> " + vertices.get(edge.v) + ": " + edge.e);
            }
        }
    }

    @Override
    public void clear() {
        vertices.clear();
        adjList.clear();
        vertexToIndex.clear();;
    }

    @Override
    public boolean addVertex(V vertex) {
        // Adds new v if it doesn't exist in graph
        if (!vertexToIndex.containsKey(vertex)) {
            vertices.add(vertex);
            adjList.add(new ArrayList<>());
            vertexToIndex.put(vertex, vertices.size() - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(int u, int v, int e) {
        // Adds an edge between to vertices specified by index with an edge weight
        if (u >= 0 && u < getSize() && v >= 0 && v < getSize()) {
            Edge edge = new Edge(u, v, e);
            Edge reverseEdge = new Edge(v, u, e);
            adjList.get(u).add(edge);
            adjList.get(v).add(reverseEdge);
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(int u, int v) {
        return false;
    }

    @Override
    public boolean remove(V v) {
        int index = getIndex(v);
        if (index != -1) {
            for (Edge edge : new ArrayList<>(adjList.get(index))) {
                V dest = vertices.get(edge.v);
                adjList.get(getIndex(dest)).removeIf(e -> e.v == index);
            }
            adjList.remove(index);
            vertices.remove(v);
            vertexToIndex.remove(v);
            for (int i = index; i < vertices.size(); i++) {
                vertexToIndex.put(vertices.get(i), i);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int u, int v) {
        // Removes an edge between two vertices
        if (u < getSize() && v < getSize()) {
            boolean removed = false;
            // Remove edge from u to v
            removed |= adjList.get(u).removeIf(edge -> edge.v == v);
            // Remove edge from v to u
            removed |= adjList.get(v).removeIf(edge -> edge.u == u);
            return removed;
        }
        return false;
    }
}
