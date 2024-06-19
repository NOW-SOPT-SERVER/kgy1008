package org.sopt.week6.service.dto;

import org.sopt.week6.domain.Post;

public record PostFindDto(
        String name,
        String content
) {
    public static PostFindDto of(Post post) {
        return new PostFindDto(post.getName(), post.getContent());
    }
}
