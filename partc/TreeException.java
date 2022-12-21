public class TreeException extends Exception {
    public String msg;
    public TreeException(String m){
        msg = m;
    }
    public String toString(){
        return msg;
    }
}
