package Model;

public class Autos {
	private String placa;
	private String marca;
	private String modelo;
	private float precio;
	private int existencia;
	
	public Autos() {
	}
	
	public Autos(String placa, String marca, String modelo, float precio, int existencia) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.existencia = existencia;
	}
	
	@Override
	public String toString() {
		return "Autos [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio
				+ ", existencia=" + existencia + "]\n";
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getExistencia() {
		return existencia;
	}
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	
	
}
