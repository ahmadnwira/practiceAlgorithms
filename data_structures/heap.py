class Heap:

    def __init__(self):
        self.h = []

    def _getleftChild(self, parentIndex):
        try:
            return self.h[2*parentIndex+1]
        except IndexError:
            return

    def _getrightChild(self, parentIndex):
        try:
            return self.h[2*parentIndex+2]
        except IndexError:
            return

    def _hasleftChild(self, parentIndex):
        if self._getleftChild(parentIndex):
            return True
        return False

    def _hasrightChild(self, parentIndex):
        if self._getrightChild(parentIndex):
            return True
        return False

    def _getParent(self, childIndex):
        return self.h[(childIndex-1)//2]

    def _hasParent(self, childIndex):
        if self._getParent(childIndex):
            return True
        return False

    def add(self, item):
        """ push item onto heap, maintaing the heap invariant """
        self.h.append(item)
        self.heapifyUp()

    def peek(self):
        if len(self.h) == 0:
            raise ValueError
        return self.h[0]

    def pop(self):
        """
            pop the smallest item off the heap, maintaing the heap invariant
        """

        if len(self.h) == 0:
            raise ValueError
        rv = self.h.pop(0)
        self.heapifyDown()
        return rv

    def heapifyUp(self):
        i = len(self.h)-1

        while(i > 0 and self._hasParent(i) and self._getParent(i) > self.h[i]):
            self.h[(i-1)//2], self.h[i] = self.h[i], self.h[(i-1)//2]
            i = (i-1)//2

    def heapifyDown(self):
        i = 0
        while(self._hasleftChild(i)):
            smaller_child = 2 * i + 1
            if self._hasrightChild(i):

                if self._getleftChild(i) > self._getrightChild(i):
                    smaller_child = 2 * i + 2

                if self.h[i] > self.h[smaller_child]:
                    self.h[i], self.h[smaller_child] = self.h[smaller_child], self.h[i]

            i = 2 * i + 1

    def __str__(self):
        return str(self.h)
