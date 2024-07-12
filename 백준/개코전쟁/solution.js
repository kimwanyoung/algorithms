/**
 * [solution]
 * 1번 노드에서 N번 노드까지의 최단 거리를 구한 후 연결된 간선 하나를 파괴해서 최대값을 구해야한다.
 * 다익스트라로 + BFS를 이용해서 해결 할 수 있다.
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
    "5 6",
    "1 2 4",
    "1 3 3",
    "2 3 1",
    "2 4 4",
    "2 5 7",
    "4 5 1",
]

const [n, m] = input[0].split(" ").map(Number);
const graph = [];
for(let i = 0; i <= n; i++) graph.push([]);
for(let i = 1; i <= m; i++) {
    const [a, b, dist] = input[i].split(" ").map(Number);
    graph[a].push([b, dist]);
    graph[b].push([a, dist]);
}
let distance = new Array(n + 1).fill(Infinity);

dijkstra(-1, -1);
const removes = bfs();

let result = 0;
for(const [a, b] of removes) {
    distance = new Array(n + 1).fill(Infinity);
    dijkstra(a, b);
    result = Math.max(result, distance[n]);
}

console.log(result);


function dijkstra(a, b) {
    const pq = new PriorityQueue((a, b) => b[1] - a[1]);
    pq.enq([1, 0]);
    distance[1] = 0;

    while(pq.size() !== 0) {
        const [now, dist] = pq.deq();
        if(dist < distance[now]) continue;

        for(const i of graph[now]) {
            if(i[0] === a && now === b) continue;
            if(i[0] === b && now === a) continue;

            let cost = dist + i[1];
            if(cost < distance[i[0]]) {
                distance[i[0]] = cost;
                pq.enq([i[0], cost]);
            }
        }
    }
}

function bfs() {
    const queue = [];
    const visited = new Set();
    queue.push(n);
    const removes = [];

    while(queue.length !== 0) {
        const now = queue.shift();
        if(now === 1) continue;

        for(const i of graph[now]) {
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


