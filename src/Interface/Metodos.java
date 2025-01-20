package Interface;

import java.util.List;

import Model.Autos;

public interface Metodos {
	//declarar metodos con validacion
	
	//guardar -- que no se repita la placa y el modelo
	public void guardar(Autos auto);
	
	public List<Autos> mostrar();
	
	public Autos buscar(int indice);
	
	public void editar(int indice, Autos auto);
	
	public void eliminar (int indice);
	
}
