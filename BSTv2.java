import edu.princeton.cs.algs4.StdOut;

public class BSTv2
{
    private Node root;
    
    private class Node
    {
        // TODO: Add size
        int key;
        String value;
        Node left, right;
        
        public Node(int k, String v)
        { key = k; value = v; }
    }
    
    public void put(int k, String v)
    { root = put(root, k, v); }
    
    private Node put(Node x, int k, String v)
    {
        if (x == null)      return new Node(k, v);
        if (k < x.key)      x.left = put(x.left, k, v);
        else if (k > x.key) x.right = put(x.right, k, v);
        else                x.value = v;
        return x;
    }
    
    // TODO: get
    // TODO: delete
    
    public void print()
    { print(root); }
    
    private void print(Node x)
    {
        if (x == null) return;
        print(x.left);
        StdOut.print(x.value + " ");
        print(x.right);
    }
    
    public static void main(String[] args)
    {
        BSTv2 tree = new BSTv2();
        tree.put(50, "hello");
        tree.put(50, "hi");
        tree.put(49, "world");
        tree.put(49, "world!");
        tree.put(51, "no");
        tree.put(48, "yes");
        tree.put(47, "yup");
        tree.put(52, "maybe");
        tree.put(53, "always");
        tree.print();
    }
}      