package modelo;

import java.util.ArrayList;
import java.util.List;

public class Incaa {
	private List<Pelicula> catalogo = new ArrayList<Pelicula>();

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
		Pelicula aux=null;
		int i=0;
		while(i<this.catalogo.size() && aux==null) {
			if(idPelicula==this.catalogo.get(i).getIdPelicula()) {
				aux=this.catalogo.get(i);
			}
			i++;
		}
		return aux;
	}
	public Pelicula traerPelicula (String partePelicula) {
		Pelicula aux=null;
		int i=0;
		while(i<this.catalogo.size() && aux==null) {
			if(this.catalogo.get(i).getPelicula().equals(partePelicula)){
				aux=this.catalogo.get(i);
			}
			i++;
		}
		return aux;
	}
	private int traerUltimoId(){
		int ultimo=0;
		if(this.catalogo.size()!=0) {
			ultimo=catalogo.get(catalogo.size()-1).getIdPelicula();
		}
		return ultimo;
	}
	public boolean agregarPelicula (String pelicula, Genero genero) {
		Pelicula aux=traerPelicula(pelicula);
		boolean retorno=false;
		if(aux==null) {
			
			this.catalogo.add(new Pelicula(this.traerUltimoId()+1, pelicula,genero));
			retorno=true;
		}
		return retorno;
	}
	public boolean modificarPelicula (int idPelicula, String pelicula) {
		Pelicula aux=this.traerPelicula(idPelicula);
		boolean retorno=false;
		if(aux!=null) {
			aux.setPelicula(pelicula);
			retorno=true;
		}
		return retorno;
	}
	public boolean eliminarPelicula (int idPelicula) {
		boolean retorno=false;
		Pelicula aux=this.traerPelicula(idPelicula);
		if(aux!=null) {
			this.catalogo.remove(aux);
			retorno=true;
		}
		return retorno;
	}
	public List<Pelicula> traerPelicula(Genero genero){
		List<Pelicula> lista = new ArrayList<Pelicula>();
		for(int i=0;i<this.catalogo.size();i++) {
			if(this.catalogo.get(i).getGenero().equals(genero)) {
				lista.add(this.catalogo.get(i));
			}
		}
		return lista;
	}
	
	
	
}
