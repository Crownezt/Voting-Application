package com.martinso.votingapp.post.service;

import com.martinso.votingapp.post.data.model.Post;
import com.martinso.votingapp.post.dto.request.PostRequest;
import com.martinso.votingapp.post.dto.response.PostResponse;

import java.util.List;


public interface PostService {
    PostResponse createPost (PostRequest request);
    List<Post> getAllPosts();

}
