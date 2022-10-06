package com.lidiano.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidiano.os.domain.Cliente;
import com.lidiano.os.domain.OS;
import com.lidiano.os.domain.Tecnico;
import com.lidiano.os.domain.enuns.Prioridade;
import com.lidiano.os.domain.enuns.Status;
import com.lidiano.os.repositories.ClienteRepository;
import com.lidiano.os.repositories.OSRepository;
import com.lidiano.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	OSRepository osRepository;

	public void instaciaDB() {
		Tecnico t1 = new Tecnico(null, "Lidiano Wagner", "032.033.151-22", "(47) 98428-4669");
		Tecnico t2 = new Tecnico(null, "Lidio Ferreira", "491.989.121-00", "(67) 98447-6253");
		Cliente c1 = new Cliente(null, "Maria Eduarda", "436.406.008-94", "(47) 98418-5774");

		OS os1 = new OS(null, Prioridade.ALTA, "Criação OS", Status.ANDAMENTO, t2, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
