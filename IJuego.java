package cv2;

public interface IJuego {

	public void a�adirEnemigo(int enemigoA�adido);
	
	public void eliminarEnemigo(int enemigoEliminado);

	public void setEnemigos(int nEnemigos);
	
	public void setEnemigosMaximos(int nEnegimosMax);
	
	public int getEnemigosMaximos();
	
	public int getnTotalEnemigos();
	
	public int comprobarAntesDeGenerar(int enemigoA�adido);

	public int comprobarAntesDeEliminar(int enemigoEliminado);
}
