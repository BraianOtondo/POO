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
	public boolean agregarPelicula (String pelicula) {
		Pelicula aux =this.traerPelicula(pelicula);
		boolean retorno=false;
		if(aux==null) {
			retorno=true;
			aux= new Pelicula(this.traerUltimoID()+1,pelicula );
			this.catalogo.add(aux);
		}
		return retorno;
	}
	public void modificarPelicula (int idPelicula, String pelicula) {
		Pelicula aux=this.traerPelicula(idPelicula);
		if(aux!=null) {
			aux.setPelicula(pelicula);
		}
		
	}
	public boolean eliminarPelicula (int idPelicula) {
		boolean retorno=false;
		Pelicula aux=traerPelicula(idPelicula);
		if(aux!=null) {
			retorno=true;
			this.catalogo.remove(aux);
		}
		return retorno;
	}
	
	
	
}
