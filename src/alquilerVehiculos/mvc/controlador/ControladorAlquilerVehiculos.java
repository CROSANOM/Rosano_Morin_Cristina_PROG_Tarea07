package alquilerVehiculos.mvc.controlador;

import alquilerVehiculos.modelo.IModeloAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.vista.IUTextual;

public class ControladorAlquilerVehiculos implements IControladorAlquilerVehiculo {

	// atributos.
	 IModeloAlquilerVehiculos modelo;
	 IUTextual vista;

	// constructor
	/**
	 * @param modelo
	 * @param vista
	 */

	public ControladorAlquilerVehiculos(IModeloAlquilerVehiculos modelo, IUTextual vista) {
		this.vista = vista;
		this.modelo = modelo;
		vista.setControlador(this);
	}

	// metodos de controlador

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#comenzar()
	 */
	
	@Override
	public void comenzar() {
		
//		modelo.anadirDatosPrueba();
		modelo.leerClientes();
		modelo.leerVehiculos();
		modelo.leerAlquileres();
		vista.comenzar();
	}

	
	public void salir() {
	
		modelo.escribirClientes();
		modelo.escribirVehiculos();
		modelo.escribirAlquileres();
		
	}
	
	// metodos de cliente Cliente
	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#anadirCliente(alquilerVehiculos.mvc.modelo.dominio.Cliente)
	 */
	@Override
	public void anadirCliente(Cliente cliente) {
		modelo.anadirCliente(cliente);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#borrarCliente(java.lang.String)
	 */
	@Override
	public void borrarCliente(String dni) {
		modelo.borrarCliente(dni);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#buscarCliente(java.lang.String)
	 */
	@Override
	public Cliente buscarCliente(String dni) {
		return modelo.buscarCliente(dni);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#obtenerClientes()
	 */
	@Override
	public Cliente[] obtenerClientes() {
		return modelo.ObtenerCliente();
	}

	// metodos Vehiculos

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#anadirVehiculo(alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo, alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo)
	 */
	@Override
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		modelo.anadirVehiculo(vehiculo, tipoVehiculo);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#borrarVehiculo(java.lang.String)
	 */
	@Override
	public void borrarVehiculo(String matricula) {
		modelo.borrarVehiculo(matricula);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#buscarVehiculo(java.lang.String)
	 */
	
	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		return modelo.buscarVehiculo(matricula);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#obtenerVehiculo()
	 */
	@Override
	public Vehiculo[] obtenerVehiculo() {
		return modelo.ObtenerVehiculos();
	}
	// metodo de alquier

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#abrirAlquiler(alquilerVehiculos.mvc.modelo.dominio.Cliente, alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	@Override
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.abrirAlquiler(cliente, vehiculo);

	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#cerrarAlquiler(alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	@Override
	public void cerrarAlquiler(Vehiculo vehiculo) {
		modelo.cerrarAlquiler(vehiculo);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#obtenerAlquiler()
	 */

	
	@Override
	public Alquiler[] obtenerAlquiler() {
		return modelo.obtenerAlquileres();
	}

	@Override
	public void anadirDatosPrueba() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.mvc.controlador.IControladorAlquilerVehiculo#anadirDatosPrueba()
	 */
	//@Override
//	public void anadirDatosPrueba() {
//		modelo.anadirDatosPrueba();
//
//	}

}
