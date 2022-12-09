const { MongoClient } = require("mongodb");
const stream = require("stream");

const uri =
  "mongodb+srv://<username>:<password>@glb-dev.g6r6v.mongodb.net/?retryWrites=true&w=majority&tls=true&tlsInsecure=true";
const recordLimit = 500
const databaseName = "glb-dev-workspaceservice"
const collectName = "workspaces"
const outputDetailRecords = false


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
    const newItems = [];

    for (const doc of docs) {
      const findDoc = await collection.find({"_id":doc._id }).explain();
      findDoc.executionStats.executionStages.shards.forEach(item => {
        if (item.nReturned > 0) {
          const newItem = { id: doc._id , location: doc.location, shardName: item.shardName };
          newItems.push(newItem);

          if (outputDetailRecords){
            console.log(newItem);
          }
        }
      });
    }

    const counts = newItems.reduce((acc, item) => {
      const location = item.location;
      const shardName = item.shardName;

      // create a nested object to store the counts for each group
      if (!acc[location]) {
        acc[location] = {};
      }
      if (!acc[location][shardName]) {
        acc[location][shardName] = 0;
      }

      // increment the count for the group
      acc[location][shardName]++;

      return acc;
    }, {});

    // print the location, shardName, and count for each group
    for (const location in counts) {
      for (const shardName in counts[location]) {
        console.log(`Location: ${location} Shard: ${shardName} Count: ${counts[location][shardName]}`);
      }
    }


  } finally {
    await client.close();
  }
}
run().catch(console.dir);
