package fpt.asignment.estate_trading_system.post.service.impl;

import fpt.asignment.estate_trading_system.common.entity.Post;
import fpt.asignment.estate_trading_system.common.repository.PostRepository;
import fpt.asignment.estate_trading_system.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository repository;

    @Override
    public ResponseEntity<List<Post>> findPostAdWithPagination(int limit, int offset, int area) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(repository.findPostAdWithPagination(area));
    }

    public List<Post> getPosts(){
        return repository.findAll();
    }
}

