package gamestore.matrixtech.alejandrocardona.microservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONSOLAS")
public class Consola {

	@Id
	@Column(name = "IDE_CONSOLA")
	private Integer ideConsola;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public Integer getIdConsola() {
		return ideConsola;
	}

	public void setIdConsola(Integer ideConsola) {
		this.ideConsola = ideConsola;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
