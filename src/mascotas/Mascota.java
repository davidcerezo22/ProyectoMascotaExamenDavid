package mascotas;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Mascota {
	/**
	 * Propiedades
	 */
	private String nombre;
	private String especie;
	LocalDate fechaNacimiento;
	private ArrayList<Revision> revisiones;
	
	public Mascota() {
		
	}

	public Mascota(String nombre, String especie, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.especie = especie;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Getters & Setters 
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public ArrayList<Revision> getRevisiones() {
		return revisiones;
	}

	public void setRevisiones(ArrayList<Revision> revisiones) {
		this.revisiones = revisiones;
	}
	
	
	public int calcularEdad() {
		
		int yearNacimiento = getFechaNacimiento().getYear();
		int hoy = LocalDate.now().getYear();
		
		return  yearNacimiento - hoy / 12;
		
	}
    public boolean agrearRevision(LocalDate fecha, String motivo) {

		Revision nueva = new Revision(fecha, motivo);
		boolean puedeAgregarse = false;
		puedeAgregarse = this.revisiones.add(nueva);

		return puedeAgregarse;

	}

	public Revision[] listarRevisiones() {

		int tam = revisiones.size();
		Revision[] rev = new Revision[tam];
		for (int i = 0; i < revisiones.size(); i++) {
			rev[i] = revisiones.get(i);
		}

		return rev;

	}

}
