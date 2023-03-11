package fpt.asignment.estate_trading_system.post.service;

import fpt.asignment.estate_trading_system.common.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    public List<Post> getPosts();

    public ResponseEntity<List<Post>> findPostAdWithPagination(int page, int perPage, int area);
}
