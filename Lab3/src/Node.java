
public class Node<T> {
	private Node<T> pointer;
	private T data;
	
	public Node(){
		pointer = null;
		data = null;
	}
	
	public Node(T o){
		pointer = null;
		data = o;
	}
	
	public Node<T> next(){
		return pointer;
	}
	
	public Node<T> setNext(Node<T> node){
		pointer = node;
		return pointer;
	}
	
	public T getData(){
		return data;
	}
	
	public void setData(T o){
		data = o;
	}
	
	public boolean hasNext() {
		if(pointer != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
