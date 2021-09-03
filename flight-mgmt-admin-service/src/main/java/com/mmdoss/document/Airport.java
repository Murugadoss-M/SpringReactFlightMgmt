package com.mmdoss.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Airport")
public class Airport {
	@Id
	private String id;
	private String city;

	public Airport() {

	}

	public Airport(String id, String city) {
		super();
		this.id = id;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return String.format("Airport [id=%s, city=%s]", id, city);
	}

}
