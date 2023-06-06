package cv2;

import java.util.HashMap;
import java.util.Set;

public class SistemaLanzador {

	public static void main(String[] args) throws InterruptedException {
		
		final int N_TiposEnemigos = 4;			//Numero de tipos de Enemigos
		final int N_Eventos= 4;					//Numero de asesinatos/union enemios
		final int nMaximoEnemigos = 7;			//Numero maximo de enemigos que puede haber en el juego a la vez
		
		
		
//		//Crea el juego y establece la cantida de tipos de enemigos que tiene y el numero maximo de enemigos por cada tipo
		IJuego juego=ReglasJuego.getInstancia(); //unica instancia del juego
		juego.setEnemigos(N_TiposEnemigos);
		juego.setEnemigosMaximos(nMaximoEnemigos);
		HashMap<Integer, Integer> enemigos = inicializarENemigos(N_TiposEnemigos);
		
		for(int i=0;i<N_Eventos;i++) {
			
			Thread generar = new Thread(new ActividadEnemiga(i,juego,enemigos.get(i)));			
			generar.start(); //Lanza generar enemigo
			
			Thread eliminar = new Thread(new ActividadAliada(i,juego,enemigos.get(i)));			
			eliminar.start(); //Lanza eliminar enemigo
		}
		
	}


	/**
	 *Método que inicializa un mapa con los tipos de enemigos que hay u la cantidad de cada uno
	 *@param numeroEnemigos
	 * @return
	 */
	private static HashMap<Integer,Integer> inicializarENemigos(int numeroEnemigos){
		
		HashMap<Integer, Integer> enemigos = new HashMap<Integer, Integer>();
		for(int i = 0; i<numeroEnemigos;i++) {
			enemigos.put(i,numeroEnemigos-i);
		}
		
		System.out.println("4 tipos de enemigos: ");
		Set<Integer> keys = enemigos.keySet();
		for(Integer clave: keys){
		    System.out.println("Enemigos de tipo : " + clave + ": " + enemigos.get(clave));
		}
		System.out.println("");
		System.out.println("");
		return enemigos;
	}
}
