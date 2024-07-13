/**
 * [solution]
 * - 1번에서 N번노드로 가는 최단거리 중, 하나를 파괴해서 최단 거리 중 가장 오래 걸리는 시간 구하기
 * - 특정 모드에서 출발하기 떄문에 다익스트라 알고리즘 활용
 * - 일반 다익스트라로 먼저 최단거리를 구한다.
 * - 그 후 최단 거리에 포함되는 간선을 찾아야하기 때문에 bfs를 통해 최단거리와 비교하며 거리가 같은경우 최단거리이기 때문에
 *   배열에 추가시킨다. 모두 탐색했으면 배열 반환
 * - bfs로 찾은 간선들은 모두 최단거리에 포함되는 간선들이므로 하나씩 대입해보며 다익스트라 알고리즘을 실행하는데, 매개변수로 들어온
 *   간선은 건너뛰도록 한다.
 * - 매 실행마다 현재 결과와 이전 결과중 큰것으로 업데이트한다.
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
    "4 5 1"
];

const [n, m] = input[0].split(" ").map(Number);

const graph = Array.from(Array(n + 1), () => []);
for(let i = 1; i <= m; i++) {
    const [a, b, dist] = input[i].split(" ").map(Number);
    // 양방향이기 때문에 양쪽으로 넣어준다.
    graph[a].push([b, dist]);
    graph[b].push([a, dist]);
}

let distance = new Array(n + 1).fill(Infinity);
// 처음에는 건너 뛸 간선이 없기 때문에 -1을 대입해서 최단거리를 구한다.
dijkstra(-1, -1);
const removes = bfs();

let result = 0;
for(const [a, b] of removes) {
    distance = new Array(n + 1).fill(Infinity);
    dijkstra(a, b);
    result = Math.max(result, distance[n]);
}
console.log(result);

// 건너뛸 간선을 넣어주기 위해 매개 변수로 a, b를 받는다.
function dijkstra(a, b) {
    const q = new PriorityQueue((a, b) => b[1] - a[1]);
    q.enq([1, 0]);
    distance[1] = 0;

    while(q.size() !== 0) {
        const [cur, dist] = q.deq();
        if(dist < distance[cur]) continue;

        for(const i of graph[cur]) {
            // 최단거리에 포함되는 간선이 들어오면 건너뜀
            if(i[0] === a && cur === b) continue;
            if(i[0] === b && cur === a) continue;

            const cost = distance[cur] + i[1];
            if (cost < distance[i[0]]) {
                distance[i[0]] = cost;
                q.enq([i[0], cost]);
            }
        }
    }
}

function bfs() {
    //bfs실행할 큐
    const q = [];
    // 최단거리에 포함되는 간선을 넣은 배열
    const removes = [];
    const visited = new Set();
    //역추적하기 위해 맨 끝 노드를 넣어준다.
    q.push(n);
    visited.add(n);

    while(q.length !== 0) {
        const cur = q.shift();

        for(const i of graph[cur]) {
            if(distance[cur] === distance[i[0]] + i[1]){
                if(!visited.has(i[0])) {
                    visited.add(i[0]);
                    removes.push([i[0], cur]);
                    q.push(i[0]);
                }
            }
        }
    }
    return removes;
}