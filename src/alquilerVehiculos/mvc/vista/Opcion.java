package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.vista.IUTextual;

// enum
public enum Opcion {

	SALIR("Salir") {

		public void ejecutar() {
			vista.salir();
		}
	},
	ANADIR_CLIENTE("Añadir Cliente") {
		public void ejecutar() {
			vista.anadirCliente();
		}
	},
	BORRAR_CLIENTE("Borrar Cliente") {
		public void ejecutar() {
			vista.borrarCliente();
		}
	},

	BUSCAR_CLIENTE("Buscar Cliente") {
		public void ejecutar() {
			vista.buscarCliente();
		}
	},
	LISTAR_CLIENTES("Listar Clientes") {
		public void ejecutar() {
			vista.listarClientes();
		}
	},
	ANADIR_VEHICULO("Añadir vehiculo") {
		public void ejecutar() {
			vista.anadirVehiculo();
		}
	},

	BORRAR_VEHICULO("Borrar vehiculo") {
		public void ejecutar() {
			vista.borrarVehiculo();
		}
	},
	BUSCAR_VEHICULO("Buscar vehiculo") {
		public void ejecutar() {
			vista.buscarVehiculo();
		}
	},
	LISTAR_VEHICULOS("Listar vehiculos") {
		public void ejecutar() {
			vista.listarVehiculos();
		}
	},
	ABRIR_ALQUILER("Abrir alquiler") {
		public void ejecutar() {
			vista.abrirAlquiler();
		}
	},
	CERRAR_ALQUILER("Cerrar alquiler") {
		public void ejecutar() {
			vista.cerrarAlquiler();
		}
	},
	LISTAR_ALQUILER("Listar alquileres") {
		public void ejecutar() {
			vista.listarAlquileres();
		}
	};

	// Atributos de la clase
	private static IUTextual vista;
	private String mensaje = "";

	// Constructor de opciones.
	private Opcion(String mensaje) {
		this.mensaje = mensaje;
	}

	// Método que ejecuta cada opción.
	public abstract void ejecutar();

	public String getMensaje() {
		return mensaje;
	}

	// Establece la vista (Menu) para esta clase.
	public static void setVista(IUTextual vista) {
		Opcion.vista = vista;
	}

	// Formato de salida del menu.
	public String toString() {
		return String.format("%d.- %s", ordinal(), mensaje);
	}

	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Opción no válida");
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
	}

}
