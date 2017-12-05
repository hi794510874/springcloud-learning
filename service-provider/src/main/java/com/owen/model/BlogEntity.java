package com.owen.model;

import java.io.Serializable;

/**
 * Created by huang_b on 2017/9/4.
 */
public class BlogEntity implements Serializable {
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    private String Id;
    private String Content;
    private String Title;
}
