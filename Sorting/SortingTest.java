package Sorting;

import java.util.Random;

public class SortingTest<E extends Comparable<? super E>> implements Sorting<E> {

	public static void main(String[] args) {
		SortingTest<Integer> sorting = new SortingTest<Integer>();
		int items_in_list = 5;
		LinkedList<Integer> list = sorting.GetNewLisWithNumbers(items_in_list);

		// test intestion sort
		System.out.println("Linked List before Insertion Sort..");
		list.printlist(list.head);
		sorting.insertionSort(list, 0, items_in_list - 1, false);
		System.out.println("\nLinkedList After Insertion Sort");
		list.printlist(list.head);

		System.out.println("\n");

		// test quick sort
		list = sorting.GetNewLisWithNumbers(items_in_list);
		System.out.println("Linked List before Quick Sort..");
		list.printlist(list.head);
		sorting.quicksort(list, 0, items_in_list - 1, false);
		System.out.println("\nLinkedList After Quick Sort");
		list.printlist(list.head);

		System.out.println("\n");

		// test merge sort
		list = sorting.GetNewLisWithNumbers(items_in_list);
		System.out.println("Linked List before Merge Sort..");
		list.printlist(list.head);
		sorting.mergeSortLL(list, false);
		System.out.println("\nLinkedList After Merge Sort");
		list.printlist(list.head);
	}

	// get a linked list with n elements
	private LinkedList<Integer> GetNewLisWithNumbers(int n) {
		int temp_number = n;
		LinkedList<Integer> list = new LinkedList<Integer>();
		Random r = new Random();
		while (n > 0) {
			list.push(r.nextInt(temp_number));
			n--;
		}

		return list;
	}

	@Override
	public void insertionSort(LinkedList<E> list, int lowindex, int highindex, boolean reversed) {
		// TODO: change insertionSort signture to be the same as above(accept low and
		// high index and a reversed flag)
		list.insertionSort(list.head);
	}

	@Override
	public void quicksort(LinkedList<E> list, int lowindex, int highindex, boolean reversed) {
		// TODO: change insertionSort signture to be the same as above(accept low and
		// high index and a reversed flag)
		list.quickSort(list.head, list.getLastNode());
	}

	@Override
	public void mergeSortLL(LinkedList<E> list, boolean reversed) {
		// TODO Auto-generated method stub

	}

}
