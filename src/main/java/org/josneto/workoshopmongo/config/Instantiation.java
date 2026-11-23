package org.josneto.workoshopmongo.config;

import org.josneto.workoshopmongo.domain.Post;
import org.josneto.workoshopmongo.domain.User;
import org.josneto.workoshopmongo.repository.PostRepository;
import org.josneto.workoshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        DateTimeFormatter dtf = DateTimeFormatter
                                .ofPattern("dd/MM/yyyy")
                                .withZone(ZoneId.of("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post p1 = new Post(null, LocalDate.parse("21/03/2026", dtf), "Partiu viagem", "Vou viajar para João Pessoa, abraços", maria);
        Post p2 = new Post(null, LocalDate.parse("23/03/2026", dtf), "Bom dia", "Acordei feliz hoje", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(p1, p2));
    }
}
