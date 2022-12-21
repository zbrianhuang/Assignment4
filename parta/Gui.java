import javax.swing.*;
import java.awt.BorderLayout;
public class Gui{
    JFrame frame;
    JTextField textField;
    JButton button;
    public Gui() throws StackException{
        frame = new JFrame("Expression Evaluator");
        frame.setSize(700,400);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        textField = new JTextField();
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);
        
        button = new JButton("Check");
        button.addActionListener(e -> { 
        try{
        buttonAction();
        }catch(StackException r){
            
        }
    });
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    void buttonAction() throws StackException{

        int check = balanced();
        if(check==0){
            JOptionPane j= new JOptionPane();
            j.showMessageDialog(null, "The expression is balanced");
        }else{
            JOptionPane j= new JOptionPane();
            j.showMessageDialog(null, "The expression is not balanced at index "+check);
        }
    }
    public String getText(){
        return textField.getText();
    }
    public int balanced() throws StackException{
        
        Stack exStack = new Stack(100);
        Stack bStack = new Stack(100);
        Stack aStack = new Stack(100);
        String ex= getText();
        int equalsIndex = ex.indexOf("=");
        if(equalsIndex==-1){
            JOptionPane j= new JOptionPane();
            j.showMessageDialog(null, "Error. Need an equal sign");
            throw new StackException("Error. Need an equal sign");
        }
        char temp;
        for(int i= 0;i<equalsIndex;i++){
            char a = ex.charAt(i);
            switch (a){
                case '{':
                    exStack.push("{");
                break;
                case '[':
                    bStack.push("[");
                break;
                case '<':
                    aStack.push("<");
                break;
                default:
                    JOptionPane j= new JOptionPane();
                    j.showMessageDialog(null, "Error. Can only accept (,{,<,>,},) as inputs.");
                    throw new StackException("Error. Can only accept (,{,< as inputs.");
               
            }
            
        }
        
        
        for(int i= equalsIndex+1;i<ex.length();i++){
            char a = ex.charAt(i);
            switch (a){
                case '{':
                if(!(exStack.peek()=="empty")&&!exStack.isEmpty()){
                    exStack.pop();
                }else{
                    return i+equalsIndex+1;
                }
                
                break;
                case '[':
                if(!(bStack.peek()=="empty")&&!bStack.isEmpty()){
                    bStack.pop();
                }else{
                    return i+equalsIndex+1;
                }
                
                break;
                case '<':
                    if(!(aStack.peek()=="empty")&&!aStack.isEmpty()){

                        aStack.pop();
                    }else{
                        return i+equalsIndex+1;
                    }
                    
                break;
                default:
                    
                    JOptionPane j= new JOptionPane();
                    j.showMessageDialog(null, "Error. Can only accept (,{,<,>,},) as inputs.");
                    
                break;
               
            }
            
        }
        
       // System.out.println(exStack.getSize()+" "+bStack.getSize()+" "+aStack.getSize());
        if(exStack.getSize()==0&&bStack.getSize()==0&&aStack.getSize()==0){
            return 0;
        }
        
        return 4;
        
    }
}