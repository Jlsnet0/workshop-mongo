package org.josneto.workoshopmongo.repository;

import org.josneto.workoshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
