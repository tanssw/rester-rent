package com.example.backend.pojo.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document("orders")
public class Orders {
    @Id
    private String _id;
    private String fullname;
    private String mail;
    private String start_date;
    private String end_date;
    private int income;
    private String status = "รอการดำเนินการ";
    private Object details;

    public Orders() {
    }

    public Orders(String fullname, String mail, String start_date, String end_date, int income, Object details) {
        this.fullname = fullname;
        this.mail = mail;
        this.start_date = start_date;
        this.end_date = end_date;
        this.income = income;
        this.details = details;
    }

    public Orders(String _id, String fullname, String mail, String start_date, String end_date, int income, String status, Object details) {
        this._id = _id;
        this.fullname = fullname;
        this.mail = mail;
        this.start_date = start_date;
        this.end_date = end_date;
        this.income = income;
        this.status = status;
        this.details = details;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }
}
