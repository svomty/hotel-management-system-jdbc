package com.svintsitski.hotelmanagementsystemjdbc.model;

import java.util.Objects;

public class Review {
    private Integer id;
    private Integer user_id;
    private String text;
    private Integer mark;

    public Review() {
    }

    public Review(Integer id, Integer user_id, String text, Integer mark) {
        this.id = id;
        this.user_id = user_id;
        this.text = text;
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) &&
                Objects.equals(user_id, review.user_id) &&
                Objects.equals(text, review.text) &&
                Objects.equals(mark, review.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, text, mark);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }
}
