package com.martinso.votingapp.post.service;

import com.martinso.votingapp.post.data.model.Post;
import com.martinso.votingapp.post.data.repository.PostRepository;
import com.martinso.votingapp.post.dto.request.PostRequest;
import com.martinso.votingapp.post.dto.response.PostResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService{

    private final PostRepository repository;

    @Autowired
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostResponse createPost(PostRequest request) {
        Post post = Post.builder()
                .runningPost(request.getRunningPost())
                .contestant(request.getContestant())
                .election(request.getElection())
                .build();
        Post saved = repository.save(post);
        log.info("saved->{}", saved.getRunningPost());
        return getPostResponse(saved);
    }

    @Override
    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    private PostResponse getPostResponse(Post post){
        return PostResponse
                .builder()
                .id(post.getId())
                .code(HttpStatus.CREATED.value())
                .isSuccess(true)
                .message("Post successful created").build();
    }
}
