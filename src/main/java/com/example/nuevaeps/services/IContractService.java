package com.example.nuevaeps.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.nuevaeps.dto.ContractDto;
import com.example.nuevaeps.dto.FileDto;

public interface IContractService {

	public void createContract(ContractDto contract) throws Exception;

	public Page<ContractDto> getContracts(Pageable pageable) throws Exception;

	public FileDto downloadFile(int idFile) throws Exception;

}
