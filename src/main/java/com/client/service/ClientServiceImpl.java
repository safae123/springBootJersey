package com.client.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.dao.ClientDao;
import com.client.model.Client;

@Service
public class ClientServiceImpl implements ClientService{
	
	
	public ClientDao clientDao;
	
	
	@Autowired
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public List<Client> getClients() {
		return clientDao.getAll();
	}
	
	@Override
	public Client findClientById(Long id) {
		Client client = null;
		if(id == null){
			throw new IllegalArgumentException("id cannot be null"); 
		}
		client = clientDao.findClientById(id);
		if(client== null){
			throw new IllegalArgumentException("Client cannot be found"); 
		}
		return client;	
	}
	
	@Override
	public Client addClient(Client client) {
		if(client == null){
			throw new IllegalArgumentException("Client cannot be null"); 
		}
		return clientDao.addClient(client);
	}

	@Override
	public Client updateClient(Client client) {
		Client clientModifie = null;
		if(client == null){
			throw new IllegalArgumentException("Client cannot be null"); 
		}
		clientModifie = clientDao.findClientById(client.getId());
		if(clientModifie== null){
			throw new IllegalArgumentException("Client cannot be found"); 
		}
		clientModifie.setNom(client.getNom());
		clientModifie.setPrenom(client.getPrenom());
		return clientDao.updateClient(clientModifie);
	}

	@Override
	public Client deleteClient(Long id) {
		Client client = null;
		client = clientDao.findClientById(id);
		if(client== null){
			throw new IllegalArgumentException("Client cannot be found"); 
		}
		return clientDao.deleteClient(client);
	}

}
