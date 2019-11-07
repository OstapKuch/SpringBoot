package com.iot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "appartments")
public class Apartments implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appertment_id")
    @Id
    private Integer id;
    @Column(name = "seller_id")
    private Integer sellerId;
    @Column(name = "rooms_number")
    private Integer roomsNumber;
    @Column(name = "beds_number")
    private Integer bedsNumber;
    @Column(name = "hour_price", length = 45)
    private Integer hourPrice;
    @Column(name = "adress", length = 45)
    private String address;

    public Apartments() {
    }

    public Apartments(Integer id, Integer sellerId, Integer roomsNumber, Integer bedsNumber, Integer hourPrice, String address) {
        this.id = id;
        this.sellerId = sellerId;
        this.roomsNumber = roomsNumber;
        this.bedsNumber = bedsNumber;
        this.hourPrice = hourPrice;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(Integer roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public Integer getBedsNumber() {
        return bedsNumber;
    }

    public void setBedsNumber(Integer bedsNumber) {
        this.bedsNumber = bedsNumber;
    }

    public Integer getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(Integer hourPrice) {
        this.hourPrice = hourPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ApartmentsEntity{"
                + "id=" + id
                + ", sellerId=" + sellerId
                + ", roomsNumber=" + roomsNumber
                + ", bedsNumber=" + bedsNumber
                + ", hourPrice='" + hourPrice + '\''
                + ", address='" + address + '\''
                + '}';
    }
}
