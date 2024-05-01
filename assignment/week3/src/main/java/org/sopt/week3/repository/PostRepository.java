package org.sopt.week3.repository;

import org.sopt.week3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByBlogId(Long blogId);
}
