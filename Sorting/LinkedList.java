package Sorting;

// E needs to implement Comparable so we can compare with other objects
public class LinkedList<E extends Comparable<? super E>> {
    Node<E> head;
    Node<E> sorted;

    // T needs to implement Comparable so we can compare to other objects
    class Node<T extends Comparable<? super T>> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

    void push(E val) {
        /* allocate node */
        Node<E> newnode = new Node<E>(val);
        /* link the old list off the new node */
        newnode.next = head;
        /* move the head to point to the new node */
        head = newnode;
    }

    // function to sort a singly linked list using insertion sort
    void insertionSort(Node<E> headref) {
        // Initialize sorted linked list
        sorted = null;
        Node<E> current = headref;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null) {
            // Store next for next iteration
            Node<E> next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        head = sorted;
    }

    /*
     * function to insert a new_node in a list. Note that this function expects a
     * pointer to head_ref as this can modify the head of the input linked list
     * (similar to push())
     */
    void sortedInsert(Node<E> newnode) {
        /* Special case for the head end */
        if (sorted == null || newnode.val.compareTo(sorted.val) <= 0) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Node<E> current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.val.compareTo(newnode.val) < 0) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    /* Function to print linked list */
    void printlist(Node<E> head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
