package com.example.nuevaeps.dto;

import java.io.Serializable;
import java.util.Date;

public class ContractDto implements Serializable {

	private static final long serialVersionUID = 5443343646536373904L;

	private long id;
	private String modality;
	private long consecutiveNumber;
	private String regimen;
	private Date creationDate;
	private FileDto file;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public long getConsecutiveNumber() {
		return consecutiveNumber;
	}

	public void setConsecutiveNumber(long consecutiveNumber) {
		this.consecutiveNumber = consecutiveNumber;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public FileDto getFile() {
		return file;
	}

	public void setFile(FileDto file) {
		this.file = file;
	}

}
