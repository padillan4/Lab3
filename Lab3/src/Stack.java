
public class Stack<T> {
	MyLinkedList<T> list = new MyLinkedList<>();
	
	public void push(T o){
		list.add(0, o);
	}
	
	public T pop(){
		return list.remove(0);
	}
	
	public T peak(){
		return list.get(0);
	}
	
	public boolean isempty(){
		return list.isEmpty();
	}
	
	public int size(){
		return list.size();
	}
	
}
