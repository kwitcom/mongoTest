const { MongoClient } = require("mongodb");
const stream = require("stream");

const uri =
  "mongodb+srv://<username>:<password>@glb-dev.g6r6v.mongodb.net/?retryWrites=true&w=majority&tls=true&tlsInsecure=true";
const recordLimit = 500
const databaseName = "glb-dev-workspaceservice"
const collectName = "workspaces"


const client = new MongoClient(uri, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

async function run() {
  try {
    await client.connect();

    const database = client.db(databaseName);
    const collection = database.collection(collectName);

    const docs = await collection.find({}).limit(recordLimit).toArray();

    for (const doc of docs) {

      const findDoc = await collection.find({"_id":doc._id }).explain();
      findDoc.executionStats.executionStages.shards.forEach(item => {
        if (item.nReturned > 0) {
          const stg = "doc._id: " + doc._id + " | doc.location: " + doc.location +  " | item.shardName: " + item.shardName;
          console.log(stg);
        }

      });
    }
  } finally {
    await client.close();
  }
}
run().catch(console.dir);
