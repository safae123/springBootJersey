package com.client.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.client.model.Client;
import com.client.service.ClientService;



@Path("/client")
public class GestionClientController {
	
		
		private ClientService clientService;
		
		@Autowired
		public void setClientService(ClientService clientService) {
			this.clientService = clientService;
		}

		@GET
	    @Path("/{param}")
	 	@Produces({ MediaType.TEXT_PLAIN })
		public Response hello(@PathParam("param") String nom) {
			String output = "bienvenu "+nom;
			 return Response.status(200).entity(output).build();
		}
	 	
		@GET
	    @Path("/all")
	 	@Produces(MediaType.APPLICATION_JSON)
		public List<Client> getClients() {
			List<Client> listClients = clientService.getClients();
	         return listClients;
		}
		
	 	@GET
	    @Path("add/{nom}/{prenom}")
	 	@Produces(MediaType.APPLICATION_JSON)
		public Client getClient(@PathParam("nom") String nom,@PathParam("prenom") String prenom) {
	 		 Client client = new Client();
	 		 client.setNom(nom);
	 		 client.setPrenom(prenom);
	 		 client.setDateAbonnement(new Date());
	 		 client = clientService.addClient(client);
	         return client;
		}
		@GET
	    @Path("find/{id}")
	 	@Produces(MediaType.APPLICATION_JSON)
		public Client findClientById(@PathParam("id") Long id) {
	 		 Client client ;
	 		 client = clientService.findClientById(id);
	         return client;
		}
		@GET
	    @Path("delete/{id}")
	 	@Produces(MediaType.APPLICATION_JSON)
		public Client removeClient(@PathParam("id") Long id) {
	 		 Client client ;
	 		 client = clientService.deleteClient(id);
	         return client;
		}
		@GET
	    @Path("update/{id}/{nom}/{prenom}")
	 	@Produces(MediaType.APPLICATION_JSON)
		public Client updateClient(@PathParam("id") Long id,@PathParam("nom") String nom,
				@PathParam("prenom") String prenom) {
	 		 Client client = new Client();
	 		 client.setId(id);
	 		 client.setNom(nom);
	 		 client.setPrenom(prenom);
	 		 client = clientService.updateClient(client);
	         return client;
		}

}
