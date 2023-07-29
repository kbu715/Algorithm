/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function (fn) {
  let obj = {};
  this.forEach((item) => {
    const key = fn(item);

    if (!obj[key]) {
      obj[key] = this.filter((item) => fn(item) === key);
    }
  });

  return obj;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
