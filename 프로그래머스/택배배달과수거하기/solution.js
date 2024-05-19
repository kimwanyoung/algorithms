const solution = (cap, n, deliveries, pickups) => {
    let ans = 0
    // 트럭이 나갔다가 돌아와야 하므로 1번 왕복할 때 최대한 멀리 갔다오기
    // 배달할땐 최대한 실을 수 있는만큼 담는다. 그리고 돌아오면서 수거할 수 있는만큼 수거한다.
    // 그렇다면 다음과 같이, 2*max(배달해야할 최대 거리, 수거해야할 최대 거리)를 배달과 수거배열이 소진될때까지 반복하면 된다.
    // 이때 각 배열의 최대거리는 배열의 length로 계산한다.

    // 왕복하면서 배달과 수거를 동시에 할 수도 있지만, 한쪽에 비대칭적으로 많다면 (예들들어 왕복1번에 수거는 완료했지만 배달이 많아 왕복 3번 더 해야할 경우)배달과 수거 배열이 모두 소진될때까지 왕복해야하므로 || 처리
    while(deliveries.length || pickups.length){
        // 맨 끝이 0일경우 계산할 필요 없으므로 미리 처리한다.
        while(deliveries.length && !deliveries[deliveries.length-1]){deliveries.pop()}
        while(pickups.length && !pickups[pickups.length-1]){pickups.pop()}

        // 왕복거리를 계산해야 하므로 x2하고, 배달과 수거의 남은 거리중 큰 값을 사용한다.
        ans += 2*Math.max(deliveries.length , pickups.length)

        // 한번 편도로 갈 때 최대한 배달해놓기
        let deliveryTarget = 0
        while(deliveries.length){
            const lastDelivery = deliveries.pop()

            if(deliveryTarget+lastDelivery <= cap){
                deliveryTarget+=lastDelivery
                // 만약 cap보다 더 많은 배달물이 있다면 담을 수 있을만큼 담고, 남은 배달물은 다시 맨 끝에 둔 뒤 순회를 멈춘다.
            }else{
                deliveries.push(deliveryTarget+lastDelivery-cap)
                break
            }
        }
        // 배달과 같은 로직
        let pickupTarget = 0
        while(pickups.length){
            const lastPickup = pickups.pop()

            if(pickupTarget+lastPickup <= cap){
                pickupTarget+=lastPickup
            }else{
                pickups.push(pickupTarget+lastPickup-cap)
                break
            }
        }
    }
    return ans;
}