package com.example.nuevaeps.services;

import java.util.Base64;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.nuevaeps.dto.ContractDto;
import com.example.nuevaeps.dto.FileDto;
import com.example.nuevaeps.model.Contract;
import com.example.nuevaeps.model.FileDB;
import com.example.nuevaeps.repository.ContractRepository;
import com.example.nuevaeps.repository.FileDBRepository;

@Service
public class ContractService implements IContractService {

	@Autowired
	private FileDBRepository fileDBRepository;

	@Autowired
	private ContractRepository contractRepository;

	@Override
	public void createContract(ContractDto contract) throws Exception {
		Contract contractDB = new Contract();
		contractDB.setConsecutiveNumber(contract.getConsecutiveNumber());
		contractDB.setModality(contract.getModality());
		contractDB.setRegimen(contract.getRegimen());

		FileDto file = contract.getFile();
		if (file != null) {
			FileDB fileDB = new FileDB();

			fileDB.setName(file.getName());
			fileDB.setType(file.getType());
			fileDB.setData(Base64.getDecoder().decode(file.getData()));

			fileDB = fileDBRepository.save(fileDB);

			contractDB.setFile(fileDB);
		}

		contractDB = contractRepository.save(contractDB);
	}

	@Override
	public Page<ContractDto> getContracts(Pageable pageable) throws Exception {
		Page<Contract> contracts = contractRepository.findAll(pageable);
		if (contracts == null) {
			return null;
		}
		Page<ContractDto> response = contracts.map(new Function<Contract, ContractDto>() {
			@Override
			public ContractDto apply(Contract contract) {
				ContractDto item = new ContractDto();

				item.setId(contract.getIdContract());
				item.setConsecutiveNumber(contract.getConsecutiveNumber());
				item.setModality(contract.getModality());
				item.setRegimen(contract.getRegimen());
				item.setCreationDate(contract.getCreationDate());

				FileDB fileDB = contract.getFile();
				if (fileDB != null) {
					FileDto file = new FileDto();

					file.setId(fileDB.getId());
					file.setName(fileDB.getName());
					file.setType(fileDB.getType());

					item.setFile(file);
				}

				return item;
			}
		});

		return response;
	}

	@Override
	public FileDto downloadFile(int idFile) throws Exception {
		Optional<FileDB> fileOpt = fileDBRepository.findById(idFile);
		if (!fileOpt.isPresent()) {
			throw new Exception("There is no file with ID " + idFile);
		}
		FileDB file = fileOpt.get();
		FileDto resp = new FileDto();
		resp.setId(file.getId());
		resp.setName(file.getName());
		resp.setType(file.getType());
		resp.setData(Base64.getEncoder().encodeToString(file.getData()));
		resp.setBytes(new ByteArrayResource(file.getData()));
		return resp;
	}

}
