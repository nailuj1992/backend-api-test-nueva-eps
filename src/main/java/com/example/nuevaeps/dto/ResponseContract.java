package com.example.nuevaeps.dto;

import java.io.Serializable;

import org.springframework.data.domain.Page;

public class ResponseContract implements Serializable {

	private static final long serialVersionUID = 5765474361633547161L;

	private int code;
	private String description;
	private Page<ContractDto> contracts;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Page<ContractDto> getContracts() {
		return contracts;
	}

	public void setContracts(Page<ContractDto> contracts) {
		this.contracts = contracts;
	}

}
