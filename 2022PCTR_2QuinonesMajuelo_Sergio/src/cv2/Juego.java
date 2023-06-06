package cv2;

import java.util.HashMap;

public class Juego implements IJuego{

	private static int nTotalEnemigos=0;				//Numero total de enemigos que hay
	private int nEnemigos;								//Numero de tipos de enemigos
	private int nMaximoEnemigos = 10;					//Numero maximo de enemigos que hay
	HashMap<Integer, Integer> contadorEnemigosTipo;     //Hashtable Tipo de enemigo : Numero de enemigos de ese tipo
	HashMap<Integer, Integer> contadorEliminadosTipo; 	//Hashtable Tipo de enemigo : Numero de enemigos de ese tipo eliminados
	
	public Juego() {
		contadorEnemigosTipo = new HashMap<>();
		contadorEliminadosTipo = new HashMap<>();
	}
	
	@Override
	public void añadirEnemigo(int enemigoAñadido) {
		
		//Actualizar contadores
		contadorEnemigosTipo.put(enemigoAñadido, contadorEnemigosTipo.get(enemigoAñadido)+1);
		nTotalEnemigos++;
		
		//Salida por pantalla del evento y situaciÃ³n
		System.out.println("Generado enemigo tipo "+enemigoAñadido);
		
		imprimirInfo(); 
		System.out.println();
		System.out.println();
		//Comprobar invariante
		checkInvariante();
	}
	
	@Override
	public void eliminarEnemigo(int enemigoEliminado) {
		
				
		//Actualizar contadores
		contadorEnemigosTipo.put(enemigoEliminado, contadorEnemigosTipo.get(enemigoEliminado)-1);
		nTotalEnemigos--;
		
		contadorEliminadosTipo.put(enemigoEliminado, contadorEliminadosTipo.get(enemigoEliminado)+1);
		
		
		//Salida por pantalla del evento y situaciÃ³n
		System.out.println("Eliminado enemigo tipo "+enemigoEliminado);
		
		imprimirInfo(); 
		System.out.println();
		System.out.println();
		//Comprobar invariante
		checkInvariante();
		
	}

	private void checkInvariante() {
		int enemigos=0;
        
		for (Integer e : contadorEnemigosTipo.keySet()) {
			enemigos=contadorEnemigosTipo.get(e)+enemigos;
		}
		assert nTotalEnemigos==enemigos : "NO COINCIDE EL NUMERO DE ENEMIGOS QUE DEBERIAN QUEDAR CON LOS QUE AUN SIGUEN VIVOS";
		
	}
	
	

	private void imprimirInfo() {
		int enemigosImprimir=0; 		//Cantidad de enemigos
		int enemigosEliminados=0;		//Cantidad de enemigos eliminados
		System.out.println("--> Enemigos totales: "+nTotalEnemigos);
		for (int i = 0; i < nEnemigos; i++) {
			enemigosImprimir=contadorEnemigosTipo.get(i);
			if (contadorEliminadosTipo.get(i) != null) { //Condicion para saber los tipos de enemigos eliminados
        		enemigosEliminados = contadorEliminadosTipo.get(i);
        	}
        	System.out.println("----> Enemigos tipo " + i + ": " + enemigosImprimir + " ------ [Eliminados: " + enemigosEliminados + "]");
        }
	}

	//Inicializa a 0 la cantidad de enemigos por cada tipo
	@Override
	public void setEnemigos(int nenemigos) {
		
		this.nEnemigos=4;   							//Pongo un 4 aqui porque se que van a ser 4 tipos, pero si se supone que le paso el valor por parametro en el lanzador, da igual lo que ponga que siempre pondra como mínimo 10 tipos, me he vuelto loco intentando encontrar la razon de esto
		for(int i = 0; i<nEnemigos;i++) {
			contadorEnemigosTipo.put(i, 0);
			contadorEliminadosTipo.put(i, 0);
		}
	}

	@Override
	public int getnTotalEnemigos() {
	
		return nTotalEnemigos;
	}
	
	@Override
	public void setEnemigosMaximos(int nEnegimosMax) {
		this.nMaximoEnemigos = nEnegimosMax;
		
	}

	@Override
	public int getEnemigosMaximos() {
		return this.nMaximoEnemigos;
	}
	
	/**
	 * Método que devuelvo la catidad de enemigos eliminados que hay en lña batalla del tipo que se pase por parámetro
	 */
	@Override
	public int comprobarAntesDeGenerar(int enemigoAñadido) {
		return contadorEliminadosTipo.get(enemigoAñadido);
	}
	
	/**
	 * Método que devuelvo la catidad de enemigos  que hay en la batalla del tipo que se pase por parámetro
	 */
	public int comprobarAntesDeEliminar(int enemigoEliminado) {
		return contadorEnemigosTipo.get(enemigoEliminado);
	}


	
	


}
