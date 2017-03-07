package com.client.dao;

import java.util.List;

import com.client.model.Client;

public interface ClientDao  {

	public List<Client> getAll();
	
	public Client addClient(Client client);
	
	public Client updateClient(Client client);
	
	public Client saveOrupdateClient(Client client);
	
	public Client deleteClient(Client client) ;

	public Client findClientById(Long id);
}
