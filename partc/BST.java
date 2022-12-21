

public class BST {
    Node root;

    public BST(){
        root = null;
    }
    public void insert(int num) throws TreeException{
        root = insertItem(root,num);
    }
    public void printBreadth(){
        int h = height(root);
        if(h==0){
            System.out.println("Tree is empty");
        }else{
            for (int i = 1; i <= h; i++){
                printCurrentLevel(root, i);
            }
        }
    }
    public void printInorder(){
        
        printInorder(root);
    }
    void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.firstChild);
 
        System.out.print(node.data + " ");
 
        printInorder(node.lastChild);
    }
    public void printPreorder(){
        printPreorder(root);
    }
    void printPreorder(Node node)
    {
        if (node == null)
            return;
 

        System.out.print(node.data + " ");

        printPreorder(node.firstChild);
 
        printPreorder(node.lastChild);
    }
    public void printPostorder(){
        printPostorder(root);
    }
    void delete(int n) { root = delete(root, n); }
 

    Node delete(Node root, int data)
    {

        if (root == null)
            return root;

        if (data < root.data)
            root.firstChild = delete(root.firstChild, data);
        else if (data> root.data)
            root.lastChild = delete(root.lastChild, data);
 
        else {
       
            if (root.firstChild == null)
                return root.lastChild;
            else if (root.lastChild== null)
                return root.firstChild;

            root.data= minValue(root.lastChild);
 

            root.lastChild = delete(root.lastChild, root.data);
        }
 
        return root;
    }
    int minValue(Node root)
    {
        int minv = root.data;
        while (root.firstChild != null) {
            minv = root.firstChild.data;
            root = root.firstChild;
        }
        return minv;
    }
 
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        printPostorder(node.firstChild);
 

        printPostorder(node.lastChild);
 
        System.out.print(node.data + " ");
    }
    public int height(){
        return height(root);
    }
    int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.firstChild);
            int rheight = height(root.lastChild);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.firstChild, level - 1);
            printCurrentLevel(root.lastChild, level - 1);
        }
    }
    public boolean search(int data){
        return search(root,data);
    }
    boolean search(Node root,int data){
        if(root==null){
            return false;
        }else if(root.data ==data){
            return true;
        }else if(root.data>data){
            return search(root.firstChild,data);

        }else{
            return search(root.lastChild,data);
        }
    }
    private Node insertItem(Node root, int d) throws TreeException
    {
        if (root == null) {
            root = new Node(d);
            return root;
        }
 

        else if (d < root.data)
            root.firstChild= insertItem(root.firstChild, d);
        else if (d > root.data)
            root.lastChild = insertItem(root.lastChild, d);
        else
            throw new TreeException("Cannot add. Duplicate values are not allowed"); 

        return root;
    }
}
