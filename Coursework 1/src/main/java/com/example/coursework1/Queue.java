

/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also, you cannot use ArrayLists or arrays (you will get zero).
 * @author you
 *
 */



import java.util.NoSuchElementException;

public class Queue<T> {

	//TODO:  You need some data to store the queue.  Put the attributes here.
	private QueueElement<T> head;
	private QueueElement<T> tail;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    //TODO: Write the Queue constructor
		head = null;
		tail = null;
	}
	
	/**
	 * Returns true if the queue is empty
	 *
	 * @return true if queue empty, otherwise returns false
	 *
	 */

	public boolean isEmpty () {
	    //TODO:  Needs to return true when empty and false otherwise
		return head == null && tail == null;
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 *
	 * @return the element at the head of the queue
	 */

	public T peek (){

		if (isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		} else {
			return head.getElement();
		}

	}
	
	/**
	 * Removes the front element of the queue
	 */

	public void dequeue () throws NoSuchElementException {
		if (isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		} else if (head == tail){
			head = null;
			tail = null;
		} else {
			head = head.getNext();
		}
	}


	/**
	 * Puts an element on the back of the queue.
	 *
	 * @param element, the element to enqueue of type t
	 *
	 */
	public void enqueue(T element) {
		QueueElement<T> newNode = new QueueElement<>(element, null);

		if (isEmpty()) {
			head = newNode;
		} else {
			tail.setNext(newNode);
		}

		tail = newNode;
	}


	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {

		QueueElement<T> currNode = head;

		while (currNode != null) {
			System.out.println(currNode.getElement().toString());
			currNode = currNode.getNext();

		}
	}
}
