package gamestore.matrixtech.alejandrocardona.microservices;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import gamestore.matrixtech.alejandrocardona.microservices.entities.Consola;
import gamestore.matrixtech.alejandrocardona.microservices.entities.Juego;
import gamestore.matrixtech.alejandrocardona.microservices.entities.Respuesta;
import gamestore.matrixtech.alejandrocardona.microservices.util.CodigosRespuestas;
import gamestore.matrixtech.alejandrocardona.microservices.util.JPAUtils;

@Path("/entry-point")
public class EntryPoint {
	
	/*
	@GET
	@Path("pagarPremio/{idPremio}")
	@Produces(MediaType.APPLICATION_JSON)
	public void pagarPremio(@PathParam("idPremio") Integer idPremio, @Suspended final AsyncResponse asyncResponse) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				Respuesta r;
				if (idPremio == null) {
					r = new Respuesta(CodigosRespuestas.ERR, "El número del premio no puede ser vacio");
					asyncResponse.resume(r);
					return;
				}

				EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();

				Session session = em.unwrap(Session.class);

				Integer response = session.doReturningWork(connection -> {
					try (CallableStatement function = connection
							.prepareCall("{ ? = call TESTDEV.SP_PAGO_PREMIO(?) }")) {
						function.registerOutParameter(1, Types.INTEGER);
						function.setInt(2, idPremio);
						function.execute();
						return function.getInt(1);
					}
				});

				session.close();
				em.close();

				switch (response.intValue()) {
				case CodigosRespuestas.NO_EXISTE_PREMIO:
					r = new Respuesta(CodigosRespuestas.ERR, "No existe el premio");
					break;
				case CodigosRespuestas.YA_REALIZO_EL_PAGO:
					r = new Respuesta(CodigosRespuestas.ERR, "El pago ya fue realizado");
					break;
				default:
					Integer idPago = response.intValue();
					r = new Respuesta(CodigosRespuestas.OK, String.valueOf(idPago));
					break;
				}
				asyncResponse.resume(r);

			}
		}).start();

	}

	@GET
	@Path("consultarPremio/{id_colilla}")
	@Produces(MediaType.APPLICATION_JSON)
	public void consultarPremio(@PathParam("id_colilla") Integer idColilla, @Suspended final AsyncResponse asyncResponse) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				Respuesta r;
				if (idColilla == null) {
					r = new Respuesta(CodigosRespuestas.ERR, "El número de la colilla no puede ser vacia");
					asyncResponse.resume(r);
					return;
				}
				
				EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();
				
				Session session = em.unwrap(Session.class);

				Integer response = session.doReturningWork(connection -> {
					try (CallableStatement function = connection.prepareCall("{ ? = call TESTDEV.SP_CONSULTAR_PREMIO(?) }")) {
						function.registerOutParameter(1, Types.INTEGER);
						function.setInt(2, idColilla);
						function.execute();
						return function.getInt(1);
					}
				});

				session.close();
				em.close();

				switch (response.intValue()) {
				case CodigosRespuestas.NO_EXISTE_COLILLA:
					r = new Respuesta(CodigosRespuestas.ERR, "No existe la colilla");
					break;
				case CodigosRespuestas.COLILLA_NO_VENDIDA:
					r = new Respuesta(CodigosRespuestas.ERR, "La colilla no fue vendida");
					break;
				case CodigosRespuestas.NO_GANADORA:
					r = new Respuesta(CodigosRespuestas.ERR, "La colilla no es ganadora");
					break;
				default:
					Integer idPremio = response.intValue();
					r = new Respuesta(CodigosRespuestas.OK, String.valueOf(idPremio));
					break;
				}
				asyncResponse.resume(r);
			}
		}).start();
	}*/

	@GET
	@Path("getJuegos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Juego> getJuegos() {
		EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();
		List<Juego> juegos = em.createNativeQuery("SELECT * FROM JUEGOS", Juego.class).getResultList();
		return juegos;
	}
	
	@GET
	@Path("getConsolas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Juego> getConsolas() {
		EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();
		List<Juego> consolas = em.createNativeQuery("SELECT * FROM CONSOLAS", Consola.class).getResultList();
		return consolas;
	}

}
