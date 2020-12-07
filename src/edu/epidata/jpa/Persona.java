package edu.epidata.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona 
{
	@Id // Indica que es el identificador de las personas
	private int id;
	
	@Column // Indica que es una columna en la BDs
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column(nullable = false) // Indica que no puede ser null
	private String mail;

	public Persona() 
	{
		// El constructor por defecto es obligatorio.
	}
	
	public Persona(String nombre, String apellido, String mail) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
	}

	public Persona(int id, String nombre, String apellido, String mail) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
	}
	
}
