public class StackException extends Exception {
    String msg;
    public StackException(String in){
        msg = in;
    }
    public String toString(){
        return msg;
    }
}
