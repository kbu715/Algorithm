function solution(files) {
  const regex = /(\D+)(\d+)/;

  return files
    .map((file) => {
      console.log(file.match(regex));
      return file.match(regex);
    })
    .sort((a, b) => {
      if (a[1].toUpperCase() > b[1].toUpperCase()) {
        return 1;
      } else if (a[1].toUpperCase() < b[1].toUpperCase()) {
        return -1;
      } else {
        return +a[2] - +b[2];
      }
    })
    .map((file) => file.input);
}
