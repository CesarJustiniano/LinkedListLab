package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	private SNode<E> current;
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = current = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(length == 0){
			first = (linkedLists.AbstractSLList.SNode<E>) nuevo;
			last = (linkedLists.AbstractSLList.SNode<E>) nuevo;
		}
		else if (length == 1){			
			first = (linkedLists.AbstractSLList.SNode<E>) nuevo;
			first.setNext(last);
		}
		else{
			current = (linkedLists.AbstractSLList.SNode<E>) nuevo;
			current.setNext(first);
			first = (linkedLists.AbstractSLList.SNode<E>) nuevo;
		}
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(target.equals(last)){
			last.setNext((linkedLists.AbstractSLList.SNode<E>) nuevo);
			last = (linkedLists.AbstractSLList.SNode<E>) nuevo;
		}
		
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(target.equals(last)){
			throw new NoSuchElementException();
		}
		else if(target.equals(first)){
			return first.getNext();
		}
		return null;
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(target.equals(first)){
			throw new NoSuchElementException();
		}
		
		return null;
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
