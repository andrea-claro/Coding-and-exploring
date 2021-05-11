package com.example.controller;

import com.example.domain.Post;
import com.example.exception.PostNotFoundException;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Post> list(){
        return postService.list();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Post create(@RequestBody Post post){
        return postService.create(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post read(@PathVariable(value = "id") long id) throws PostNotFoundException{
        Post post = postService.read(id);
        if(post == null)
            throw new PostNotFoundException("Post with id: "+id+" not found");
        return postService.read(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Post update(@PathVariable(value = "id") long id, @RequestBody Post post){
        return postService.update(id, post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id){
        postService.delete(id);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public void handlePostNotFound(PostNotFoundException e, HttpServletResponse response){
        try {
            response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
