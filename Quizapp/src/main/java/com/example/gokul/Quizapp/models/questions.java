package com.example.gokul.Quizapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "questions")
@ToString
public class questions {
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getOptiona() {
		return optiona;
	}
	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}
	public String getOptionb() {
		return optionb;
	}
	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}
	public String getOptionc() {
		return optionc;
	}
	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCrctans() {
		return crctans;
	}
	public void setCrctans(String crctans) {
		this.crctans = crctans;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Integer id;

private String level;
@Column(name="option_a")
private String optiona;
@Column(name="option_b")
private String optionb;
@Column(name="option_c")
private String optionc;
private String title;
private String crctans;
private String category;
private Integer code;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}

}
