class Node:
    def __init__(self, val, next=None):
        self.data = val
        self.next = next

    def __str__(self):
        return str(self.data)


class LinkedList:
    def __init__(self):
        self.head = None

    def add(self, data):
        node = Node(data)
        if self.head is None:
            self.head = node

        else:
            node.next = self.head
            self.head = node

    def find(self, data):
        p = self.head
        while p:
            if p.data == data:
                return p
            p = p.next
        return None

    def reverse(self):
        crnt = self.head
        pre = None
        while crnt:
            nxt = crnt.next
            crnt.next = pre

            pre = crnt
            crnt = nxt

        self.head = pre

    def __str__(self):
        p = self.head
        rv = ""
        while p:
            rv += str(p.data) + "->"
            p = p.next

        return rv

# l = LinkedList()
# l.add(1)
# l.add(2)
# l.add(3)
# l.add(4)
# l.add(5)
# l.add([4, 4, 0])
# l.add(7)
# l.add('8a')
# l.add(9)

# print(l)

# l.reverse()

# print(l)
