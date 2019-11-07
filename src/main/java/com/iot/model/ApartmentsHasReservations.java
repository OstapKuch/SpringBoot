package com.iot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "appartments_has_appartments_reservations")
public class ApartmentsHasReservations implements Serializable {
    @Id
    @Column(name = "appartments_reservations_id")
    private Integer id;
    @Column(name = "appartments_id")
    private Integer apartmentsId;
    @Column(name = "buyers_id")
    private Integer buyersId;
    @Column(name = "billings_id")
    private Integer billingsId;
    @Column(name = "airbnb_wallet_id")
    private Integer airbnbWalletId;


    public ApartmentsHasReservations() {
    }

    public ApartmentsHasReservations(Integer id, Integer apartmentsId, Integer buyersId, Integer billingsId, Integer airbnbWalletId) {
        this.id = id;
        this.apartmentsId = apartmentsId;
        this.buyersId = buyersId;
        this.billingsId = billingsId;
        this.airbnbWalletId = airbnbWalletId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentsId() {
        return apartmentsId;
    }

    public void setApartmentsId(Integer apartmentsId) {
        this.apartmentsId = apartmentsId;
    }

    public Integer getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(Integer buyersId) {
        this.buyersId = buyersId;
    }

    public Integer getBillingsId() {
        return billingsId;
    }

    public void setBillingsId(Integer billingsId) {
        this.billingsId = billingsId;
    }

    public Integer getAirbnbWalletId() {
        return airbnbWalletId;
    }

    public void setAirbnbWalletId(Integer airbnbWalletId) {
        this.airbnbWalletId = airbnbWalletId;
    }

    @Override
    public String toString() {
        return "ApartmentsHasReservationsEntity{"
                + "id=" + id
                + ", apartmentsId=" + apartmentsId
                + ", buyersId=" + buyersId
                + ", billingsId=" + billingsId
                + ", airbnbWalletId=" + airbnbWalletId
                + '}';
    }
}
