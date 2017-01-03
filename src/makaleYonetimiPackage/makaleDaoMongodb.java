package makaleYonetimiPackage;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akif
 */
public class makaleDaoMongodb implements makaleDao {
    

    public makaleDaoMongodb() throws IOException {
        
    }

    @Override
    public ArrayList<makale> getAllMakale() {
        ArrayList<makale> makeleList = new ArrayList<makale>();
         
            MongoClient mongoClient=new MongoClient("localhost",27017);
            DB db=mongoClient.getDB("NesneProjeDB");
            DBCollection MakaleTablo=db.getCollection("MakaleTablo");

            DBCursor cursor = MakaleTablo.find();
            while(cursor.hasNext())
            {
                makale mkle = new makale();
                DBObject dbo =cursor.next();
                System.out.println(dbo);
                mkle.setId(dbo.get("id").toString());
                mkle.setTitle(dbo.get("title").toString());
                mkle.setAuthors(dbo.get("authors").toString());
                mkle.setVenue(dbo.get("venue").toString());
                mkle.setYear(Integer.parseInt(dbo.get("year").toString()));

                Object o=dbo.get("context");
                if(o!=null)
                    mkle.setContext(o.toString());

                makeleList.add(mkle);
            }
            
            return makeleList;
    }

    @Override
    public makale getMakale(String id) {
        makale mkle = new makale();
        MongoClient mongoClient=new MongoClient("localhost",27017);
        DB db=mongoClient.getDB("NesneProjeDB");
        DBCollection MakaleTablo=db.getCollection("MakaleTablo");
        
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("id", id);
        DBCursor cursor = MakaleTablo.find(whereQuery);
        while(cursor.hasNext()) 
        {
            DBObject dbo =cursor.next();
            mkle.setId(dbo.get("id").toString());
            mkle.setTitle(dbo.get("title").toString());
            mkle.setAuthors(dbo.get("authors").toString());
            mkle.setVenue(dbo.get("venue").toString());
            mkle.setYear(Integer.parseInt(dbo.get("year").toString()));
           
            Object o=dbo.get("context");
            if(o!=null)
                mkle.setContext(o.toString());
            
        }
        return mkle;
    }
    
    @Override
    public void setAllMakaleToDatabase(ArrayList<String> makaleler) {
    
        try {
            ArrayList<makale> makeleList= new FileOperator().makeEverythingBeatiful("resource/ACM.csv",makaleler);
            MongoClient mongoClient=new MongoClient("localhost",27017);
            mongoClient.dropDatabase("NesneProjeDB");
            DB db=mongoClient.getDB("NesneProjeDB");
            DBCollection MakaleTablo=db.createCollection("MakaleTablo",new BasicDBObject());
            for(makale m : makeleList)   
            { 
                BasicDBObject dbo = new BasicDBObject();
                dbo.put("id", m.getId());              
                dbo.put("title", m.getTitle());
                dbo.put("authors", m.getAuthors());
                dbo.put("venue", m.getVenue());
                dbo.put("year", m.getYear());
                dbo.put("context", m.getContext());
                MakaleTablo.insert(dbo);
            }
        } catch (IOException ex) {
            Logger.getLogger(makaleDaoMongodb.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
}
