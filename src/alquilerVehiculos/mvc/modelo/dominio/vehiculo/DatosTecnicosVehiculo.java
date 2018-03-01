package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public class DatosTecnicosVehiculo {

	// atributos

	private int cilindrada;
	private int numerosPlazas;
	private int pma;

	// Constructor 3 parametros acceso a atrib con set

	/**
	 * @param cilindrada
	 * @param numerosPlazas
	 * @param pma
	 */
	public DatosTecnicosVehiculo(int cilindrada, int numerosPlazas, int pma) {

		setCilindrada(cilindrada);
		setNumerosPlazas(numerosPlazas);
		setPma(pma);
	}

	// Constructor Copia

	/**
	 * @param datosTecnicos
	 */
	public DatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {

		cilindrada = datosTecnicos.getCilindrada();
		numerosPlazas = datosTecnicos.numerosPlazas;
		pma = datosTecnicos.getNumerosPlazas();
	}

	// setter

	/**
	 * @param cilindrada
	 */
	private void setCilindrada(int cilindrada) {
		if (cilindrada > 0)
			this.cilindrada = cilindrada;
		else

			throw new ExcepcionAlquilerVehiculos("La cilindrada tienes que ser mayor que cero.");
	}

	/**
	 * @param numerosPlazas
	 */
	private void setNumerosPlazas(int numerosPlazas) {
		if (numerosPlazas > 0)
			this.numerosPlazas = numerosPlazas;
		else
			throw new ExcepcionAlquilerVehiculos("El numero de plazas tiene que ser superior a cero");
	}

	/**
	 * @param pma
	 */
	private void setPma(int pma) {
		if (pma > 0)
			this.pma = pma;
		else
			throw new ExcepcionAlquilerVehiculos("pma tiene que ser mayor a cero");
	}

	// getters

	/**
	 * @return cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * @return numerosPlazas
	 */
	public int getNumerosPlazas() {
		return numerosPlazas;
	}

	/**
	 * @return pma
	 */
	public int getPma() {
		return pma;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DatosTecnicosVehiculo [cilindrada=" + cilindrada + ", numerosPlazas=" + numerosPlazas + ", pma=" + pma
				+ "]";
	}

}
