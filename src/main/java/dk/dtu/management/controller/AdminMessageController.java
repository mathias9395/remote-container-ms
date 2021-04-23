package dk.dtu.management.controller;

import dk.dtu.management.model.Client;
import dk.dtu.management.model.Message;
import dk.dtu.management.view.AdminMessageView;

public class AdminMessageController {
	private AdminMessageView view;
	private ApplicationController application;
	private Client client;
	
	public AdminMessageController(ApplicationController application, Client client) {
		this.application = application;
		this.client = client;
		this.view = new AdminMessageView(this);
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	public void sendMessage(String content) {
		if (content.length() == 0) {
			view.showMessageError();
		} else {
			client.addMessage(new Message(client,false,content));
			view.resetText();
		}
	}
	
	public String displayMessages() {
		String messages = "";
		for(Message m : client.getMessages()) {
			if (m.getSender()) {
				messages = messages + client.getName() + ": " + m.getContent() + "\n\n";
			} else {
				messages = messages + "Me: " + m.getContent() + "\n\n";
			}
		}
		return messages;
	}
	
	public void returnDashboard() {
		view.setVisible(false);
		application.adminClientDashboard(client);
	}
}
