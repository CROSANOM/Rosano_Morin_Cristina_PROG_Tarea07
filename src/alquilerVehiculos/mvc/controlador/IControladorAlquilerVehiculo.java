package alquilerVehiculos.mvc.controlador;

import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public interface IControladorAlquilerVehiculo {

	/**
	 * llama a metodo de comenzar y datos prueba alquilerVehiculos
	 */
	void comenzar();

	// metodos de cliente Cliente
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

	/**
	 * @return
	 */
	Cliente[] obtenerClientes();

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
	 * @return
	 */
	Vehiculo[] obtenerVehiculo();
	// metodo de alquier

	/**
	 * @param cliente
	 * @param vehiculo
	 */
	void abrirAlquiler(Cliente cliente, Vehiculo vehiculo);

	/**
	 * @param vehiculo
	 */
	void cerrarAlquiler(Vehiculo vehiculo);

	/**
	 * @return
	 */
	Alquiler[] obtenerAlquiler();

	void anadirDatosPrueba();

}