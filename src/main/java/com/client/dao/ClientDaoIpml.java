package com.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.client.model.Client;

@Repository
@Transactional
public class ClientDaoIpml extends genericDaoImpl<Client, Long> implements ClientDao  {

	

	public ClientDaoIpml() {
		super(Client.class);
	}

	@Override
	public List<Client> getAll() {
		return super.getAll();
	}
	
	@Override
	public Client findClientById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Client addClient(Client client) {
		return super.save(client);
	}

	@Override
	public Client updateClient(Client client) {
		return super.saveOrUpdate(client);
	}

	@Override
	public Client deleteClient(Client client) {
		return super.remove(client);
	}

	@Override
	public Client saveOrupdateClient(Client client) {
		return super.saveOrUpdate(client);
	}
	
	

}
