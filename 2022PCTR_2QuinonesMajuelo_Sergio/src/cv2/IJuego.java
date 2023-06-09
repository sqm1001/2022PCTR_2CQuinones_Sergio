package cv2;

public interface IJuego {

	public void aņadirEnemigo(int enemigoAņadido);
	
	public void eliminarEnemigo(int enemigoEliminado);

	public void setEnemigos(int nEnemigos);
	
	public void setEnemigosMaximos(int nEnegimosMax);
	
	public int getEnemigosMaximos();
	
	public int getnTotalEnemigos();
	
	public int comprobarAntesDeGenerar(int enemigoAņadido);

	public int comprobarAntesDeEliminar(int enemigoEliminado);
}
