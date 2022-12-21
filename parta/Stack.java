class Stack {
 

    String[]A;
 
    
    int top = -1;
 

    int size;
 

    public Stack(int size)
    {

        this.size = size;
        A = new String[size];
    }
 

    void push(String X) throws StackException
    {

        if (top + 1 == size) {
 

            throw new StackException("Stack is full");
 
        }
        else {

            top = top + 1;

            A[top+1]=X;
        }
    }

    String peek() throws StackException
    {
    
        
        if (top == -1) {
 

            return "Empty";
        }

        else
            return A[top];
    }
    public int getSize(){
        return top+1;
    }
    public boolean isEmpty()
    {
        if(top>=0){
            return false;
        }
        return true;
    }
    String pop() throws StackException
    {
        String deletedItem = A[top];

        if (top == -1) {
 

            throw new StackException("Cannot Pop. Stack is Empty.");
        }
 
        else

            top--;
        
        return deletedItem;
    }
 

    boolean empty() { return top == -1; }
 

    public String toString()
    {
 
        String Ans = "";
 
        for (int i = 0; i < top; i++) {
            Ans += String.valueOf(A[i]) + "->";
        }
 
        Ans += String.valueOf(A[top]);
 
        return Ans;
    }
}