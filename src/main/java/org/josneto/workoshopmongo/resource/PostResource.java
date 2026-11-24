package org.josneto.workoshopmongo.resource;

import org.josneto.workoshopmongo.domain.Post;
import org.josneto.workoshopmongo.resource.util.URL;
import org.josneto.workoshopmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = services.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
