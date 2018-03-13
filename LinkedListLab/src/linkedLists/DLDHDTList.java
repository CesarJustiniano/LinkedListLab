package linkedLists;

import java.util.NoSuchElementException;

public class DLDHDTList<E> extends AbstractDLList<E> {
	private DNode<E> header, trailer; 
	private int length; 
	
	public DLDHDTList() { 
		header = trailer = null;
		length = 0;
	}
	
	public void addFirstNode(Node<E> nuevo) {
		addNodeAfter(header, nuevo); 
	}
	
	public void addLastNode(Node<E> nuevo) { 
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = trailer.getPrev();  
		nBefore.setNext(dnuevo); 
		trailer.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(trailer); 
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = (DNode<E>) target; 
		DNode<E> nAfter = nBefore.getNext(); 
		nBefore.setNext(dnuevo); 
		nAfter.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(nAfter); 
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nAfter = (DNode<E>) target; 
		DNode<E> nBefore = (DNode<E>) nAfter.getPrev();
		dnuevo.setNext(nAfter);
		dnuevo.setPrev(nBefore);
		nBefore.setNext(dnuevo);
		nAfter.setPrev(dnuevo);
		length++;
	}

	public Node<E> createNewNode() {
		return new DNode<E>();
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return header.getNext();
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return trailer.getPrev();
	}

	public Node<E> getNodeAfter(Node<E> target)
			throws NoSuchElementException {
		DNode<E> nTarget = (DNode<E>) target; 

		if(nTarget.getNext() == null){
			throw new NoSuchElementException();
		}
		
		return nTarget.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		DNode<E> nTarget = (DNode<E>) target; 

		if(nTarget.getPrev() == null){
			throw new NoSuchElementException();
		}
		
		return nTarget.getPrev();
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		if(target.equals(header)){
			header = header.getNext();
			header.getPrev().clean();
			header.setPrev(null);
			length--;
		}
		else if(target.equals(trailer)){
			trailer = trailer.getPrev();
			trailer.getNext().clean();
			trailer.setNext(null);
			length--;
		}
		else if(target != null){
			DNode<E> nTarget = (DNode<E>) target; 
			DNode<E> nAfter = nTarget.getNext(); 
			DNode<E> nBefore = nTarget.getPrev();
			
			nBefore.setNext(nAfter);
			nAfter.setPrev(nBefore);
			nTarget.clean();
			length--;
		}
	}
	
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void destroy() {
		while (header != null) { 
			DNode<E> nnode = header.getNext(); 
			header.clean(); 
			header = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes from
	 * the current instance of the list, leaving it as a valid empty
	 * doubly linked list with dummy header and dummy trailer nodes. 
	 */
	public void makeEmpty() { 
		// TODO
		this.destroy();
		header = trailer = null;
	}
		
	protected void finalize() throws Throwable {
	    try {
			this.destroy(); 
	    } finally {
	        super.finalize();
	    }
	}

}
