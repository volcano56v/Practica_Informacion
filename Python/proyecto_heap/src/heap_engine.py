class GenericHeap:
    def __init__(self, data=None, mode="max"):
        self.mode = mode
        self.heap = []
        if data:
            self.heap = list(data)
            self.heapify()

    def _compare(self, child, parent):
        if self.mode == "max":
            return child > parent
        return child < parent

    def peek(self):
        return self.heap[0] if self.heap else None

    def insert(self, val):
        self.heap.append(val)
        self._sift_up(len(self.heap) - 1)

    def _sift_up(self, i):
        parent = (i - 1) // 2
        if i > 0 and self._compare(self.heap[i], self.heap[parent]):
            self.heap[i], self.heap[parent] = self.heap[parent], self.heap[i]
            self._sift_up(parent)

    def extract(self):
        if not self.heap: return None
        if len(self.heap) == 1: return self.heap.pop()
        
        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._sift_down(0)
        return root

    def _sift_down(self, i):
        left = 2 * i + 1
        right = 2 * i + 2
        target = i

        if left < len(self.heap) and self._compare(self.heap[left], self.heap[target]):
            target = left
        if right < len(self.heap) and self._compare(self.heap[right], self.heap[target]):
            target = right

        if target != i:
            self.heap[i], self.heap[target] = self.heap[target], self.heap[i]
            self._sift_down(target)

    def heapify(self):
        # Empezamos desde "the last non-leaf node" según tu imagen
        start_index = (len(self.heap) - 2) // 2
        for i in range(start_index, -1, -1):
            self._sift_down(i)