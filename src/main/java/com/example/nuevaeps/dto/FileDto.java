package com.example.nuevaeps.dto;

import java.io.Serializable;

import org.springframework.core.io.ByteArrayResource;

public class FileDto implements Serializable {

	private static final long serialVersionUID = 5018257607251517031L;

	private long id;
	private String name;
	private String type;
	private String data;
	private ByteArrayResource bytes;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ByteArrayResource getBytes() {
		return bytes;
	}

	public void setBytes(ByteArrayResource bytes) {
		this.bytes = bytes;
	}

}
