package org.josneto.workoshopmongo.services;

import org.josneto.workoshopmongo.domain.Post;
import org.josneto.workoshopmongo.repository.PostRepository;
import org.josneto.workoshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String title){
        return repository.findByTitleContainingIgnoreCase(title);
    }
}
