package com.kaiburr.restapi;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/server")
@AllArgsConstructor
public class ServerController {
    @Autowired
    private ServerService serv;

    @GetMapping(path = "/")
    public ResponseEntity<List<Server>> getServer()
    {
        return serv.getServer();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Server> getServer(@PathVariable String id)
    {
        return serv.getServer(id);
    }

    @GetMapping(path = "/find/{name}")
    public ResponseEntity<List<Server>> findServer(@PathVariable String name)
    {
        return serv.findServer(name);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Server> deleteServer(@PathVariable String id)
    {
        return serv.deleteServer(id);
    }

    @PutMapping (path = "/")
    public ResponseEntity<Server> insertServer(@RequestBody Server se)
    {
        return serv.addServer(se);
    }
}
