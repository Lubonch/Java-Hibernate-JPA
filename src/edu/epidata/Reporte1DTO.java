package edu.epidata;

public class Reporte1DTO 
{
	private int personaId;
	private long cant;
	
	public Reporte1DTO(int personaId, long cant) 
	{
		super();
		this.personaId = personaId;
		this.cant = cant;
	}
	//Getters y Setters
	
	@Override
	public String toString() 
	{
		return "Reporte1DTO ["+personaId + " edito " + cant + " Libro/s]";
	}
}