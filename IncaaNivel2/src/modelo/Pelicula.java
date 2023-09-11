package modelo;


public class Pelicula {
	private int idPelicula;
	private String pelicula;
	private Genero genero;
	public Pelicula(int idPelicula, String pelicula, Genero genero) {
		super();
		this.idPelicula = idPelicula;
		this.setPelicula(pelicula);
		this.genero = genero;
	}
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		if(!pelicula.equals("")){
			this.pelicula = pelicula;
		}
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public boolean equals(Pelicula pelicula) {
	
		return idPelicula == pelicula.getIdPelicula() && pelicula.getPelicula().equals(this.getPelicula());
	}
	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", pelicula=" + pelicula + ", genero=" + genero + "]";
	}
	
}
