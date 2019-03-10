package leetcode;
import java.util.*;
/*
429. N-ary Tree Level Order Traversal
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

//注意 List<List<Integer>> result = new ArrayList<>(); result.add(new ArrayList<Integer>());
//范型错误： List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();

public class LeverTravers {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        leverTravers(root, 0);
        return result;
    }
    private void leverTravers(Node root, int layer){
        if(root == null) return;
        if(result.size() == layer) {
            List<Integer> l = new ArrayList<Integer>(); //错误： new ArrayList<Integer>(root.val)
            l.add(root.val);
            result.add(l);
        }
        else result.get(layer).add(root.val);

        for(Node node : root.children)
            leverTravers(node, layer+1);
    }
}
