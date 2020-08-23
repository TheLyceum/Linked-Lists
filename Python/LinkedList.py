class LinkedList:
    def __init__(self, data, tail=None):
        self.data = data
        self.tail = tail

    def prepend_item(self, data):
        return LinkedList(data, self)
    
    def append_item(self, data):
        newLinkedList = self
        for tail in newLinkedList:
            newLinkedList = tail
        newLinkedList.tail = LinkedList(data)

    def __iter__(self):
        return LinkedListIterator(self)

class LinkedListIterator:
    def __init__(self, linked_list):
        self.linked_list = linked_list

    def __iter__(self):
        return self

    def __next__(self):
        if self.linked_list is None:
            raise StopIteration
        current = self.linked_list
        self.linked_list = self.linked_list.tail
        return current