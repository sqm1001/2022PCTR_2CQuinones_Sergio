package cv2;

public interface IJuego {

	public void añadirEnemigo(int enemigoAñadido);
	
	public void eliminarEnemigo(int enemigoEliminado);

	public void setEnemigos(int nEnemigos);
	
	public void setEnemigosMaximos(int nEnegimosMax);
	
	public int getEnemigosMaximos();
	
	public int getnTotalEnemigos();
	
	public int comprobarAntesDeGenerar(int enemigoAñadido);

	public int comprobarAntesDeEliminar(int enemigoEliminado);
}
