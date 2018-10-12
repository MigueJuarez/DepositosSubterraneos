package depositosSubterraneos;

public class Deposito {
	
	private int dimension;	
	private int profundidad;
	private int volumen;
	private int volumenRelativo;
	
	public Deposito(int dimension, int profundidad) {
		super();
		this.dimension = dimension;
		this.profundidad = profundidad;
		
		volumen = dimension * profundidad;
	}

	protected int getVolumenRelativo() {
		return volumenRelativo;
	}

	protected void setVolumenRelativo(int volumenRelativo) {
		this.volumenRelativo = volumenRelativo;
	}

	protected int getDimension() {
		return dimension;
	}

	protected void setDimension(int dimension) {
		this.dimension = dimension;
	}

	protected int getVolumen() {
		return volumen;
	}

	protected void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	protected int getProfundidad() {
		return profundidad;
	}

	protected void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}
	

}
