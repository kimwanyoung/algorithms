/**
 * [solution]
 * - 명령을 수행하기 전에, 공원을 벗어나는지 or 장애물이 있는지 먼저 체크
 *  - 둘 중 하나라도 해당되면 명령 무시하고 다음 명령 진행
 * - S : 시작지점, O : 이동 가능한 통로, X : 장애물
 * - S의 위치를 찾아 시작지점의 좌표를 초기화 한다. let start
 * - park를 2차원 배열로 다시 선언한다.
 * - 주어진 조건에 맞게 routes를 순회하면서 시작지점 좌표에 이동한 거리를 더해준다.
 *  - 만약, 공원을 벗어나거나, 장애물이 있다면 다음 명령어 실행
 *  - 이동 후 최종지점 뿐만 아니라, 지나가는 길이라도 장애물이 있으면 다음 명령어 실행
 *  - 따라서, 한번에 이동하는 것이 아닌 한칸씩 이동하도록 구현.
 *  => 0보다 작은 경우도 검증 필요..
 * - 명령문을 마지막까지 수행한 시작지점을 반환한다.
 */
const solution = (park, routes) => {
    let start = findStart(park);
    const parkMap = park.map((p) => p.split(""));

    routes.forEach((route) => {
        const [direction, distance] = route.split(" ");
        start = checkMove(start, parkMap, direction, distance);
    })

    return start;
}

const findStart = (park) => {
    let start;

    for(let y = 0; y < park.length; y++) {
        for(let x = 0; x < park[0].length; x++) {
            if(park[y][x] === "S") {
                start = [y, x];
                break;
            }
        }
    }
    return start;
}

const checkMove = (currentPoint, park, direction, distance) => {
    let beforeMove = Array.from(currentPoint);
    let afterMove;

    for(let i = 0; i < distance; i++) {
        afterMove = move(beforeMove, direction);
        if(isValidPoint(afterMove, park)) {
            return currentPoint;
        }
    }
    return afterMove;
}

const move = (currentPoint, direction) => {
    if(direction === "E") currentPoint[1]++;
    if(direction === "W") currentPoint[1]--;
    if(direction === "S") currentPoint[0]++;
    if(direction === "N") currentPoint[0]--;

    return currentPoint;
}

const isValidPoint = (currentPoint, park) => {
    const parkColumnLength = park[0].length;
    const parkRowLength = park.length;


    return currentPoint[1] > parkColumnLength - 1 ||
        currentPoint[0] > parkRowLength - 1 ||
        currentPoint[1] < 0 ||
        currentPoint[0] < 0 ||
        park[currentPoint[0]][currentPoint[1]] === "X";
}

console.log(solution(["OOSOX", "OOOOX", "OXXXX", "OOOOO"], ["E 2", "S 3", "W 1"]));