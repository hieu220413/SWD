package fpt.asignment.estate_trading_system.service;

import fpt.asignment.estate_trading_system.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    public List<Post> getPosts();

    public ResponseEntity<List<Post>> findPostAdWithPagination(int limit, int offset, int area);
}
