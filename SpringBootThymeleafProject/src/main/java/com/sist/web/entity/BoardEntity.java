package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 *  no
	name
	varchar(51)
	subject
	varchar(2000)
	content
	text
	pwd
	varchar(10)
	regdate
	datetime
	hit
 */
@Entity
@Table(name = "board")
@Getter
@Setter
public class BoardEntity {
	@Id
	private int no;
	private int hit;
	private String name,subject,content;
	
	@Column(insertable = true, updatable = false)
	private String pwd;
	@Column(insertable = true , updatable = false)
	private String regdate;
	
	@PrePersist
	public void regdate() {
		this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
}
