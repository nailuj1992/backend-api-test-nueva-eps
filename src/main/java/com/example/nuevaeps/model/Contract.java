package com.example.nuevaeps.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contracts")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contract")
	private long idContract;

	@Column(name = "modality", nullable = false, length = 50)
	private String modality;

	@Column(name = "consecutive_number", nullable = false)
	private long consecutiveNumber;

	@Column(name = "regimen", nullable = false, length = 50)
	private String regimen;

	@OneToOne
	@JoinColumn(name = "id_file", nullable = false)
	private FileDB file;

	@Column(name = "creation_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp creationDate;

	public long getIdContract() {
		return idContract;
	}

	public void setIdContract(long idContract) {
		this.idContract = idContract;
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

	public FileDB getFile() {
		return file;
	}

	public void setFile(FileDB file) {
		this.file = file;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}
