package org.example.__spring_9_restclient;

import org.example.__spring_9_restclient.dto.PostDto;
import org.example.__spring_9_restclient.model.Post;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostsService {
    private final RestClient restClient;

    public PostsService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com/posts")
                .build();
    }

    public List<Post> getAllPosts(){
        Post[] posts = restClient
                .get()
                .retrieve()
                .body(Post[].class);
        return posts == null ? List.of() : List.of(posts);
    }

    public Post postPost(PostDto postDto){
        return restClient
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(postDto)
                .retrieve()
                .body(Post.class);
    }
}
