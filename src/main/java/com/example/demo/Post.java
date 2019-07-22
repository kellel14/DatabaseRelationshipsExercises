package com.example.demo;

import javax.persistence.*;

@Entity(name = "Post")
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PostDetails details;

    //Getters and Setters omitted for brevity

    public void setDetails(PostDetails details) {
        if (details == null) {
            if (this.details != null) {
                this.details.setPost(null);
            }
        } else {
            details.setPost(this);
        }
        this.details = details;
    }
}
