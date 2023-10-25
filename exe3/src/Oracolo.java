
import java.util.Arrays;

/*
 * Definire un algoritmo che, dato in input un array X di n interi in [1,k], 
 * processa X in modo da poter poi rispondere a domande del tipo: 
 * 
 * “Quanti interi di X cadono nell’intervallo [a,b]?”, 
 * per a e b qualsiasi (anche non appartenenti a X).
 * 
 * • L’algoritmo deve richiedere tempo di pre-processamento O(n+ k) 
 *   per costruire l’oracolo (un array Y) 
 * 		– costruisciOracolo (X, k): Y
 * • Mentre l’oracolo deve poter poi rispondere in tempo O(1) alla domanda 
 * 		– interrogaOracolo (Y, k, a, b): c
 */


public class Oracolo {
	
	/**
	 * costruisce l'array oracolo dato in input un array X di n interi in [1,k]
	 * 
	 * @param X array di n interi
	 * @param k intervallo nel quale sono definiti gli n interi (max di n)
	 * @return Y l'array di interi oracolo
	 * 
	 * O(n+k) in tempo , O(k) in spazio
	 */
	public static int[] costruisciOracolo(int[] X, int k) {
		
		int Y[] = new int[k + 1];
		for (int i = 0; i < Y.length; i++) {
			Y[i]=0;
		}
		
		for(int x : X) {
			Y[x] += 1;
		}
		
		// salvo in Y la somma cumulativa
		for(int i=1; i<Y.length; i++) {
			Y[i] += Y[i-1];
		}
		
		return Y;
	}
	
	/**
	 * risponde alla domanda: 
	 * "Quanti interi di X cadono nell’intervallo [a,b]?”, 
	 * per a e b qualsiasi (anche non appartenenti a X).
	 * 
	 * @param Y array oracolo creato con costruisciOracolo(int[] X, int k)
	 * @param k intervallo nel quale sono definiti gli n interi (max di n)
	 * @param a estremo inferiore dell'inteervallo [a,b]
	 * @param b estremo superiore dell'inteervallo [a,b]
	 * @return c numero di interi di X array di partenza che cadono nell’intervallo [a,b]
	 * 
	 * O(1) in tempo e spazio
	 */
	public static int interrogaOracolo (int Y[], int k, int a, int b) {
		int c = 0;
		if(a == b) return 0;
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		if(a < Y[0]) a = Y[0];
		if(b > k) b = k+1;
		
		c = (a>0) ?	 Y[b-1] - Y[a-1] : Y[b-1];
		
		return c;
	}
	
	public static void main(String[] args) {
		
		int X1 [] = new int[] {1,2,5,2,4,3,2,6,2,5};
		int k1 = 6;
		
		int Y1 [] = costruisciOracolo(X1, k1);
		
		System.out.println("X1: " + Arrays.toString(X1));
		System.out.println("Quanti interi di X1 cadono nel: ");
		System.out.println("intervallo [a,b] = [1,5]: " + interrogaOracolo (Y1, k1, 1, 5));
		System.out.println("intervallo [a,b] = [1,2]: " + interrogaOracolo (Y1, k1, 1, 2));
		System.out.println("intervallo [a,b] = [1,3]: " + interrogaOracolo (Y1, k1, 1, 3));
		System.out.println("intervallo [a,b] = [4,6]: " + interrogaOracolo (Y1, k1, 4, 6));
		System.out.println("intervallo [a,b] = [1,6]: " + interrogaOracolo (Y1, k1, 1, 6));
		System.out.println("intervallo [a,b] = [1,8]: " + interrogaOracolo (Y1, k1, 1, 8));
		System.out.println("intervallo [a,b] = [0,6]: " + interrogaOracolo (Y1, k1, 0, 8));
		System.out.println("intervallo [a,b] = [3,10]: " + interrogaOracolo (Y1, k1, 3, 10));

	}

}
