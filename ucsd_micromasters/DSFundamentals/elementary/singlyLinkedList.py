class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def pushFront(self, val) -> Node:
        new_node = Node(val)
        new_node.next = self.head
        self.head = new_node
        return new_node

    def deleteFront(self, node: Node) -> bool:
        if self.head is None:
            return True

        if(self.head == node):
            self.head = node.next
            node.next = None
            return True

        current = self.head
        while current:
            if current.next == node:
                current.next = node.next
                node.next = None
                return True
            current = current.next

        raise LookupError("given Node not in list.")

    def reverse(self) -> None:
        previousNode = None
        currentNode = self.head
        nextNode = currentNode.next

        while currentNode:
            currentNode.next = previousNode
            previousNode = currentNode
            currentNode = nextNode
            if(currentNode):
                nextNode = currentNode.next
            else:
                break
            self.head = currentNode

    def print(self) -> None:
        current = self.head
        while current:
            print(current.val, end="->")
            current = current.next
        print()

l = LinkedList()

tail = l.pushFront(2)
mid = l.pushFront(4)
head = l.pushFront(5)

l.print()
# l.deleteFront(head)
# l.reverse()
# l.print()
print(l.head.val)
