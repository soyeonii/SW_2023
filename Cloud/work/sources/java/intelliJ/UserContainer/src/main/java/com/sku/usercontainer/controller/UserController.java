package com.sku.usercontainer.controller;

import com.google.gson.JsonObject;
import com.sku.usercontainer.model.UserDTO;
import com.sku.usercontainer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("auth")
    public String auth(@RequestBody UserDTO attempt) {
        UserDTO result = userService.auth(attempt);
        JsonObject resultJson = new JsonObject();
        if (result != null) {
            resultJson.addProperty("result", "success");
            resultJson.addProperty("userId", result.getId());
        } else {
            resultJson.addProperty("result", "fail");
        }
        return resultJson.toString();
    }

    @PostMapping("register")
    public String register(@RequestBody UserDTO attempt){
        JsonObject object = new JsonObject();
        if(userService.validateUsername(attempt.getUsername())){
            userService.register(attempt);
            object.addProperty("result", "success");
        }else{
            object.addProperty("result", "fail");
            object.addProperty("message", "Duplicated Username");
        }
        return object.toString();
    }
}
