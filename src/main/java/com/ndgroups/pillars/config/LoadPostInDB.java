package com.ndgroups.pillars.config;

import com.ndgroups.pillars.model.Post;
import com.ndgroups.pillars.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class LoadPostInDB implements CommandLineRunner {
    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        Post post1 = new Post("Post title 1", "Politics","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post2 = new Post("Post title 2", "Politics","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post3 = new Post("Post title 3", "entertainment","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post4 = new Post("Post title 4", "tech","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post5 = new Post("Post title 5", "entertainment","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post6 = new Post("Post title 6", "Politics","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post7 = new Post("Post title 7", "tech","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post8 = new Post("Post title 8", "Politics","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post9 = new Post("Post title 9", "tech","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post10 = new Post("Post title 10", "entertainment","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post11 = new Post("Post title 11", "Politics","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);
        Post post12 = new Post("Post title 12", "tech","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                "      cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                "      proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "      Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                "      tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                "      quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                "      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse", "Ken Idoko",
                "img cover", false);

        List<Post> postList = Arrays.asList(post1, post2, post3, post4, post5, post6, post7, post8, post9, post10,
                post11, post12);
        postList = postList.stream().collect(Collectors.toList());

        postRepository.saveAll(postList);

    }
}
