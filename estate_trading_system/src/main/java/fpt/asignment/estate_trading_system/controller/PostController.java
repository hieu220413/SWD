package fpt.asignment.estate_trading_system.controller;

import fpt.asignment.estate_trading_system.entity.Post;
import fpt.asignment.estate_trading_system.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("")
    public List<Post> getPosts(){
        return service.getPosts();
    }
}
