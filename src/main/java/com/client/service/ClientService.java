package com.client.service;

import java.util.List;

import com.client.model.Client;

public interface ClientService {
	
	
	public List<Client> getClients();
	
	public Client addClient(Client client);
	
	public Client updateClient(Client client);
	
	public Client findClientById(Long id);

	public Client deleteClient(Long id);
	

}
