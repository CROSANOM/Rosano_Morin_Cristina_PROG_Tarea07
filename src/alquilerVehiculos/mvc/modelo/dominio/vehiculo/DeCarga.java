
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class DeCarga extends Vehiculo {  //  hereda de Vehiculo

	// atributo

	double precioEspecificoDeCarga = 0;

	// constructor:
	// public Vehiculo(String matricula, String marca, String modelo,
	// DatosTecnicosVehiculo datosTecnicos)

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param datosTecnicos
	 */
	public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);

	}

	public DeCarga(Vehiculo vehiculo) {
		super(vehiculo);
	}

	// metodos 
	public TipoVehiculo getTipoVehiculo() {

		return TipoVehiculo.AUTOBUS;
	}

	public double getPrecioEspecifico() {

		// calcular precio especifico autobus  De carga: 
		//Se le suma a la parte fija la cantidad:  PMA  /  20 + 1 * nº plazas.

		precioEspecificoDeCarga	= (getPrecioEspecifico() * FACTOR_PMA / 20) + 1 * FACTOR_NUMERO_PLAZAS;

		return precioEspecificoDeCarga;
	}

	
}
