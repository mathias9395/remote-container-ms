package dk.dtu.management.controller;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Message;
import dk.dtu.management.view.ClientMessageView;

public class ClientMessageController {
	
	private ClientMessageView view;
	private ApplicationController application;
	private Client client;
	
	public ClientMessageController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.view = new ClientMessageView(this);
	}
	
	public void display() {
		view.setVisible(true);
	}

	public void sendMessage(String content) {
		if (content.length() == 0) {
			view.showMessageError();
		} else {
			client.addMessage(new Message(client,true,content));
			view.resetText();
		}
		
	}

	public String displayMessages() {
		String messages = "";
		for(Message m : client.getMessages()) {
			if (m.getSender()) {
				messages = messages + "Me: " + m.getContent() + "\n\n";
			} else {
				messages = messages + "Company: " + m.getContent() + "\n\n";
			}
		}
		return messages;
	}
	
	public void returnDashboard() {
		view.setVisible(false);
		application.clientDashboard(client);
	}

}
