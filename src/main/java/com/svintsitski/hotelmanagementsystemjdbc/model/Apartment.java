package com.svintsitski.hotelmanagementsystemjdbc.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Apartment {
    private Integer id;
    private Integer userCells;
    private Integer roomCells;
    private BigDecimal price;

    public Apartment(Integer id, Integer userCells, Integer roomCells, BigDecimal price) {
        this.id = id;
        this.userCells = userCells;
        this.roomCells = roomCells;
        this.price = price;
    }

    public Apartment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserCells() {
        return userCells;
    }

    public void setUserCells(Integer userCells) {
        this.userCells = userCells;
    }

    public Integer getRoomCells() {
        return roomCells;
    }

    public void setRoomCells(Integer roomCells) {
        this.roomCells = roomCells;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return Objects.equals(id, apartment.id) &&
                Objects.equals(userCells, apartment.userCells) &&
                Objects.equals(roomCells, apartment.roomCells) &&
                Objects.equals(price, apartment.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userCells, roomCells, price);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", userCells=" + userCells +
                ", roomCells=" + roomCells +
                ", price=" + price +
                '}';
    }
}
