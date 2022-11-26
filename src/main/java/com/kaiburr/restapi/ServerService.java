package com.kaiburr.restapi;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServerService{
    @Autowired
    private ServerDAO repo;
    public ResponseEntity<List<Server>> getServer()
    {
        List<Server> s = repo.findAll();
        if (s.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(s));
    }

    public ResponseEntity<Server> getServer(String id)
    {
        Server s = repo.findServerById(id);
        if(s==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(s));
    }

    public ResponseEntity<List<Server>> findServer(String name)
    {
        List<Server> s = repo.findServerByName(name);
        if(s.size()==0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(s));
    }

    public ResponseEntity<Server> deleteServer(String id)
    {
        repo.removeById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Server> addServer(Server server)
    {
        repo.insert(server);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
