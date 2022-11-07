package com.kaiburr.restapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServerDAO extends MongoRepository<Server, String> {
    List<Server> findAll();
    List<Server> findServerByName(String name);
    Server findServerById(String id);
    void removeById(String id);
    Server insert(Server server);
}
