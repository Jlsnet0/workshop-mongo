package org.josneto.workoshopmongo.resource;

import org.josneto.workoshopmongo.domain.Post;
import org.josneto.workoshopmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    private final PostService services;

    public PostResource(PostService services) {
        this.services = services;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = services.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
