# Kaiburr
This is a spring boot based rest API which uses mongodb as its database. It stores and retrives Server objects as JSON objects.
It has 4 endpoints

## Code snippets
1) GET
 ```
 @GetMapping(path = "/")
    public ResponseEntity<List<Server>> getServer()
    {
        return serv.getServer();
    }
 ```   
 This GET request returns all Server objects if no parameters are passed. When a server id is passed as a parameter it will return a single server or a 404 response if there’s no such a server.
 ![image](https://user-images.githubusercontent.com/106380338/200357393-41a7183e-4c91-4a3b-931c-dc1719099cdd.png)
 ![image](https://user-images.githubusercontent.com/106380338/200357556-616e91e2-a13e-4cce-b0d3-651016054a1d.png)
 ![image](https://user-images.githubusercontent.com/106380338/200357615-2b095eb8-4f55-4970-a274-8baffbf18562.png)
 
 2) GET{name}
 ```
 @GetMapping(path = "/{id}")
    public ResponseEntity<Server> getServer(@PathVariable String id)
    {
        return serv.getServer(id);
    }
 ```
 This GET requests retrive all the servers whose names matches the String passed in the parameter. If no object is found it will return a 404 response.
 
 ![image](https://user-images.githubusercontent.com/106380338/200357901-aeab9d8f-142b-4bb1-b912-c463ba6d19b2.png)
 ![image](https://user-images.githubusercontent.com/106380338/200357961-bdf82cd1-9e8f-40a6-8fc6-d7fc700fd027.png)

 
 3) DELETE
 ```
 @DeleteMapping(path = "/{id}")
    public ResponseEntity<Server> deleteServer(@PathVariable String id)
    {
        return serv.deleteServer(id);
    }
 ```
 This DELETE request will delete a server whose ID is passed as parameter
 
 ![image](https://user-images.githubusercontent.com/106380338/200358076-f28f339e-8b30-4dfe-8d40-f9ab82e22046.png)

 
 4) PUT
 ```
  @PutMapping (path = "/")
    public ResponseEntity<Server> insertServer(@RequestBody Server se)
    {
        return serv.addServer(se);
    }
 ```
 This PUT request will accept a JSON object in the body and will insert it into the database as a document.
 
 ![image](https://user-images.githubusercontent.com/106380338/200358516-f5df46bd-effe-4b4a-aef0-6882a677503f.png)

 
 ## Document Structure
 ```
 @Indexed(unique = true)
    private String name;
    @Id
    private String id;
    private String language;
    private String framework;
 ```
 
 
