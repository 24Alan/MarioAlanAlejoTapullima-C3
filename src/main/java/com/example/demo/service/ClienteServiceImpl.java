package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.dto.ClienteRequestDTO;
import com.example.demo.dto.ClienteResponseDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;



public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;
	@Override
	public void guardarCliente(ClienteRequestDTO p) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setCelular(p.getCelularCliente());
		cliente.setCliente(p.getNombreCliente());
		cliente.setIdCliente(p.getIdCliente());
		repository.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarCliente(ClienteRequestDTO p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		// TODO Auto-generated method stub
		List<Cliente> cliente = repository.findAll();
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDTO = null;
		
		for (Cliente c : cliente) {
			clienteDTO = new ClienteResponseDTO();
			clienteDTO.setIdCliente(c.getIdCliente());
			clienteDTO.setCelularCliente(c.getCelular());
			clienteDTO.setNombreCliente(c.getCliente());
			dto.add(clienteDTO);
		}
		
		return dto;
	}

	@Override
	public ClienteResponseDTO clienteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
