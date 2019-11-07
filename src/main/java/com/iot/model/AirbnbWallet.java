package com.iot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "airbnb_wallet")
public class AirbnbWallet implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    @Id
    private Integer id;
    @Column(name = "money")
    private Integer money;
    public AirbnbWallet() {
    }

    public AirbnbWallet(Integer id, Integer money) {
        this.id = id;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "airbnb_wallet "
                + "id=" + id
                + ", money=" + money;
    }
}
