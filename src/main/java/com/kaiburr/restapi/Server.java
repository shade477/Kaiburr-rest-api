package com.kaiburr.restapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "server")
@AllArgsConstructor
public class Server {
    @Indexed(unique = true)
    private String name;
    @Id
    private String id;
    private String language;
    private String framework;


}