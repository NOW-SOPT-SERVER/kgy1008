package org.sopt.week3.domain;

import org.sopt.week3.service.dto.PostCreateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    public Post(String name, String content, Blog blog) {
        this.name = name;
        this.content = content;
        this.blog = blog;
    }

    public static Post create(Blog blog, PostCreateRequest postCreateRequest) {
        return new Post(postCreateRequest.name(), postCreateRequest.content(), blog);
    }
}
