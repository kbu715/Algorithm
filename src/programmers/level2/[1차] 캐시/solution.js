function solution(cacheSize, cities) {
  let answer = 0; // 실행시간

  let cache = [];

  for (const city of cities) {
    const idx = cache.findIndex((v) => v.toLowerCase() === city.toLowerCase());

    if (idx >= 0) {
      // cache hit
      cache.splice(idx, 1);
      cache.unshift(city);
      answer += 1;
    } else {
      // cache miss
      cache.unshift(city);
      if (cache.length > cacheSize) {
        cache.pop();
      }
      answer += 5;
    }
  }

  return answer;
}
