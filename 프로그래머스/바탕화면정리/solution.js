/**
 * [solution]
 * # : 파일 위치
 * . : 비어있는 위치
 *
 * - #이 있는 값들을 모두 찾아서 좌표를 배열에 담는다.
 * - 해당 배열에서 lux의 최소값, luy의 최소값을 구한다.
 * - 해당 배열에서 rdx의 최대값, rdy의 최대값을 구한다.
 *  - 파일을 드래그 하기 위해서는 오른쪽 아래까지 하기 때문에, 최대값에 +1씩 해준다.
 * - 구한 값들을 배열에 담아서 반환한다.
 */

const solution = (wallpaper) => {
    const wallpaperMaps = wallpaper.map((column) => column.split(""));
    const filePosition = [];

    wallpaperMaps.forEach((column, y) => {
        column.forEach((row, x) => {
            if(row === "#") {
                filePosition.push([y, x]);
            }
        })
    })

    let lux = filePosition[0][1];
    let luy = filePosition[0][0];
    let rdx = 0;
    let rdy = 0;
    filePosition.forEach(([y, x]) => {
        if(y < luy) luy = y;
        if(x < lux) lux = x;
        if(y > rdy) rdy = y;
        if(x > rdx) rdx = x;
    });

    return [luy, lux, rdy + 1, rdx + 1];
}
