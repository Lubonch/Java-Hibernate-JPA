package edu.epidata.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Libro 
{
	@Id // Indica que es el identificador de las personas
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private int anio;
	
	@ManyToMany
	private List<Persona> editores = new ArrayList<>(); //Un libro tiene muchos capitulos, pero un capitulo esto en un solo libro

	//El mapeo es realizado por Capitulo.
	@OneToMany(mappedBy = "libro")
	private List<Capitulo> capitulos = new ArrayList<>();

	public Libro() 
	{
		//Requerido
	}

	public Libro(int id2, String nombre, int anio, List<Persona> editors) {
		this.id = id2;
		this.nombre = nombre;
		this.anio = anio;
		this.editores = editors;
	}
}
