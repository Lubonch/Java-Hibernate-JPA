package edu.epidata.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Capitulo 
{
	@Id // Indica que es el identificador de las personas
	private int id;
	
	@Column
	private String titulo;
	
	@Column
	private int paginas;
	
	//Un capitulo tiene un solo revisor
	//Un revisor puede corregir muchos capitulos
	@ManyToOne
	private Persona revisor;
	
	//Un capitulo puede tener muchos autores
	//Un autor puede haber escrito muchos capitulos.
	@ManyToMany
	private List<Persona> autores = new ArrayList<>();
	
	//Un libro tiene muchos capitulos, pero un capitulo esto en un solo libro
	@ManyToOne
	private Libro libro;

	public Capitulo() {
		//Requerido
	}

	public Capitulo(int id, String titulo, int paginas, Persona revisor,
			List<Persona> autores, Libro libro) {
		this.id = id;
		this.titulo = titulo;
		this.paginas = paginas;
		this.revisor = revisor;
		this.autores = autores;
		this.libro = libro;
	}
}
