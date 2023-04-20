// Write a function called collectStrings which accepts an object and returns an array of all the values in the object that have a typeof string

function collectStrings(obj) {
  let arr = [];

  Object.values(obj).forEach((val) => {
    if (typeof val === "string") {
      arr.push(val);
    } else if (typeof val === "object" && !Array.isArray(val)) {
      arr = [...arr, ...collectStrings(val)];
    }
  });

  return arr;
}

const obj = {
  stuff: "foo",
  data: {
    val: {
      thing: {
        info: "bar",
        moreInfo: {
          evenMoreInfo: {
            weMadeIt: "baz",
          },
        },
      },
    },
  },
};

const result = collectStrings(obj); // ["foo", "bar", "baz"])

console.log(result);
