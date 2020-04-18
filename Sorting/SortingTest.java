package Sorting;

import Sorting.LinkedList;

public class SortingTest<E extends Comparable<? super E>> implements Sorting<E> {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);
		System.out.println("Linked List before Sorting..");
		list.printlist(list.head);
		// TODO: change to use insertion method at line 24 !!!!!!!!!!!!!!!!!!!!
		list.insertionSort(list.head);
		System.out.println("\nLinkedList After sorting");
		list.printlist(list.head);

	}

	@Override
	public void insertionSort(LinkedList<E> list, int lowindex, int highindex, boolean reversed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void quicksort(LinkedList<E> list, int lowindex, int highindex, boolean reversed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mergeSortLL(LinkedList<E> list, boolean reversed) {
		// TODO Auto-generated method stub

	}

}
