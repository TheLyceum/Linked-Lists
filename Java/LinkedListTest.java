public class LinkedListTest {
    
    private LinkedList<Integer> intLinkedList = null;

    LinkedListTest() {
        setUp();
        prependItemTest();
        tearDown();
        System.out.println("Finished prependItemTest.");
        System.out.println("Starting iteratorTest.");
        setUp();
        iteratorTest();
        tearDown();
        System.out.println("Finished iteratorTest.");
    }

    private void setUp() {
        intLinkedList = new LinkedList<>(5);
    }

    private void tearDown() {
        intLinkedList = null;
    }

    private void prependItemTest() {
        LinkedList<Integer> newLinkedList = this.intLinkedList.prependItem(4);
        System.out.println(newLinkedList.getData());
        if (newLinkedList.getTail().isPresent()) {
            System.out.println(newLinkedList.getTail().get().getData());
        }
    }

    // private void appendItemTest() {
    // }

    private void iteratorTest() {
        int[] testData = {3, 2, 4};
        LinkedList<Integer> newLinkedList = this.intLinkedList;
        for (int i = 0; i < 3; i++) {
            newLinkedList = newLinkedList.prependItem(testData[i]);
            System.out.println("i: " + i);
        }
        for (LinkedList<Integer> tail : newLinkedList) {
            System.out.println(tail.getData());
        }
    }
}
