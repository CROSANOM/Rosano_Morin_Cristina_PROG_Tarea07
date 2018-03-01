package alquilerVehiculos.mvc.modelo.dao;

import java.util.Arrays;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class Vehiculos {

	private Vehiculo[] vehiculos;
	private final int MAX_VEHICULOS = 10;

	// constructor
	public Vehiculos() {
		vehiculos = new Vehiculo[MAX_VEHICULOS];
	}

	/**
	 * @return vehiculos ( copia )
	 */
	public Vehiculo[] getVehiculo() {
		return vehiculos.clone();
	}

	/*
	 * metodo anadir Vehiculo (buscarPrimerIndiceLibre,indiceNosuperaTamaño)
	 */

	/**
	 * @param vehiculo
	 * @param tipoVehiculo
	 */
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
		if (indiceNoSuperaTamano(indice))
			/*
			 * Modificamos se llama clase abstracta getInstancia y acceden atributos de
			 * vehiculo
			 */
			vehiculos[indice] = tipoVehiculo.getInstancia(vehiculo.getMatricula(), vehiculo.getMarca(),
					vehiculo.getModelo(), vehiculo.getDatosTecnicosVehiculo());
		else
			throw new ExcepcionAlquilerVehiculos("El array de  vehiculos esta lleno.");
	}

	// metodo buscarPrimerIndiceLibre (indiceNoSupera)
	/**
	 * @param vehiculo
	 * @return indice
	 */
	private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
		int indice = 0;
		boolean VehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !VehiculoEncontrado) {
			if (vehiculos[indice] == null)
				VehiculoEncontrado = true;
			else if (vehiculos[indice].getMatricula().equals(vehiculo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un vehiculo con esa matricula");
			else
				indice++;
		}
		return indice;
	}

	// metodo indiceNoSuperaTamano
	/**
	 * @param indice
	 * @return false o true
	 */
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < vehiculos.length;
	}

	/* metodo de borrar Vehiculo (buscarIndiceTurismo, indiceNosuperatamaño */

	/**
	 * @param matricula
	 */
	public void borrarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El Vehiculo no existe.");
		}
	}

	// metodo buscarIndiceVehiculo
	/**
	 * @param matricula
	 * @return indice del array donde se encuente
	 */
	private int buscarIndiceVehiculo(String matricula) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {

			if (vehiculos[indice] != null && vehiculos[indice].getMatricula().equals(matricula)) {
				vehiculoEncontrado = true;
			} else {
				indice++;
			}
		}
		return vehiculoEncontrado ? indice : vehiculos.length;
	}

	// metodo desplazarUnaPosiciónHaciaIzquierda

	/**
	 * @param indice
	 */
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < vehiculos.length - 1 && vehiculos[i] != null; i++) {
			vehiculos[i] = vehiculos[i + 1];
		}
	}

	/* Metodo buscarTurismo ( buscarIndice,indiceNoSupera) */

	/**
	 * @param matricula
	 * @return Vehiculo
	 */
	public Vehiculo buscarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			return (vehiculos[indice]);
		} else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculos [vehiculos=" + Arrays.toString(vehiculos) + ", MAX_VEHICULOS=" + MAX_VEHICULOS + "]";
	}

}
