package alquilerVehiculos.mvc.modelo.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;// instanciar la clase Fecha y acceder a sus metodos

import alquilerVehiculos.mvc.modelo.dominio.*;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * @author crosanom
 *
 */

public class Alquiler {
	// atributos de la clase Alquiler.
	private Cliente cliente;
	private Vehiculo vehiculo;
	private boolean alquilerAbierto;
	private Date fecha;
	private int dias;

	private final int MS_DIA = 1000 * 60 * 60 * 24; // Calculo de los milisegundos por dia.
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy"); // incialiazación del objeto
	private final double PRECIO_DIA = 30.0; // se incializa segun informacion dada

	// Constructores con set VehiculoDisponible.
	/**
	 * @param cliente
	 * @param vehiculo
	 */
	public Alquiler(Cliente cliente, Vehiculo vehiculo) {

		if (vehiculo.getDisponible()) {
			vehiculo.setDisponible(false);// vehiculo no disponible
			alquilerAbierto = true;
			SetVehiculo(vehiculo);
			SetCliente(cliente);
			fecha = new Date();
			dias = 0;

		} else {

			throw new ExcepcionAlquilerVehiculos("El vehiculo no esta disponible");
		}

	}// f const

	// constructor copia
	/**
	 * @param alquiler
	 */
	public Alquiler(Alquiler alquiler) {

		vehiculo = alquiler.getVehiculo();
		cliente = alquiler.getCliente();
		dias = alquiler.getDias();
		fecha = alquiler.getFecha();

	}

	// getters

	/**
	 * @return cliente 
	 */
	public Cliente getCliente() {
		return new Cliente(cliente);
	}

	/**
	 * @return vehiculo
	 */
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * @return fecha 
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @return  int numero dias 
	 */
	public int getDias() {
		return dias;
	}

	// Calculo de dias.
	/**
	 * @param fechaFin
	 * @param fechaInicio
	 * @return int dias 
	 */
	private int difDias(Date fechaFin, Date fechaInicio) {
		long milisegundos = fechaFin.getTime() - fechaInicio.getTime(); // ojo getTime devuelve los milisegundos
		long dias = milisegundos / MS_DIA;
		return (int) dias; // ( int) casting pasamos long a int
	}

	// metodos alquiler cerrar-GetPrecio- obtenerEstadoAlquiler

	// cerrar alquiler ( difDias) y poner vehiculo pasa a estar disponible 
	public void cerrar() {
		Date fechaActual = new Date();
		dias = difDias(fechaActual, fecha);
		alquilerAbierto = false;
		vehiculo.setDisponible(false);
	}

	
	/**
	 * @return precioDia segun TipoVehiculo ( ligadura dinamica ) 
	 */
	public double getPrecio() { // obtener el precioDia segun regla de negocio
		return PRECIO_DIA * dias + vehiculo.getDatosTecnicosVehiculo().getCilindrada() / 100;
	}

	// obtenerEstadoAlquiler ( devuelve el estado )

	/**
	 * @return estado del Alquiler
	 */
	public String obtenerEstadoAlquiler() {
		String estado = alquilerAbierto ? "Abierto" : "Cerrado";
		return estado;
	}

	// setters Cliente y de Vehiculos ( se usa mas adelante )

	/**
	 * @param cliente
	 */
	private void SetCliente(Cliente cliente) {

		if (cliente != null)
			this.cliente = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El alquiler necesita un cliente");
	}

	
	/**
	 * @param vehiculo
	 */
	private void SetVehiculo(Vehiculo vehiculo) {
		if (vehiculo != null) {
			this.vehiculo = vehiculo;
		} else {
			throw new ExcepcionAlquilerVehiculos("El alquiler necesita un vehiculo, no hay vehiculo");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alquiler [cliente=" + cliente + ", vehiculo=" + vehiculo + ", fecha=" + fecha + ", dias=" + dias
				+ ", MILI_SEG_DIAS=" + MS_DIA + ", FORMATO_FECHA=" + FORMATO_FECHA + ", PRECIO_DIA=" + PRECIO_DIA + "]";
	}

}
