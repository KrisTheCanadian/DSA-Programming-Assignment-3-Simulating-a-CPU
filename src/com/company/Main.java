package com.company;

public class Main {

    public static void main(String[] args) {

        var jobs = new Job[]{};
        var queue = new PriorityQueue_ArrayHeap<>(10, new Job("job", 5, 1));
        CPU<?> cpu = new CPU<>(jobs, queue);

        PriorityQueue_SortedList<Integer> priorityQueueSorted = new PriorityQueue_SortedList<>(10,5);
        priorityQueueSorted.insert(1, 3);
        priorityQueueSorted.insert(2, 1);
        priorityQueueSorted.insert(3, 5);
        priorityQueueSorted.insert(4, 2);
        priorityQueueSorted.insert(5, 10);
        priorityQueueSorted.insert(6, 9);
        priorityQueueSorted.remove();
        priorityQueueSorted.remove();
        priorityQueueSorted.remove();
        priorityQueueSorted.remove();
        priorityQueueSorted.remove();
        priorityQueueSorted.remove();

    }
}
