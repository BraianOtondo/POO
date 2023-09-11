package modelo;

import java.util.ArrayList;
import java.util.List;

public class Incaa {
	private List<Pelicula> catalogo= new ArrayList<Pelicula>();

	public Incaa() {
		super();
	}

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}

	@Override
	public String toString() {
		return "Incaa [catalogo=" + catalogo + "]";
	}
	
	public Pelicula traerPelicula (int idPelicula) {
		Pelicula encontrada= null;
		int i=0;
		while(encontrada==null && i<this.catalogo.size()) {
			if(this.catalogo.get(i).getIdPelicula()==idPelicula) {
				encontrada=this.catalogo.get(i);
			}
			i++;
		}
		return encontrada;
	}
	public Pelicula traerPelicula(String pelicula) {
		Pelicula encontrada=null;
		int i=0;
		while(encontrada==null && i<this.catalogo.size()) {
			if(this.catalogo.get(i).getPelicula().equalsIgnoreCase(pelicula)) {
				encontrada=catalogo.get(i);
			}
			i++;
		}
		return encontrada;
	}
	private int traerUltimoID() {
		int mayor=0;
		if(this.catalogo.size()!=0) {
			mayor=this.catalogo.get(this.catalogo.size()-1).getIdPelicula();
		}
		return mayor;
	}
	// Si la película existe en la lista lanzar la excepción
	public boolean agregarPelicula (String pelicula) throws Exception{
		
		Pelicula aux =this.traerPelicula(pelicula);
		if(aux!=null) {
			throw new Exception("La pelicula :"+pelicula+" ya existe");
		}
		
		aux= new Pelicula(this.traerUltimoID()+1,pelicula );
		return  this.catalogo.add(aux);		
	}
	//Modificar la película traerPelicula por id, si no existe la película lanzar la excepción, de lo
	//contrario setPelicula con el parámetro pelicula
	public boolean modificarPelicula (int idPelicula, String pelicula) throws Exception{
		
		Pelicula aux=this.traerPelicula(idPelicula);
		if(aux==null) {
		throw new Exception("La pelicula con Id : "+idPelicula+" no existe");
		}
		aux.setPelicula(pelicula);

		return true;
	}
	//Eliminar la película: traerPelicula por su id, si no existe la película lanzar la excepción, de lo
	//contrario eliminar el elemento de la lista (remove)
	public boolean eliminarPelicula (int idPelicula)throws Exception {
		
		Pelicula aux=traerPelicula(idPelicula);
		if(aux==null) {
			throw new Exception("La pelicula con Id: "+idPelicula+" no existe");
		}
		
		return this.catalogo.remove(aux);
		
	}
	
	
	
}
