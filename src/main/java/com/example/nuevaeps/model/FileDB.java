package com.example.nuevaeps.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class FileDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uuid")
	private long id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "type", nullable = false, length = 255)
	private String type;

	@Lob
	@Column(name = "data", nullable = false, columnDefinition = "longblob")
	private byte[] data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
