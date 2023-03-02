package fpt.asignment.estate_trading_system.service.impl;

import fpt.asignment.estate_trading_system.entity.Post;
import fpt.asignment.estate_trading_system.repository.PostRepository;
import fpt.asignment.estate_trading_system.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

