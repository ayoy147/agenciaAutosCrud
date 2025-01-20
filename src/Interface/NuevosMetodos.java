package Interface;

import java.util.List;

import Model.Autos;

public interface NuevosMetodos {
	
	public Autos buscarModelo(String modelo);
	
	public List<Autos> buscarMarca(String marca);
	
	public void invercion();
	
	public void editarModelo(Autos auto);
	
	
}
