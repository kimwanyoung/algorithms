class PriorityQueue {
    constructor() {
        this.heap = new Array(64);
        this.size = 0;
    }

    insert(value) {
        const heap = this.heap;
        const size = ++this.size;

        if (size === heap.length) heap.length *= 2;

        heap[size] = value;
        this.percolateUp();
    }

    percolateUp() {
        const heap = this.heap;
        const size = this.size;

        let pos = size;
        const item = heap[pos];

        while (pos > 1) {
            const parent = heap[Math.floor(pos / 2)];
            if (parent <= item) break;
            heap[pos] = parent;
            pos = Math.floor(pos / 2);
        }

        heap[pos] = item;
    }

    shift() {
        const heap = this.heap;
        const value = heap[1];
        if (value === undefined) return undefined;
        const size = --this.size;

        heap[1] = heap[size + 1];
        heap[size + 1] = undefined;
        this.percolateDown();
        return value;
    }

    percolateDown() {
        const heap = this.heap;
        const size = this.size;

        let pos = 1;
        const item = heap[pos];

        while (pos * 2 <= size) {
            let childIndex = pos * 2 + 1;
            if (childIndex > size || heap[pos * 2] < heap[childIndex])
                childIndex = pos * 2;
            const child = heap[childIndex];
            if (item <= child) break;
            heap[pos] = child;
            pos = childIndex;
        }

        heap[pos] = item;
    }
}