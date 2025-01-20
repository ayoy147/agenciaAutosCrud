package Implementacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Interface.Metodos;
import Interface.NuevosMetodos;
import Model.Autos;

public class LogicaMetodos implements Metodos, NuevosMetodos {

	private List<Autos> lista = new ArrayList<Autos>();

	// guardar -- que no se repita la placa y el modelo
	@Override
	public void guardar(Autos auto) {
		// TODO Auto-generated method stub
		// para validar usamos: Ciclo, if
		boolean bandera = false;
		for (Autos a : lista) {
			if (a.getPlaca().equalsIgnoreCase(auto.getPlaca())) {
				// Si entra significa que laa placa ya existe
				System.out.println("La placa ya existe");
				bandera = true;
				break;
			} else if (a.getModelo().equalsIgnoreCase(auto.getModelo())) {
				System.out.println("El modelo ya existe");
				bandera = true;
				break;
			}
		}
		// La bandera siempre va fuera del ciclo y si la bandera cumple sera false
		if (bandera == false) {
			lista.add(auto);
			System.out.println("Seguardo con exito");

		}

	}

	@Override
	public List<Autos> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Autos buscar(int indice) {
		// TODO Auto-generated method stub

		Autos auto = lista.get(indice); // creamos una variable para almacenar el indice

		return auto;// retornamos
	}

	@Override
	public void editar(int indice, Autos auto) {
		// TODO Auto-generated method stub
		lista.set(indice, auto);

	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		lista.remove(indice);
	}
	// Metodos nuevos

	@Override
	public Autos buscarModelo(String modelo) {
		// TODO Auto-generated method stub
		Autos auto = null;
		for (Autos a : lista) {
			if (a.getModelo().equalsIgnoreCase(modelo)) {
				auto = a;
				break;
			}
		}
		return auto;
	}

	@Override
	public List<Autos> buscarMarca(String marca) {
		// TODO Auto-generated method stub
		List<Autos> listaMarcas = new ArrayList<Autos>();
		for (Autos a : lista) {
			if (a.getMarca().equalsIgnoreCase(marca)) {
				listaMarcas.add(a);
			}

		}
		return listaMarcas;
	}

	@Override
	public void invercion() {
		// TODO Auto-generated method stub
		// ciclo para recorrer los registros de la lista
		// calculo
		float resultado = 0;
		for (int i = 0; i < lista.size(); i++) {
			Autos registro = lista.get(i);
			resultado += registro.getPrecio() * registro.getExistencia();
		}
		System.out.println("La invercion es : " + resultado);

	}

	@Override
	public void editarModelo(Autos auto) {
		// TODO Auto-generated method stub
		// ciclo para recorrer los registros de la lista
		// condicional
		// actualizacion
		for (int i = 0; i < lista.size(); i++) {
			Autos objeto = lista.get(i);
			if (objeto.equals(auto.getModelo())) {
				lista.set(i, auto);
				System.out.println("Se edito con exito ");	
				break;
			}
		}

	}

}
//siempre las validaciones, ciclos o demas cosas
