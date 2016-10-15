import edu.princeton.cs.algs4.StdOut;

public class BSTv1
{
    private Node root;
    
    private class Node
    {
        int value;
        Node left, right;
        
        public Node(int val)
        {
            value = val;
            Node left = null;    // Not necessary, init to null by default
            Node right = null;   // Not necessary either
        }
    }
    
    public void put(int val)
    {   // Wrapper method
        if (root == null) 
        {   // Tree is empty, val becomes root
            root = new Node(val);
            return;
        }
        else
        {   // Tree not empty, must insert in proper position
            put(root, val);
        }
    }
    
    private void put(Node x, int val)
    {   // Recursive helper method
        if (val < x.value) 
        {
            if (x.left == null)
            {   // Insert as left child
                x.left = new Node(val);
                return;
            }
            else
            {   // Less than x, go left
                put(x.left, val);
                return;
            }
        }
        else if (val > x.value) 
        {
            if (x.right == null)
            {   // Insert as right child
                x.right = new Node(val);
                return;
            }
            else
            {   // Greater than x, go right
                put(x.right, val);
                return;
            }
        }
        else
        {   // No duplicate values allowed
            return;
        }
    }
    
    public void print()
    {   // Wrapper method
        print(root);
    }
    
    private void print(Node x)
    {   // Recurisve helper method
        if (x == null) return;
        print(x.left);
        StdOut.print(x.value + " ");  // In order printing
        print(x.right);
    }
    
    public static void main(String[] args)
    {
        BST tree = new BST();
        tree.put(50);
        tree.put(50);  // Test duplicates
        tree.put(49);
        tree.put(49);
        tree.put(51);
        tree.put(48);
        tree.put(47);
        tree.put(52);
        tree.put(53);
        tree.print();
    }
}