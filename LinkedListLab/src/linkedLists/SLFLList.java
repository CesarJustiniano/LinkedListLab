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
		if(target.equals(last)){
			last.setNext((linkedLists.AbstractSLList.SNode<E>) nuevo);
			last = (linkedLists.AbstractSLList.SNode<E>) nuevo;
		}
		else if(target.equals(first)){
			current = (linkedLists.AbstractSLList.SNode<E>) nuevo;
			current.setNext(first.getNext());
			first.setNext(current);
		}
		else{
			SNode<E> currentNuevo = (linkedLists.AbstractSLList.SNode<E>) nuevo;
			current = (linkedLists.AbstractSLList.SNode<E>) target;
			currentNuevo.setNext(current.getNext());
			current.setNext(currentNuevo);
		}
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if(target.equals(first)){
			current = (linkedLists.AbstractSLList.SNode<E>) nuevo;
			current.setNext(first);
			first = current;
		}
		else{
			current = first;
			SNode<E> currentNuevo = (linkedLists.AbstractSLList.SNode<E>) nuevo;
			while(!current.getNext().equals(target)){
				current = current.getNext();
			}
			currentNuevo.setNext((linkedLists.AbstractSLList.SNode<E>) target);
			current.setNext(currentNuevo);
		}
		length++;
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if(length == 0){
			throw new NoSuchElementException();
		}
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if(length == 0){
			throw new NoSuchElementException();
		}
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		current = first;
		while(!current.equals(target) || current != null){
			current = current.getNext();
		}
		
		if(target.equals(last) || length == 0 || current == null){
			throw new NoSuchElementException();
		}
		else if(target.equals(first)){
			return first.getNext();
		}
		
		return current.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		current = first;
		while(!current.getNext().equals(target) || current != null){
			current = current.getNext();
		}
		
		if(target.equals(first) || length == 0 || current == null){
			throw new NoSuchElementException();
		}
		
		return current;
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		if(target.equals(first)){
			current = (linkedLists.AbstractSLList.SNode<E>) target;
			first = first.getNext();
			current.setNext(null);
			current.clean();
		}
		else if(target.equals(last)){
			current = first;
			while(!current.getNext().equals(last)){
				current = current.getNext();
			}
			last = current;
			last.getNext().clean();
			last.setNext(null);
		}
		else{
			current = first;
			while(!current.getNext().equals(target) || current != null){
				current = current.getNext();
			}
			if(current != null){
				SNode<E> currentTarget = (linkedLists.AbstractSLList.SNode<E>) target;
				current.setNext(currentTarget.getNext());
				currentTarget.clean();
			}
			else
				length++;
		}
		length--;
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
