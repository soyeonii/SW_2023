const { MongoClient } = require("mongodb");
const url = "mongodb://127.0.0.1:27017";
const client = new MongoClient(url);

async function connectMongoDB() {
  await client.connect();
  const adminDB = client.db("test").admin();
  const listDatabases = await adminDB.listDatabases();
  console.log(listDatabases);
  return "ok";
}

connectMongoDB()
  .then(console.log)
  .then(console.error)
  .finally(() => client.close);
