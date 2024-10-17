package com.example.nuevaeps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nuevaeps.dto.ContractDto;
import com.example.nuevaeps.dto.FileDto;
import com.example.nuevaeps.dto.ResponseContract;
import com.example.nuevaeps.services.IContractService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	private IContractService contractService;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, World!";
	}

	@PostMapping("/create-contract")
	public ResponseEntity<ResponseContract> createContract(@RequestBody ContractDto contract) {
		try {
			contractService.createContract(contract);

			ResponseContract response = new ResponseContract();
			response.setCode(HttpStatus.OK.value());
			response.setDescription("Contract created successfully");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			ResponseContract response = new ResponseContract();
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDescription("Could not create the contract: " + ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-contracts")
	public ResponseEntity<ResponseContract> getContracts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		try {
			Pageable pageable = PageRequest.of(page, size);
			Page<ContractDto> contracts = contractService.getContracts(pageable);

			ResponseContract response = new ResponseContract();
			response.setCode(HttpStatus.OK.value());
			response.setDescription("Contracts consulted successfully");
			response.setContracts(contracts);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			ResponseContract response = new ResponseContract();
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDescription("Could not get contracts: " + ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/download-contract/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable int id) {
		try {
			FileDto file = contractService.downloadFile(id);

			HttpHeaders header = new HttpHeaders();
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
			header.add("Cache-Control", "no-cache, no-store, must-revalidate");
			header.add("Pragma", "no-cache");
			header.add("Expires", "0");

			return ResponseEntity.ok().headers(header).contentLength(file.getBytes().getContentAsByteArray().length)
					.contentType(MediaType.parseMediaType("application/octet-stream")).body(file.getBytes());
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
