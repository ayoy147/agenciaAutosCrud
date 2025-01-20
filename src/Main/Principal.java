package Main;

import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.print.attribute.standard.Sides;

import Implementacion.LogicaMetodos;
import Model.Autos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// declarar laas variable

		Scanner lectura = null;

		String placa;
		String marca;
		String modelo;
		float precio;
		int existencia;

		Autos auto = null;

		LogicaMetodos imp = new LogicaMetodos(); // invocacion de los metodos

		int menuPrincipal, subMenu, indice;

		do {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1--ALTA");
			System.out.println("2--MOSTRAR");
			System.out.println("3--BUSCAR");
			System.out.println("4--EDITAR");
			System.out.println("5--ELIMINAR");
			System.out.println("6---BUSCAR POR MODELO");
			System.out.println("7---BUSCAR POR MARCA");
			System.out.println("8---CALCULA DINERO INVERTIDO");
			System.out.println("9---EDITAR BUSCANDO POR MODELO");//Placa
			System.out.println("10---SALIR");

			lectura = new Scanner(System.in);
			menuPrincipal = lectura.nextInt();

			switch (menuPrincipal) {
			case 1:
				try {
					System.out.println("Registrar auto");
					System.out.println("INGRESA LA PLACA");
					lectura = new Scanner(System.in);
					placa = lectura.nextLine(); // polimorfismo (puro o casteo)

					System.out.println("INGRESA LA MARCA");
					lectura = new Scanner(System.in);
					marca = lectura.nextLine();

					System.out.println("INGRESA EL MODELO");
					lectura = new Scanner(System.in);
					modelo = lectura.nextLine();

					System.out.println("INGRESA EL PRECIO");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();

					System.out.println("INGRESA LA EXISTENCIA");
					lectura = new Scanner(System.in);
					existencia = lectura.nextInt();

					// declaramos o creamos el objeto

					auto = new Autos(placa, marca, modelo, precio, existencia);

					// guardamos el objeto con el metodo creado

					imp.guardar(auto);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("ERROR AL GUARDAR" + e.getMessage());
				}
				break;
			case 2:
				if (imp.mostrar().size() > 0) {
					System.out.println("REGISTROS \n" + imp.mostrar());
				} else {
					System.out.println("NO HAY REGISTROS");
				}

				break;
			case 3:

				try {
					System.out.println("Ingresa el indice a buscar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					System.out.println(imp.buscar(indice));

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("ese indice no existe");
				}

				break;
			case 4:
				try {
					System.out.println("Ingresa el indice a editar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					auto = imp.buscar(indice);
					System.out.println("Se encontro el auto" + imp.buscar(indice));

					do {
						System.out.println("Submenu para editar");
						System.out.println("1--Precio");
						System.out.println("2--Existencia");
						System.out.println("3--Salir");
						lectura = new Scanner(System.in);
						subMenu = lectura.nextInt();

						switch (subMenu) {
						case 1:
							System.out.println("ingrese el nuevo precio");
							lectura=new Scanner(System.in);
							precio = lectura.nextFloat();
							//Actualizacion del objeto
							auto.setPrecio(precio);
							//Actualizacion en la lista
							imp.editar(indice, auto);
							System.out.println(" Se actualizo el nuevo precio \n ");
							
							break;

						case 2:
							System.out.println("Ingrese la nueva existencia");
							lectura=new Scanner(System.in);
							existencia= lectura.nextInt();
							
							auto.setExistencia(existencia);
							imp.editar(indice, auto);
							System.out.println("Se actualizo la nueva existencia");
							break;

						case 3:
							System.out.println("Saliendo...");
							break;
						}

					} while (subMenu < 3);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("ese indice no existe");
				}

				break;
			case 5:
				try {
					System.out.println("Ingresa el indice a eliminar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					
					//eliminar
					imp.eliminar(indice);
					System.out.println("Se elimino con exito");
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No se encontro el indice");
				}
				break;
			case 6:
				System.out.println("Ingresa el modelo a buscar");
				lectura = new Scanner(System.in);
				modelo= lectura.nextLine();
				
				if (imp.buscarModelo(modelo)==null) {
					System.out.println("Ese registro no existe");
				}else {
					System.out.println("Se encontro el registro: " + imp.buscarModelo(modelo));
				}
				
				break;
			case 7:
				System.out.println("Ingresa la marca a buscar");
				lectura = new Scanner(System.in);
				marca= lectura.nextLine();
				
				if (imp.buscarMarca(marca).size()>0) {
					System.out.println(imp.buscarMarca(marca));
					
				}else {
					System.out.println("No se encontraron registros con esa marca");
				}
				
				break;
			case 8:
				imp.invercion();
				break;
			case 9:
				System.out.println("Ingrece el modelo a editar la marca");
				lectura = new Scanner(System.in);
				modelo = lectura.nextLine();
				//buscar
				auto = imp.buscarModelo(modelo);
				//buscar 
				if (auto==null) {
					System.out.println("No se encontro el auto");
					
				}else {
					System.out.println("Se encontro el registro " + auto);
					System.out.println("ingrese la nueva placa");
					lectura = new Scanner(System.in);
					placa = lectura.nextLine();
					
					//Actualizar
					
					auto.setPlaca(placa);
					imp.editarModelo(auto);
				}
				
				break;
			case 10:
				System.out.println("Salir...");
				break;

			}

		} while (menuPrincipal < 6);
		
	}

}
