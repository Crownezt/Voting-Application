package com.martinso.votingapp.contollers;

import com.martinso.votingapp.post.dto.request.PostRequest;
import com.martinso.votingapp.post.dto.response.PostResponse;
import com.martinso.votingapp.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(PostRequest request){
        PostResponse response = service.createPost(request);
        return ResponseEntity.ok().body(response);
    }
}
