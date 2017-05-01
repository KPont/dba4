/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khp.pba.dba42;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClientURI;

import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class mongo {

    public static MongoDatabase db() {

        // To connect to mongodb server
        MongoClientURI conn = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(conn);
        // Now connect to your databases
        MongoDatabase db = mongoClient.getDatabase("social_net");

        return db;
    }
}
