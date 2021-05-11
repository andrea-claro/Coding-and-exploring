package com.example.service;

import com.example.domain.Post;
import org.springframework.stereotype.Service;

public interface PostService {
    Iterable<Post> list();
    Post create(Post post);
    Post read(long id);
    Post update(long id, Post post);
    void delete(long id);
}
