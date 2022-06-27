package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostUserListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    private String content;

    private String picture;


    public PostUserListResponseDto(Posts entity, User user) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.content = entity.getContent();
        this.picture = user.getPicture();
    }
}
