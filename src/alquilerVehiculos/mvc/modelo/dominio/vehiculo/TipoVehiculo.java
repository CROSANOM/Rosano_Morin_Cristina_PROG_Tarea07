/**
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author crosanom
 *
 */

public enum TipoVehiculo {

	TURISMO("Turismo") {
		
		public Turismo getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicosVehiculo) {
	return new Turismo(matricula,marca,modelo, datosTecnicosVehiculo);
		}
		
	},
	DECARGA("Vehiculo de Carga") {
		public DeCarga getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicosVehiculo) {
			return new DeCarga(matricula,marca,modelo,datosTecnicosVehiculo);
		}
	},
	
	AUTOBUS("Autobus") {
		public Autobus getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicosVehiculo) {
			return new Autobus(matricula,marca,modelo, datosTecnicosVehiculo);
		}
	};
	
		

	private String tipoVehiculo;

	/**
	 * @param tipoVehiculo
	 */
	private TipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return tipoVehiculo;
	}

	/**
	 * @param ordinal
	 * @return Ordinal que coincide con tipo Vehiculo
	 */
	public static TipoVehiculo getTipoVehiculosSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Ordinal del tipo de Vehiculo no válido");
	}

	/**
	 * @param ordinal
	 * @return boolean 
	 */
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}

	// metodo abstracto

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param datosTecnicosVehiculo
	 * @return instancia Vehiculo ? 
	 */
	public abstract Vehiculo getInstancia(String matricula, String marca, String modelo,
			DatosTecnicosVehiculo datosTecnicosVehiculo);

}
