package com.example.backend.pojo.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document("payments")
public class Payments {
    @Id
    private String _id;
    private String no;
    private String date_time;
    private String proof_of_payment;
    private boolean status;

    public Payments() {
    }

    public Payments(String no, String date_time, String proof_of_payment, boolean status) {
        this.no = no;
        this.date_time = date_time;
        this.proof_of_payment = proof_of_payment;
        this.status = status;
    }

    public Payments(String _id, String no, String date_time, String proof_of_payment, boolean status) {
        this._id = _id;
        this.no = no;
        this.date_time = date_time;
        this.proof_of_payment = proof_of_payment;
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getProof_of_payment() {
        return proof_of_payment;
    }

    public void setProof_of_payment(String proof_of_payment) {
        this.proof_of_payment = proof_of_payment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
