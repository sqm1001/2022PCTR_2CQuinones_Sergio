package cv2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ActividadAliada implements Runnable{

	IJuego juego;			//Interfaz del juego
	int enemigoEliminado;	//Tipo de Enemgio eliminado
	int numeroEnemigos;		//Número de enemigos que hay por cada tipo
	
	//Constructor del hilo
	public ActividadAliada(int enemigoEliminado,IJuego juego, int numeroEnemigos ) {
		this.juego=juego;
		this.enemigoEliminado=enemigoEliminado;
		this.numeroEnemigos=numeroEnemigos;
	}
	
	//Tarea del hilo
	@Override
	public void run() {
		for(int i=0; i<this.numeroEnemigos;i++) {
			juego.eliminarEnemigo(this.enemigoEliminado);

			//Sleep
			try {
				TimeUnit time = TimeUnit.SECONDS;
				time.sleep(new Random().nextInt(5) + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	

		}
	}

}
