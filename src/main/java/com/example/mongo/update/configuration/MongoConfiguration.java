package com.example.mongo.update.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
@EnableMongoRepositories("com.example.mongo.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {

       private String host;
       private String port;
       private String username;
       private String password;
       @Value("${spring.data.mongodb.authentication-database}")
       private String db;

       public String getHost() {
              return host;
       }

       public void setHost(String host) {
              this.host = host;
       }

       public String getPort() {
              return port;
       }

       public void setPort(String port) {
              this.port = port;
       }

       public String getUsername() {
              return username;
       }

       public void setUsername(String username) {
              this.username = username;
       }

       public String getPassword() {
              return password;
       }

       public void setPassword(String password) {
              this.password = password;
       }

       public String getDb() {
              return db;
       }

       public void setDb(String db) {
              this.db = db;
       }


       @Override
       public MongoMappingContext mongoMappingContext()
               throws ClassNotFoundException {
              // TODO Auto-generated method stub
              return super.mongoMappingContext();
       }

       @Override
       @Bean
       public Mongo mongo() throws Exception {
              System.out.println("mongo host: " + host);
              System.out.println("mongo db: " + db);

              MongoCredential credential = MongoCredential.createCredential(username, db, password.toCharArray());
              ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));

              return new MongoClient(serverAddress, new ArrayList<MongoCredential>() {{
                     add(credential);
              }});
       }

       @Override
       protected String getDatabaseName() {
              // TODO Auto-generated method stub
              return db;
       }

       @Bean
       public MongoTemplate mongoTemplate() throws Exception {
              //remove _class
              MappingMongoConverter converter = mappingMongoConverter();
              converter.setTypeMapper(new DefaultMongoTypeMapper(null));

              MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);

              return mongoTemplate;
       }
}