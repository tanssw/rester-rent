package com.example.backend.pojo.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Document("payments")
public class Payments {
    @Id
    private String _id;
    private LocalDateTime date_time;
    private int amount;
    private String email;
    private boolean status;

    public Payments() {
    }

    public Payments(LocalDateTime date_time, int amount, String email, boolean status) {
        this.date_time = date_time;
        this.amount = amount;
        this.email = email;
        this.status = status;
    }

    public Payments(String _id, LocalDateTime date_time, int amount, String email, boolean status) {
        this._id = _id;
        this.date_time = date_time;
        this.amount = amount;
        this.email = email;
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
