package mainServer.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mainServer.controller.*;
// import mainServer.models.*;

@Path("/")

public class Server{

    
@Path("/getfile")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getTestService(@QueryParam("directoryPath")String directoryPath,@QueryParam("keyword")String keyword) {
    return Response.ok(200).entity(new GetFiles().getAllFiles(directoryPath,keyword )).header("Access-Control-Allow-Origin", "*").build() ;
}

}