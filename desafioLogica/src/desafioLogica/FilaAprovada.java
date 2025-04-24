package desafioLogica;

import java.util.List;



public class FilaAprovada {
	
	String createdById;
	String nomeFila;
	
	//CONSTRUTOR
	public FilaAprovada(String createdById, String nomeFila) {
		
		this.createdById = createdById;
		this.nomeFila = nomeFila;
		
	}
	
	//CONSTRUTOR VAZIO
	public FilaAprovada() {
			
		}
	
	//---------GETTERS E SETTERS-------------//
	
	

	public String getCreatedById() {
		
		return this.createdById;
		
	}
	
	public void setCreatedById(String createdById) {
		
		this.createdById = createdById;
		
	}
	
	public String getNomeFila() {
		
		return this.nomeFila;
		
	}
	
	public void setNomeFila(String nomeFila) {
		
		this.nomeFila = nomeFila;
		
	}
	
	//----------------------------------//
	
	
	public String send(String id, String corpoEmail) {
		
		return "email enviado ao id: " + id + corpoEmail;
		
	}
	
	public String toString() {
		
		return "Fila Aprovada: " + " 'id do criador :" + createdById + "'" + " 'Nome da Fila: " + nomeFila + "'" + "\n" ;
		
	}

	
	
}
