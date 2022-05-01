package com.softsdu.keepup.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "issued_book")
public class IssuedBook implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "magazine_id")
	private Magazine magazine;

	@ManyToOne
	@JoinColumn(name = "issue_id")
	private Issue issue;
	
	@Column(name = "returned")
	private ReturnedStatus returned;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setBook(Magazine magazine) {
		this.magazine = magazine;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public ReturnedStatus getReturned() {
		return returned;
	}

	public void setReturned(ReturnedStatus returned) {
		this.returned = returned;
	}

}
