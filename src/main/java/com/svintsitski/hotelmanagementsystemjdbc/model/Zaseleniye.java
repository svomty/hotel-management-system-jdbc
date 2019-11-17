package com.svintsitski.hotelmanagementsystemjdbc.model;

import java.util.Date;
import java.util.Objects;

public class Zaseleniye {
    private Integer id;
    private Date start_date;
    private Date final_date;
    private Integer user_id;
    private Integer room;
    private String iteration_type;

    public Zaseleniye() {
    }

    public Zaseleniye(Integer id, Date start_date, Date final_date, Integer user_id, Integer room,
                      String iteration_type) {
        this.id = id;
        this.start_date = start_date;
        this.final_date = final_date;
        this.user_id = user_id;
        this.room = room;
        this.iteration_type = iteration_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinal_date() {
        return final_date;
    }

    public void setFinal_date(Date final_date) {
        this.final_date = final_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getIteration_type() {
        return iteration_type;
    }

    public void setIteration_type(String iteration_type) {
        this.iteration_type = iteration_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zaseleniye that = (Zaseleniye) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(start_date, that.start_date) &&
                Objects.equals(final_date, that.final_date) &&
                Objects.equals(user_id, that.user_id) &&
                Objects.equals(room, that.room) &&
                Objects.equals(iteration_type, that.iteration_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_date, final_date, user_id, room, iteration_type);
    }

    @Override
    public String toString() {
        return "Zaseleniye{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", final_date=" + final_date +
                ", user_id=" + user_id +
                ", room=" + room +
                ", iteration_type='" + iteration_type + '\'' +
                '}';
    }
}
