package Sorting;

public interface Sorting<E extends Comparable<? super E>> {
	public void insertionSort(LinkedList<E> list, int lowindex, int highindex, boolean reversed);

	public void quicksort(LinkedList<E> list, int lowindex, int highindex, boolean reversed);

	public void mergeSortLL(LinkedList<E> list, boolean reversed);
}
