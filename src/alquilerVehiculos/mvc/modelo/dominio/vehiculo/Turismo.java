package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Turismo extends Vehiculo {

	// atributo Turismo
	double precioEspecificoTurismo = 0;

	// constructor:
	// public Vehiculo(String matricula, String marca, String modelo,
	// DatosTecnicosVehiculo datosTecnicos) {

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param datosTecnicos
	 */
	public Turismo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);
	}

	// constructor Copia

	/**
	 * @param vehiculo
	 */
	public Turismo(Vehiculo vehiculo) {
		super(vehiculo);
	}

	public TipoVehiculo getTipoVehiculo() {

		return TipoVehiculo.TURISMO;
	}

	public double getPrecioEspecifico() {

		// calcular precio especifico Turismo

		precioEspecificoTurismo = (getPrecioEspecifico() * FACTOR_CILINDRADA / 50);
		return precioEspecificoTurismo;
	}
	
}
