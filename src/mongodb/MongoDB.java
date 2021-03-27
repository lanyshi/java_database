package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import org.bson.Document;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MongoDB {
    // initialize the client object
    public static MongoClient mongoClient = new MongoClient();
    // get the 'test' database
    public static MongoDatabase dbObj = mongoClient.getDatabase( "test" );

    public static void main(String[] args) {
        // list all collections in the 'test' db
        System.out.println("Collections inside this db: ");
        for (String name : dbObj.listCollectionNames()) {
            System.out.println(name);
        }
        // Create a new collection called 'animals'
        create_collection("animals");
        // Insert one document into 'animals'
        Map<String, String> doc1 = new HashMap<>();
        doc1.put("species", "panda");
        doc1.put("name", "lily");
        doc1.put("food", "bamboo");
        doc1.put("sex", "female");
        insert_to_collection("animals", doc1);
        // Insert another document into 'animals'
        Map<String, String> doc2 = new HashMap<>();
        doc2.put("species", "lion");
        doc2.put("name", "jay");
        doc2.put("food", "meat");
        doc2.put("sex", "male");
        insert_to_collection("animals", doc2);
        // Find all documents inside 'animals'
        read_collection("animals");
    }

    // Go to a specific collection
    public static MongoCollection<Document> get_collection(String name) {
        MongoCollection<Document> col = dbObj.getCollection(name);
        return col;
    }

    // Read the content of a document
    public static void read_collection(String name) {
        Iterator it = get_collection(name).find().iterator();
        while (it.hasNext()) {
            System.out.println("docs inside the collection: " + it.next());
        }
    }

    // creating a new collection
    public static void create_collection(String name) {
        dbObj.createCollection(name);
    }

    // Insert a new document into a collection
    public static void insert_to_collection(String name, Map<String, String> map) {
        Document mydoc = new Document();
        map.forEach((key, value) -> mydoc.put(key, value));
        get_collection(name).insertOne(mydoc);
    }

    // Remove a document from a collection
    public static void remove(String name, String key, String value) {
        BasicDBObject doc2remove = new BasicDBObject();
        doc2remove.put(key, value);
        get_collection(name).deleteMany(doc2remove);
    }

    // Drop the collection
    public static void drop_collection(String name) {
        get_collection(name).drop();
    }

}
