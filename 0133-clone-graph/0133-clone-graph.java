/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        // Base case: if the graph is empty
        if (node == null) {
            return null;
        }
        
        // Map to keep track of original nodes and their corresponding cloned copies
        Map<Node, Node> map = new HashMap<>();
        
        // Queue for BFS traversal
        Queue<Node> queue = new LinkedList<>();
        
        // Clone the root node and put it in the map
        map.put(node, new Node(node.val));
        // Enqueue the original root node
        queue.add(node);
        
        // Standard BFS loop
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            // Iterate through all neighbors of the current node
            for (Node neighbor : curr.neighbors) {
                // If the neighbor has not been cloned yet
                if (!map.containsKey(neighbor)) {
                    // Clone the neighbor and store it in the map
                    map.put(neighbor, new Node(neighbor.val));
                    // Push the original neighbor to the queue to process its connections later
                    queue.add(neighbor);
                }
                
                // Add the cloned neighbor to the cloned current node's neighbor list
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        
        // Return the cloned root node
        return map.get(node);
    }
}
