package home.pb.spring.springboot.rest;


import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
@Component
public class UserResource {

    @GET
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Map<String,Object> getUser(){
        Map<String,Object> map = new HashMap<String,Object>();

        map.put("id","1000");
        map.put("name","张三");
        map.put("age","25");

        return map;
    }

}
