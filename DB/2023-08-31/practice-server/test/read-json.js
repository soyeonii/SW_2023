const fs = require("fs");

const jsonFile = fs.readFileSync("./test/library.json");
console.log(jsonFile);
const jsonData = JSON.parse(jsonFile);
console.log(jsonData.data.userInfo.user);
