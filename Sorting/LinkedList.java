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

    // function to sort a singly linked list using insertion sort
    void quickSort(Node<E> start, Node<E> end) {
        if (start == end)
            return;

        // split list and partion recurse
        Node<E> pivot_prev = paritionLast(start, end);
        quickSort(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            quickSort(pivot_prev.next, end);

        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null)
            quickSort(pivot_prev.next.next, end);
    }

    /*
     * takes first and last node, but do not break any links in the whole linked
     * list
     */
    Node<E> paritionLast(Node<E> start, Node<E> end) {
        if (start == end || start == null || end == null)
            return start;

        Node<E> pivot_prev = start;
        Node<E> curr = start;
        E pivot = end.val;

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            // if (start.val < pivot) {
            if(start == null || curr.next == null) break;
            if (start.val.compareTo(pivot) < 0) {
                // keep tracks of last modified item
                pivot_prev = curr;
                E temp = curr.val;
                curr.val = start.val;
                start.val = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        E temp = curr.val;
        curr.val = pivot;
        end.val = temp;

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }


    Node<E> mergeSort(Node<E> h) 
    { 
        // Base case : if head is null 
        if (h == null || h.next == null) { 
            return h; 
        } 
  
        // get the middle of the list 
        Node<E> middle = getMiddle(h); 
        Node<E> nextofmiddle = middle.next; 
  
        // set the next of middle node to null 
        middle.next = null; 
  
        // Apply mergeSort on left list 
        Node<E> left = mergeSort(h); 
  
        // Apply mergeSort on right list 
        Node<E> right = mergeSort(nextofmiddle); 
  
        // Merge the left and right lists 
        Node<E> sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
  

    Node<E> sortedMerge(Node<E> a, Node<E> b) 
    { 
        Node<E> result = null; 
        /* Base cases */
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
  
        /* Pick either a or b, and recur */
        // if (a.val <= b.val) { 
            if(a.val.compareTo(b.val) <= 0 ){
            result = a; 
            result.next = sortedMerge(a.next, b); 
        } 
        else { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
    } 
  
    
    
    /************* Helper Methods *************************/
    Node<E> getLastNode() {
        Node<E> n = this.head;
        while (n.next != null)
            n = n.next;
        return n;
    }

    // Utility function to get the middle of the linked list 
    Node<E> getMiddle(Node<E> head) 
    { 
        if (head == null) 
            return head; 

        Node<E> slow = head, fast = head; 

        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    } 


    /* Function to print linked list */
    void printlist(Node<E> head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
