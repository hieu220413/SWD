package fpt.asignment.estate_trading_system.post.service.impl;

import fpt.asignment.estate_trading_system.common.entity.Post;
import fpt.asignment.estate_trading_system.common.repository.PostRepository;
import fpt.asignment.estate_trading_system.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository repository;

    @Override
    public ResponseEntity<List<Post>> findPostAdWithPagination(int page, int perPage, int area) {
        Pageable pageable = PageRequest.of(page, perPage);
        List<Post> postList = repository.findPostAdWithPagination(area, pageable);
        for (Post post : postList) {
            post.getUsers().setPassword("");
            post.getUsers().setUsername("");
        }
        return ResponseEntity.status(HttpStatus.OK.value()).body(postList);
    }

    public List<Post> getPosts(){
        return repository.findAll();
    }
}

