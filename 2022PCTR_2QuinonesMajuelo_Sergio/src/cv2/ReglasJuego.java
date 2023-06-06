package cv2;

public class ReglasJuego implements IJuego {
	
	IJuego juego;													//Interfaz Juego
	final int enemigosMin = 0;										//Numero minimo de enemigos que puede haber (no puedo haber menos de 0)
	public static ReglasJuego instancia = new ReglasJuego();		//Unica Instancia de las reglas juego

	
	//Constructo del Objeto ReglasJuego
	private ReglasJuego() {
		juego = new Juego();
	}
	
	
	//Funcion para asegurar una unica instancia del Juego
	public static ReglasJuego getInstancia() {
		return instancia;
	}
	
	//Metodo para añadir enemigos al juego de manera sincrona
	@Override
	public synchronized void añadirEnemigo(int enemigoAñadido) {
		
		//Switch para cumplir la precondicion de añadir enemigos
		switch(enemigoAñadido) {
		case 1:
			//Espera hasta que se pueda añadirr algun enemigo de su tipo
			while(juego.comprobarAntesDeGenerar(0) == 0 && juego.comprobarAntesDeEliminar(0) == 0 ) {
				try {
					wait();
				} catch (InterruptedException e) {	//Captura excepcion
					e.printStackTrace();
				}
			}
			break;
		case 2:
			while(juego.comprobarAntesDeGenerar(1) == 0 && juego.comprobarAntesDeEliminar(1) == 0) {
				try {
					wait();
				} catch (InterruptedException e) {	//Captura excepcion
					e.printStackTrace();
				}
			}
			break;
		case 3:
			while(juego.comprobarAntesDeGenerar(2) == 0 && juego.comprobarAntesDeEliminar(2) == 0) {
				try {
					wait();
				} catch (InterruptedException e) {	//Captura excepcion
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
		
		
		juego.añadirEnemigo(enemigoAñadido);
		notifyAll();
		
		//PostCondicion
		assert juego.getnTotalEnemigos()<=getEnemigosMaximos() : "Cantidad de Enemigos Superada";
	}

	@Override
	public synchronized void eliminarEnemigo(int enemigoEliminado) {
		
		//Espera hasta que se pueda eliminar algun enemigo de su tipo
		while(juego.comprobarAntesDeEliminar(enemigoEliminado) == enemigosMin) {
			try {
				wait();
			} catch (InterruptedException e) {	//Captura excepcion
				e.printStackTrace();
			}
		}
		
		juego.eliminarEnemigo(enemigoEliminado);
		notifyAll();
		
		//PostCondicion
		assert juego.getnTotalEnemigos()>=enemigosMin : "Se ha eliminado un enemigo que no existia";
		
	}
	
	@Override
	public void setEnemigos(int nEnemigos) {
		juego.setEnemigos(nEnemigos);
	}

	@Override
	public void setEnemigosMaximos(int nEnegimosMax) {
		juego.setEnemigos(nEnegimosMax);
		
	}

	@Override
	public int getEnemigosMaximos() {
		return juego.getEnemigosMaximos();
	}

	@Override
	public int getnTotalEnemigos() {
		return juego.getnTotalEnemigos();
	}


	@Override
	public int comprobarAntesDeEliminar(int enemigoEliminado) {
		return juego.comprobarAntesDeEliminar(enemigoEliminado);
	}


	@Override
	public int comprobarAntesDeGenerar(int enemigoAñadido) {
		return juego.comprobarAntesDeGenerar(enemigoAñadido);
	}




}
