package gamestore.matrixtech.alejandrocardona.microservices.entities;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JUEGOS")
public class Juego {
	
	@Id
	@Column(name = "IDE_JUEGO")
	private Integer ideJuego;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ANIO_LANZAMIENTO")
	private Integer anioLanzamiento;
	
	
	@Column(name = "PROTAGONISTAS")
	private String protagonistas;
	
	@Column(name = "DIRECTOR")
	private String director;
	
	@Column(name = "PRODUCTOR")
	private String productor;
	
	@OneToOne
	@JoinColumn(name = "IDE_CONSOLA")
	private Consola idConsola;
	
	@Column(name = "PRECIO_ALQUILER")
	private Integer precioAlquiler;

	public Integer getIdeJuego() {
		return ideJuego;
	}

	public void setIdeJuego(Integer ideJuego) {
		this.ideJuego = ideJuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(Integer anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	public String getProtagonistas() {
		return protagonistas;
	}

	public void setProtagonistas(String protagonistas) {
		this.protagonistas = protagonistas;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public Consola getIdConsola() {
		return idConsola;
	}

	public void setIdConsola(Consola idConsola) {
		this.idConsola = idConsola;
	}

	public Integer getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(Integer precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	
	
}
