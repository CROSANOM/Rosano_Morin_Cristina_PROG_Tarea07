package alquilerVehiculos.mvc.vista.utilidades;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.DatosTecnicosVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.vista.Opcion;

// Esta clase contiene toda la entrada y salida de datos de la aplicacion

// metodos staticos: mostrarMenu, MostrarCabecera,  leer cliente, turismos, matricula, Dni, 
public class Consola {

	// constructor

	public Consola() {

	}

	// mostrar Menu
	/**
	 * Llama OpcionValue Enum Opcion
	 */
	public static void mostrarMenu() {
		mostrarCabecera("Alquiler");
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion);
		}
	}

	// Cabeceras de los listados de las opciones.
	/**
	 * @param mensaje
	 *            imprime
	 */
	public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s%n", mensaje);
		System.out.println(String.format("%0" + mensaje.length() + "d%n", 0).replace("0", "-"));
	}

	// Elegir Opción
	/**
	 * @return una opcion del menu
	 */
	public static int elegirOpcion() {
		int ordinalOpcion;
		do {
			System.out.print("\nElige una opcion: ");
			ordinalOpcion = Entrada.entero();
		} while (!Opcion.esOrdinalValido(ordinalOpcion));
		return ordinalOpcion;
	}

	// leerDni
	/**
	 * @return dni
	 */
	public static String leerDni() {
		System.out.print("Introduce el DNI del cliente: ");
		String dniALeer = Entrada.cadena();
		return dniALeer;
	}

	// leerCliente:cliente
	/**
	 * @return cliente
	 */
	public static Cliente leerCliente() {
		Cliente cliente = null;
		System.out.print("Nombre: ");
		String nombre = Entrada.cadena();
		System.out.print("DNI: ");
		String dni = Entrada.cadena();
		System.out.print("Direccion: ");
		String direccion = Entrada.cadena();
		System.out.print("Localidad: ");
		String localidad = Entrada.cadena();
		System.out.print("CodigoPostal: ");
		String codigoPostal = Entrada.cadena();
		cliente = new Cliente(nombre, dni, new DireccionPostal(direccion, localidad, codigoPostal));
		return cliente;
	}

	// leerMatricula :matricula (
	/**
	 * @return matricula
	 */
	public static String leerMatricula() {
		System.out.print("Introduce la matricula del vehiculo: ");
		String matriculaLeer = Entrada.cadena();
		return matriculaLeer;
	}

	// leerVehiculo
	/**
	 * @return vehiculo
	 */
	public static Vehiculo leerVehiculo() {

		Vehiculo nuevoVehiculo = null;
		int ordinalVehiculo = 0;
		System.out.print("Matricula: ");
		String matricula = Entrada.cadena();
		System.out.print("Marca: ");
		String marca = Entrada.cadena();
		System.out.print("Modelo: ");
		String modelo = Entrada.cadena();
		System.out.print("Datos Tecnicos de Vehiculos: ");
		System.out.print("cilindrada: ");
		int cilindrada = Entrada.entero();
		System.out.print("Numero de plazas: ");
		int numeroPlazas = Entrada.entero();
		System.out.print("pma: ");
		int pma = Entrada.entero();
		// instanciar un vehiculo

		try {

			nuevoVehiculo = TipoVehiculo.getTipoVehiculosSegunOrdinal(ordinalVehiculo).getInstancia(matricula, marca,
					modelo, new DatosTecnicosVehiculo(cilindrada, numeroPlazas, pma));
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("Error:  %s%n%n", e.getMessage());
		}
		return nuevoVehiculo;
	}

	// metodo acceder tipos de Vehiculo
	/**
	 * @return TipoVehiculo a traves de ObtenerTipoVehiculo
	 */
	public static int elegirTipoVehiculo() {
		int ordinalTipoVehiculo;
		do {
			System.out.printf("Elige el tipo de Vehiculo: ( %s)", obtenerTipoVehiculo());
			ordinalTipoVehiculo = Entrada.entero();
		} while (!TipoVehiculo.esOrdinalValido(ordinalTipoVehiculo));
		return ordinalTipoVehiculo;
	}

	/**
	 * @return tiposVehiculos
	 */
	public static String obtenerTipoVehiculo() {
		StringBuilder tiposVehiculo = new StringBuilder("");
		for (TipoVehiculo tipoVehiculo : TipoVehiculo.values()) {
			tiposVehiculo.append(tipoVehiculo.ordinal()).append(".- ").append(tipoVehiculo).append(" ");
		}
		return tiposVehiculo.toString();

	}

}
