package dk.dtu.management.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dk.dtu.management.dao.MessageDao;


@Entity
@Table(name = "message")
public class Message {

	@Transient
	private MessageDao messageDao = new MessageDao();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id", unique = true)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_fk", referencedColumnName = "client_id")
	private Client client;
	@Column(name = "sender", nullable = false)
	private Boolean sender;
	@Column(name = "content", nullable = false)
	private String content;
	
	public Message() {
	}
	public Message(Client client, Boolean sender, String content) {
		this.client = client;
		this.sender = sender;
		this.content = content;
		messageDao.save(this);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
		messageDao.update(this);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		messageDao.update(this);
	}

	public Boolean getSender() {
		return sender;
	}

	public void setSender(Boolean sender) {
		this.sender = sender;
		messageDao.update(this);
	}
	public int getId() {
		return id;
	}
	
	
	
}
