
class Node {
 
    int data;
    Node left, right;
 
    Node(int val)
    {
        data = val;
        left = right = null;
    }
}


public class PairSumBinarySearchTree {
	
	Node root;
	
	PairSumBinarySearchTree() 
	{ 
		root = null; 
	}
	
    void insert(int key) 
    { 
    	root = insertRecord(root, key);
    }


    Node insertRecord(Node root, int data)
    {
 
        
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        
        if (data < root.data)
            root.left = insertRecord(root.left, data);
        else if (data > root.data)
            root.right = insertRecord(root.right, data);
 
        return root;
    }
    
    boolean isPairPresent(Node root, Node temp, int target)
    {
        if (temp == null)
            return false;
 
        return search(root, temp, target - temp.data)
            || isPairPresent(root, temp.left, target)
            || isPairPresent(root, temp.right, target);
    }
    
    boolean search(Node root, Node temp, int k)
    {
 
        if (root == null)
            return false;
 
        Node currRoot = root;
        boolean flag = false;
        while (currRoot != null && flag != true) {
            if (currRoot.data == k && temp != currRoot) {
                flag = true;
                System.out.println("Pair Found: " + currRoot.data
                                   + " + " + temp.data);
                return true;
            }
            else if (k < currRoot.data)
            	currRoot = currRoot.left;
            else
            	currRoot = currRoot.right;
        }
 
        return false;
    }
    
    public static void main(String[] args)
    {
        PairSumBinarySearchTree BStree = new PairSumBinarySearchTree();
       
        BStree.insert(40);
        BStree.insert(20);
        BStree.insert(60);
        BStree.insert(10);
        BStree.insert(30);
        BStree.insert(50);
        BStree.insert(70);
 
        boolean isPair
            = BStree.isPairPresent(BStree.root, BStree.root, 130);
        if (!isPair)
            System.out.println("No such values are found!");
    }
    

}
