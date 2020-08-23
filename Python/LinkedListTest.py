from LinkedList import LinkedList

def iteratorTest():
    print("iteratorTest begun")
    linked_list = LinkedList(4)
    new_linked_list = linked_list.prepend_item(5)
    for tail in new_linked_list:
        print(tail.data)

def appendItemTest():
    print("append")
    linked_list = LinkedList(4)
    linked_list.append_item(3)
    for tail in linked_list:
        print(tail.data)


def startTests():
    print("Testing begun")
    iteratorTest()
    appendItemTest()

startTests()