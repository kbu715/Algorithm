function solution(bridge_length, weight, truck_weights) {
  // bridge_length : 다리에 올라갈 수 있는 최대 트럭의 수 -> 2
  // weight : 다리가 견딜 수 있는 무게 -> 10
  // truck_weights : 대기 트럭 별 무게 -> [7, 4, 5, 6]

  // [0, 0, 0] 상태이면 길이가 3인 다리에 아직 트럭이 하나도 올라오지 않은 상태이며
  // [0, 0, 7] 상태이면 무게 7인 트럭이 이제 막 진입한 상태이며, 1초가 지날 때 마다
  // [0, 0, 7] -> [0, 7, 0] -> [7, 0, 0]
  const orderOfBridge = Array.from({ length: bridge_length }, (v) => 0); // [0, 0]
  let weightOnBridge = 0; // 다리위 트럭들의 무게
  let tick = 0; // 경과 시간
  while (truck_weights.length > 0) {
    tick++;
    weightOnBridge -= orderOfBridge.shift();
    if (weightOnBridge + truck_weights[0] > weight) {
      orderOfBridge.push(0);
    } else {
      const currentTruckWeight = truck_weights.shift();
      orderOfBridge.push(currentTruckWeight);
      weightOnBridge += currentTruckWeight;
    }
  }
  return tick + bridge_length; // truck_weights.length가 0이 되는 순간 while문을 빠져 나오므로 마지막 트럭이 다리를 건너오기 까지의 시간을 추가해줘야 한다 ( = bridge_length)
}
