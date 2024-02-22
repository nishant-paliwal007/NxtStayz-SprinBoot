package com.example.nxtstayz.model;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @Column(name = "roomnumber")
    private String roomName;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "hotelid")
    private Hotel hotel;

    public Room() {
    }

    public Room(int roomId, String roomName, String type, Double price, Hotel hotel) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.type = type;
        this.price = price;
        this.hotel = hotel;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomName;
    }

    public void setRoomNumber(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return type;
    }

    public void setRoomType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}