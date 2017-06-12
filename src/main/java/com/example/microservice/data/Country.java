package com.example.microservice.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "country")
public class Country {

	@Id
	private String id;
	private String code;
	private String name;
	
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
}
