/**
 * [solution]
 *
 * 전에 풀었던 개코전쟁과 비슷한 문제유형
 * 모든 최단거리를 갖는 노드들을 미리 구하고
 * 최단거리에 들어가는 간선을 제외한 후 다익스트라 다시 수행
 */

/**
 * Expose `PriorityQueue`.
 */
module.exports = PriorityQueue;

/**
 * Initializes a new empty `PriorityQueue` with the given `comparator(a, b)`
 * function, uses `.DEFAULT_COMPARATOR()` when no function is provided.
 *
 * The comparator function must return a positive number when `a > b`, 0 when
 * `a == b` and a negative number when `a < b`.
 *
 * @param {Function}
 * @return {PriorityQueue}
 * @api public
 */
function PriorityQueue(comparator) {
    this._comparator = comparator || PriorityQueue.DEFAULT_COMPARATOR;
    this._elements = [];
}

/**
 * Compares `a` and `b`, when `a > b` it returns a positive number, when
 * it returns 0 and when `a < b` it returns a negative number.
 *
 * @param {String|Number} a
 * @param {String|Number} b
 * @return {Number}
 * @api public
 */
PriorityQueue.DEFAULT_COMPARATOR = function(a, b) {
    if (typeof a === 'number' && typeof b === 'number') {
        return a - b;
    } else {
        a = a.toString();
        b = b.toString();

        if (a == b) return 0;

        return (a > b) ? 1 : -1;
    }
};

/**
 * Returns whether the priority queue is empty or not.
 *
 * @return {Boolean}
 * @api public
 */
PriorityQueue.prototype.isEmpty = function() {
    return this.size() === 0;
};

/**
 * Peeks at the top element of the priority queue.
 *
 * @return {Object}
 * @throws {Error} when the queue is empty.
 * @api public
 */
PriorityQueue.prototype.peek = function() {
    if (this.isEmpty()) throw new Error('PriorityQueue is empty');

    return this._elements[0];
};

/**
 * Dequeues the top element of the priority queue.
 *
 * @return {Object}
 * @throws {Error} when the queue is empty.
 * @api public
 */
PriorityQueue.prototype.deq = function() {
    var first = this.peek();
    var last = this._elements.pop();
    var size = this.size();

    if (size === 0) return first;

    this._elements[0] = last;
    var current = 0;

    while (current < size) {
        var largest = current;
        var left = (2 * current) + 1;
        var right = (2 * current) + 2;

        if (left < size && this._compare(left, largest) >= 0) {
            largest = left;
        }

        if (right < size && this._compare(right, largest) >= 0) {
            largest = right;
        }

        if (largest === current) break;

        this._swap(largest, current);
        current = largest;
    }

    return first;
};

/**
 * Enqueues the `element` at the priority queue and returns its new size.
 *
 * @param {Object} element
 * @return {Number}
 * @api public
 */
PriorityQueue.prototype.enq = function(element) {
    var size = this._elements.push(element);
    var current = size - 1;

    while (current > 0) {
        var parent = Math.floor((current - 1) / 2);

        if (this._compare(current, parent) <= 0) break;

        this._swap(parent, current);
        current = parent;
    }

    return size;
};

/**
 * Returns the size of the priority queue.
 *
 * @return {Number}
 * @api public
 */
PriorityQueue.prototype.size = function() {
    return this._elements.length;
};

/**
 *  Iterates over queue elements
 *
 *  @param {Function} fn
 */
PriorityQueue.prototype.forEach = function(fn) {
    return this._elements.forEach(fn);
};

/**
 * Compares the values at position `a` and `b` in the priority queue using its
 * comparator function.
 *
 * @param {Number} a
 * @param {Number} b
 * @return {Number}
 * @api private
 */
PriorityQueue.prototype._compare = function(a, b) {
    return this._comparator(this._elements[a], this._elements[b]);
};

/**
 * Swaps the values at position `a` and `b` in the priority queue.
 *
 * @param {Number} a
 * @param {Number} b
 * @api private
 */
PriorityQueue.prototype._swap = function(a, b) {
    var aux = this._elements[a];
    this._elements[a] = this._elements[b];
    this._elements[b] = aux;
};

const input = [
    "7 9",
    "0 6",
    "0 1 1",
    "0 2 1",
    "0 3 2",
    "0 4 3",
    "1 5 2",
    "2 6 4",
    "3 6 2",
    "4 6 4",
    "5 6 1",
    "4 6",
    "0 2",
    "0 1 1",
    "1 2 1",
    "1 3 1",
    "3 2 1",
    "2 0 3",
    "3 0 2",
    "6 8",
    "0 1",
    "0 1 1",
    "0 2 2",
    "0 3 3",
    "2 5 3",
    "3 4 2",
    "4 1 1",
    "5 1 1",
    "3 0 1",
    "0 0"
]

let i = 0;
while(true) {
    const [n, m] = input[i++].split(" ").map(Number);
    if(n === 0 && m === 0) break;

    const [start, end] = input[i++].split(" ").map(Number);
    let graph = [];
    const reversed_graph = [];
    let distance = new Array(n).fill(Infinity);
    for(let j = 0; j < n; j++) {
        graph.push([]);
        reversed_graph.push([]);
    }
    for(let j = i; j < i + m; j++) {
        const [a, b, dist] = input[j].split(" ").map(Number);
        graph[a].push([b, dist]);
        reversed_graph[b].push([a, dist]);
    }

    dijkstra();
    graph = getNewGraph();

    distance = new Array(n).fill(Infinity);
    dijkstra();

    if(distance[end] === Infinity) console.log(-1);
    else console.log(distance[end]);
    i += m;

    function dijkstra() {
        const queue = new PriorityQueue((a, b) => b[1] - a[1]);
        queue.enq([start, 0]);
        distance[start] = 0;

        while(queue.size() !== 0) {
            const [now, dist] = queue.deq();

            for(const i of graph[now]) {
                const cost = dist + i[1];
                if(cost < distance[i[0]]) {
                    distance[i[0]] = cost;
                    queue.enq([i[0], cost]);
                }
            }
        }
    }

    function bfs() {
        const queue = [];
        const visited = new Set();
        queue.push(end);
        const removes = [];

        while(queue.length !== 0) {
            const now = queue.shift();
            if(now === start) continue;

            // 단방향 간선이기 때문에 역추적을 위한 그래프 별도 선언함
            for(const i of reversed_graph[now]) {
                let cost = distance[i[0]] + i[1];
                if(cost === distance[now]) {
                    removes.push([i[0], now]);
                    if(!visited.has(i[0])) {
                        queue.push(i[0]);
                        visited.add(i[0]);
                    }
                }
            }
        }
        return removes;
    }

    function getNewGraph() {
        const removes = bfs();
        const newGraph = [];
        for(let i = 0; i < n; i++) newGraph.push([]);
        for(let i = 0; i < n; i++) {
            for(const [b, c] of graph[i]) {
                let check = true;

                for(const [x, y] of removes) {
                    if(i === x && b === y) check = false;
                }
                if(check) newGraph[i].push([b, c]);
            }
        }
        return newGraph;
    }
}