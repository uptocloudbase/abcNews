package org.agd.abcnews.dao;

import static com.mongodb.client.model.Filters.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.agd.abcnews.entity.Article;
import org.agd.abcnews.entity.User;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBHandler {

	private final MongoClient mongo;
	private final MongoDatabase db;
	private static final String ARTICLE_COLLECTION = "articles";
	private ObjectMapper mapper = new ObjectMapper();


	public DBHandler(@Value("${db.mongoHost}") String mongoHost, @Value("${db.dbName}") String dbName) {

        mongo = new MongoClient(mongoHost);
		db = mongo.getDatabase(dbName);

        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        mapper.setDateFormat(df);
	}


	public List<Article> listArticles(boolean includeNotPublished) {

        List<Article> result = new ArrayList<>();

        MongoCollection<Document> collection = db.getCollection(ARTICLE_COLLECTION);

        MongoCursor<Document> cursor = null;

        try {

            if (!includeNotPublished) {
                cursor = collection.find(eq("status", "PUBLISHED")).iterator();
            } else {
                cursor = collection.find().iterator();
            }
            while (cursor.hasNext()) {

                Article article = mapper.readValue(cursor.next().toJson(), Article.class);
                result.add(article);
            }
        } catch (IOException ioe) {
            System.out.println("Error reading from Mongo DB");
            ioe.printStackTrace();
        }
        finally {
            cursor.close();
        }

        return result;

	}

	public Article getArticle (String id) {
        MongoCollection<Document> collection = db.getCollection(ARTICLE_COLLECTION);

        Document doc = collection.find(eq("_id", new ObjectId(id))).first();
        Article article = null;
        try {
            article = mapper.readValue(doc.toJson(), Article.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return article;
    }

	public User getUser(String id) {

		return null;

	}

}