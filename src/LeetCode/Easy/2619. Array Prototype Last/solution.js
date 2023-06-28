Array.prototype.last = function () {
  if (this.length) {
    return this.at(-1);
  }
  return -1;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
