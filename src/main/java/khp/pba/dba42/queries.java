/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khp.pba.dba42;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import org.bson.Document;

/**
 *
 * @author Kasper
 */
public class queries {

    MongoDatabase db = mongo.db();
    String collection = "tweets";

    public long getTweetsCount() {
        return db.getCollection(collection).count();
    }

    public int getUsersCount() {
        int count;
        try (MongoCursor<Document> c = db.getCollection(collection).aggregate((Arrays.asList(new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1)))))).iterator()) {
            count = 0;
            while (c.hasNext()) {
                count++;
                c.next();
            }
        }

        return count;
    }

    public ArrayList<String> getMostActiveUsers() {
        ArrayList<String> result = new ArrayList();
        try (MongoCursor<Document> c = db.getCollection(collection).aggregate((Arrays.asList(new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))), new BasicDBObject("$sort", new BasicDBObject("count", -1)), new BasicDBObject("$limit", 10)))).iterator()) {

            while (c.hasNext()) {

                Document d = c.next();

                result.add(d.get("_id").toString());
            }
        }

        return result;
    }

    public ArrayList<String> getMostGrumpyUsers() {
        ArrayList<String> result = new ArrayList();
        try (MongoCursor<Document> c = db.getCollection(collection).aggregate((Arrays.asList(new BasicDBObject("$match", new BasicDBObject("polarity", 0)), new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))), new BasicDBObject("$sort", new BasicDBObject("count", -1)), new BasicDBObject("$limit", 5)))).iterator()) {

            while (c.hasNext()) {
                
                Document d = c.next();

                result.add(d.get("_id").toString());
            }
        }

        return result;
    }

    public ArrayList<String> getMostPositiveUsers() {
        ArrayList<String> result = new ArrayList();
        try (MongoCursor<Document> c = db.getCollection(collection).aggregate((Arrays.asList(new BasicDBObject("$match", new BasicDBObject("polarity", 4)), new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))), new BasicDBObject("$sort", new BasicDBObject("count", 1)), new BasicDBObject("$limit", 5)))).iterator()) {

            while (c.hasNext()) {

                Document d = c.next();

                result.add(d.get("_id").toString());
            }
        }

        return result;
    }

}
