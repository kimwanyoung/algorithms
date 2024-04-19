function solution(order) {
    const container = Array(order.length).fill(0).map((_,idx)=>idx+1)
    const subContainer = []
    let orderIdx = 0,containerIdx = 0, boxLeapCount = 0

    while(boxLeapCount < order.length){
        const orderBox = order[orderIdx]
        if(orderBox === container[containerIdx]){
            containerIdx++
            orderIdx++
            boxLeapCount++
        }
        else if(orderBox === subContainer[subContainer.length-1]){
            subContainer.pop()
            orderIdx++
            boxLeapCount++
        }
        else if(container[containerIdx] > orderBox){
            break
        }
        else{
            subContainer.push(container[containerIdx])
            containerIdx++
        }
    }

    return boxLeapCount
}