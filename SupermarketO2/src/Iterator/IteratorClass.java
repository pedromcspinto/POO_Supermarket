package Iterator; 

import java.util.List;

public class IteratorClass<E> implements Iterator<String>{

	private List<String> elems;
	private int size;
	private int current;
		
	public IteratorClass(List<String> elems, int size) {
		this.elems = elems;
		this.size = size;
		init();
	}

	public void init() { 
		current = 0; 
		}
	
	public boolean hasNext() { 
		return (current < size);
		}
	
	public String next() {
	return elems.get(current++);
	}
}
