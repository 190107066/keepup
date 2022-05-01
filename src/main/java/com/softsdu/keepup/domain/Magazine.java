package com.softsdu.keepup.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="magazine")
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ISBN;
    private Date createdDate;

    private MagazineStatus status;

    public Magazine() {
    }

    public Magazine(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
        this.status = MagazineStatus.AVAILABLE;
        this.createdDate = new Date();
    }

    public Magazine(String name, String ISBN, MagazineStatus status) {
        this.name = name;
        this.ISBN = ISBN;
        this.status = status;
        this.createdDate = new Date();
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", createdDate=" + createdDate +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public MagazineStatus getStatus() {
        return status;
    }

    public void setStatus(MagazineStatus status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
