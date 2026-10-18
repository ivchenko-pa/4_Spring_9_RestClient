package org.example.__spring_9_restclient.controller;

import lombok.AllArgsConstructor;
import org.example.__spring_9_restclient.PostsService;
import org.example.__spring_9_restclient.dto.PostDto;
import org.example.__spring_9_restclient.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping
    public List<Post> getAllPosts(){
        return postsService.getAllPosts();
    }

    @PostMapping
    public Post postPost(@RequestBody PostDto postDto){
        return postsService.postPost(postDto);
    }
}
