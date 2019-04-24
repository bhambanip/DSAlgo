import java.util.LinkedList;

/**
 * Graph
 */
public class Graph {

  private int V;
  private LinkedList<Integer> adj[];

  public Graph(int v) {
    this.V = v;
    this.adj = new LinkedList[v];
    for (int i = 0; i < v; i++)
      this.adj[i] = new LinkedList<>();
  }

}