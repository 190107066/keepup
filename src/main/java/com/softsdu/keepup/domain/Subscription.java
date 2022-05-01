package com.softsdu.keepup.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private SubscriptionStatus status;
    private Date paymentDue;
    private String title;

    public Subscription(SubscriptionStatus status, Date paymentDue, String title) {
        this.status = status;
        this.paymentDue = paymentDue;
        this.title = title;
    }

    public Subscription(Date paymentDue, String title) {
        this.paymentDue = paymentDue;
        this.title = title;
    }

    public Subscription() {
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", status=" + status +
                ", paymentDue=" + paymentDue +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public Date getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(Date paymentDue) {
        this.paymentDue = paymentDue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
