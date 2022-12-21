import java.util.Scanner;
public class Menu{
    private Scanner in;
    private BST bst;
    public Menu() throws TreeException{
        bst= new BST();
        in = new Scanner(System.in);
        String ans="";
        while(true){
            printMenu();
            ans = in.nextLine();
            
            if(ans.equals("1")){
                System.out.println("Enter the number to insert");
                ans = in.nextLine();
                if(bst.search(Integer.valueOf(ans))){
                    throw new TreeException("Cannot Add. Number already exists in the tree");
                }
                bst.insert(Integer.valueOf(ans));
                
            }
            else if(ans.equals("2")){
                System.out.println("Enter the number to delete");
                ans = in.nextLine();
                if(bst.height()==0){
                    throw new TreeException("Cannot Delete. Tree is Empty");
                }
                if(!bst.search(Integer.valueOf(ans))){
                    throw new TreeException("Cannot Delete. Number is not in tree.");
                }
                bst.delete(Integer.valueOf(ans));
            }
            else if(ans.equals("3")){
                bst.printBreadth();
            }
            else if(ans.equals("4")){
                bst.printPostorder();
            }
            else if(ans.equals("5")){
                bst.printInorder();
            }
            else if(ans.equals("6")){
                bst.printPreorder();
            }
            else if(ans.equals("7")){
                break;
            }
        }
    }
    public void printMenu(){
        System.out.println();
        System.out.println("1.Add an item");
        System.out.println("2.Delete an item");
        System.out.println("3.Print the tree breadth-frist");
        System.out.println("4.Print the tree in post-order");
        System.out.println("5.Print the tree in-order");
        System.out.println("6.Print the tree in pre-order");
        System.out.println("7.Exit");
    }
}