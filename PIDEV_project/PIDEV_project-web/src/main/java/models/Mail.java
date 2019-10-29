package models;

public class Mail {
	private String objet;
	private String content;
	private String sender;
	private String senderName;
	private String destinataire;

	public Mail() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Mail(String objet, String content, String sender, String senderName, String destinataire) {
		super();
		this.objet = objet;
		this.content = content;
		this.sender = sender;
		this.senderName = senderName;
		this.destinataire = destinataire;
	}



	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}



	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

}
