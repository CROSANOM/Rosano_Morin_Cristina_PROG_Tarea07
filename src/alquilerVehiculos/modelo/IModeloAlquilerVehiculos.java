package alquilerVehiculos.modelo;

import alquilerVehiculos.mvc.modelo.dao.Alquileres;
import alquilerVehiculos.mvc.modelo.dao.Clientes;
import alquilerVehiculos.mvc.modelo.dao.Vehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public interface IModeloAlquilerVehiculos {

	/**
	 * @return the clientes
	 */
	Clientes getClientes();

	/**
	 * @return the vehiculos
	 */
	Vehiculos getVehiculos();

	/**
	 * @return the alquileres
	 */
	Alquileres getAlquileres();

	/**
	 * @return
	 */
	Cliente[] ObtenerCliente();

	/**
	 * @return
	 */
	Vehiculo[] ObtenerVehiculos();

	/**
	 * @return 
	 */
	Alquiler[] obtenerAlquileres();

	/**
	 * @param cliente
	 */
	void anadirCliente(Cliente cliente);

	/**
	 * @param dni
	 */
	void borrarCliente(String dni);

	/**
	 * @param dni
	 * @return
	 */
	Cliente buscarCliente(String dni);

	// metodos de los Vehiculos
	/**
	 * @param vehiculo
	 * @param tipoVehiculo
	 */
	void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo);

	/**
	 * @param matricula
	 */
	void borrarVehiculo(String matricula);

	/**
	 * @param matricula
	 * @return
	 */

	Vehiculo buscarVehiculo(String matricula);

	/**
	 * @param cliente
	 * @param vehiculo
	 */
	void abrirAlquiler(Cliente cliente, Vehiculo vehiculo);

	/**
	 * @param vehiculo
	 */
	void cerrarAlquiler(Vehiculo vehiculo);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	String toString();

//	// Metodo con datos de pruebas
//	void anadirDatosPrueba();

	void leerClientes();

	void leerVehiculos();

	void escribirClientes();

	void escribirVehiculos();

	void leerAlquileres();

	void escribirAlquileres();

}