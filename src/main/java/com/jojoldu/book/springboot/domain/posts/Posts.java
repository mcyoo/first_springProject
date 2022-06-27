package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Column(length = 500, nullable = true)
    private String picture;


    @Builder
    public Posts(String title, String content, String author,String picture) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.picture = picture;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
