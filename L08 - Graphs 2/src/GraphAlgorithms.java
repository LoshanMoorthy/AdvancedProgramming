import java.util.*;

public class GraphAlgorithms {

    /**
     * Returnerer en liste af grafens knuder fundet ved et dybdeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        List<V> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getSize()];
        dfsHelper(graph, v, visited, result);
        return result;
    }

    private static <V> void dfsHelper(Graph<V> graph, V v, boolean[] visited, List<V> result) {
        int index = graph.getIndex(v);
        if (!visited[index]) {
            visited[index] = true;
            result.add(v);

            for (V neighbor : graph.getNeighbors(v)) {
                if (!visited[graph.getIndex(neighbor)]) {
                    dfsHelper(graph, neighbor, visited, result);
                }
            }
        }
    }

    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        List<V> result = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.getSize()];

        queue.add(v);
        visited[graph.getIndex(v)] = true;

        while (!queue.isEmpty()) {
            V current = queue.poll();
            result.add(current);

            for (V neighbor : graph.getNeighbors(current)) {
                if (!visited[graph.getIndex(neighbor)]) {
                    visited[graph.getIndex(neighbor)] =  true;
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: Grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        if (graph.getSize() == 0) return true;

        List<V> vertices = graph.getVertices();
        List<V> visited = bfs(graph, vertices.get(0));

        return visited.size() == graph.getSize(); // If BFS visits all vertices, graph is connected.
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        List<V> visited = bfs(graph, v1);
        return visited.contains(v2); // If visit contains, it means there's a path.
    }

    public static <V> int[] shortestPathWeights(Graph<V> graph, V v) {
        // If graph has vertices
        if (graph.getSize() == 0) return new int[0];

        // Get total number of vertices
        int n = graph.getSize();

        // Array to keep the shortest path weights from v
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int vIndex = graph.getIndex(v);
        distances[vIndex] = 0;


        // PQ to select the next vertex with the shortest path
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{vIndex, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentIndex = current[0];

            // Skip if this vertex's shortest path is already finalized.
            if (visited[currentIndex]) continue;
            visited[currentIndex] = true; // Mark vertex as finalized.

            // Check each edge to update dist
            List<Edge> incidentEdges = graph.getIncidentEdges(graph.getVertex(currentIndex));
            for (Edge edge : incidentEdges) {
                // Get the opposite vertex of the edge
                int neighborIndex = edge.u == currentIndex ? edge.v : edge.u;
                if (!visited[neighborIndex]) {
                    int newDist = distances[currentIndex] + edge.e;
                    if (newDist < distances[neighborIndex]) {
                        distances[neighborIndex] = newDist;
                        pq.offer(new int[]{neighborIndex, newDist});
                    }
                }
            }
        }

        return distances;
    }

}