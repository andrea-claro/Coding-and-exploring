package com.example.repository;

import com.example.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findFirstByOrderByPostedOnDesc();
    List<Post> findAllByOrderByPostedOnDesc();
    Post findBySlug(String slug);
}
