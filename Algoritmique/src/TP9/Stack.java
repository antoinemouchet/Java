package TP9;

/**
 *
 * @author Xavier Devroey - xavier.devroey@unamur.be
 */
public interface Stack<T> {
    
    public Stack push(T value);
    
    public Stack pop();
    
    public boolean empty();
    
    public T top();
    
    public int size();

}
