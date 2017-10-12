/**
 * 
 */

/**
 * @author padillan4
 *
 */
public class MyLinkedList<T> {
	
	int size = 0;
	Node<T> head = new Node<T>();

	public boolean add(int index, T o) throws IndexOutOfBoundsException{
		Node<T> currentHead = head;
		Node<T> addNode = new Node<T>(o);
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		if(index == 0) {
			head = addNode;
			head.setNext(currentHead);
			size++;
			return true;
		}
		else if(index >= 0 && index < size()) {
			for(int i = 0; i < index-1; i++) {
				if(currentHead.hasNext()) {
					currentHead = currentHead.next();
				}
			}
			addNode.setNext(currentHead.next());
			currentHead.setNext(addNode);
			size++;
			return true;
		}
		throw e;
	}
	
	public boolean add (T o){
		if(size() == 0) {
			head.setData(o);
			size++;
			return true;
		}
		else {
			Node<T> currentHead = head;
			Node<T> addNode = new Node<T>(o);
			for(int i = 0; i < size(); i++) {
				if(currentHead.hasNext()) {
					currentHead = currentHead.next();
				}
			}
			currentHead.setNext(addNode);
			size++;
			return true;
		}
		
	}
	
	public boolean clear(){
		head = new Node<T>();
		size = 0;
		if(head.getData() == null & !(head.hasNext())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean contains(T o){
		return indexOf(o) != -1;
	}
	
	public T get(int index) throws IndexOutOfBoundsException{
		Node<T> currentHead = head;
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		if(index < size()){
			if(index == 0) {
				return head.getData();
			}
			for(int i = 0; i < index; i++){
				if(currentHead.hasNext()){
					currentHead = currentHead.next();
				}
			}
			return currentHead.getData();
		}
		else{
			throw e;
		}
	}
	
	public int indexOf(T o){
		Node<T> currentHead = head;
		for(int i = 0; i < size(); i++){
			if(currentHead.getData() != null){
				if(currentHead.getData().equals(o)){
					return i;
				}
				else if(currentHead.hasNext()){
					currentHead = currentHead.next();
				}
			}
			else if(currentHead.hasNext()){
				currentHead = currentHead.next();
			}
		}
		return -1;
	}
	
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public T remove(int index) throws IndexOutOfBoundsException{
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		Node<T> currentHead = head;
		if(index == 0) {
			head = head.next();
			currentHead.setNext(null);
			size--;
			return currentHead.getData();
		}
		else if(index < size() & index > 0) {
			for(int i = 0; i < index-1; i++) {
				if(currentHead.hasNext()) {
					currentHead = currentHead.next();
				}
			}
			Node<T> indexObj = currentHead.next();
			if(indexObj.hasNext()) {
				currentHead.setNext(indexObj.next());
				indexObj.setNext(null);
				size--;
				return indexObj.getData();
			}
			else {
				currentHead.setNext(null);
				size--;
				return indexObj.getData();
			}
		}
		throw e;
	}
	
	public T remove(T o){
		Node<T> currentHead = head;
		if(head.getData().equals(o)){
			head = head.next();
			currentHead.setNext(null);
			size--;
			return currentHead.getData();
		}
		for(int i = 0; i < size(); i++){
			if(currentHead.hasNext()){
				if(currentHead.next().getData().equals(o)){
					Node<T> foundObj = currentHead.next();
					currentHead.setNext(foundObj.next());
					foundObj.setNext(null);
					size--;
					return foundObj.getData();
				}
				else {
					currentHead = currentHead.next();
				}
			}
		}
		return null;
	}
	
	public boolean set(int index, T element) throws IndexOutOfBoundsException{
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		if(index == 0) {
			head.setData(element);
			return true;
		}
		else if(index < size()) {
			Node<T> currentHead = head;
			for(int i = 0; i < index; i++) {
				if(currentHead.hasNext()) {
					currentHead = currentHead.next();
				}
			}
			currentHead.setData(element);
			return true;
		}
		else {
			throw e;
		}
	}
	
	public int size(){
		return size;
	}
	
	public MyLinkedList<T> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException{
		Node<T> currentHead = head;
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		MyLinkedList<T> temp = new MyLinkedList<T>();
		if(fromIndex >= 0 && toIndex < size() & fromIndex < size() & toIndex >=0) {
			for(int i = 0; i < fromIndex; i++) {
					currentHead = currentHead.next();
			}
			for(int i = fromIndex; i <= toIndex; i++) {
				temp.add(currentHead.getData());
				currentHead = currentHead.next();
			}
			return temp;
		}
		throw e;
	}
	
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size()];
		Node<T> currentHead = head;
		for(int i = 0; i < size(); i++) {
			array[i] = currentHead.getData();
			if(currentHead.hasNext()) {
				currentHead = currentHead.next();
			}
		}
		return array;
	}
	
	public boolean swap(int position1, int position2) throws IndexOutOfBoundsException{
		Node<T> pos1 = head;
		Node<T> pos2 = head;
		Node<T> prevPos1 = head;
		Node<T> prevPos2 = head;
		Node<T> postPos1;
		Node<T> postPos2;
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		if(position1 >= 0 && position1 < size() && position2 >= 0 && position2 < size()) {
			for(int i = 0; i < position1-1; i++) {
				if(prevPos1.hasNext()) {
					prevPos1 = prevPos1.next();
					pos1 = pos1.next();
				}
			}
			pos1 = pos1.next();
			for(int i = 0; i < position2-1; i++) {
				if(prevPos2.hasNext()) {
					prevPos2 = prevPos2.next();
					pos2 = pos2.next();
				}
			}
			pos2 = pos2.next();
			postPos2 = pos2.next();
			postPos1 = pos1.next();
			prevPos1.setNext(pos2);
			pos2.setNext(postPos1);
			prevPos2.setNext(pos1);
			pos1.setNext(postPos2);
			return true;
		}
		throw e;
	}
	
	public boolean shift(int positions){
		int numShifts;
		if(positions >= 0) {
			numShifts = (positions % size());
			for(int i = 0; i < numShifts-1; i++) {
				add(remove(0));
			}
			return true;
		}
		else if(positions < 0) {
			positions = Math.abs(positions);
			numShifts = (positions % size());
			numShifts = (size()-numShifts);
			for(int i = 0; i < numShifts-1; i++) {
				add(remove(0));
			}
			return true;
		}
		return false;
	}
}
