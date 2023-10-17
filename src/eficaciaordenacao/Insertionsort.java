package eficaciaordenacao;

public class Insertionsort {
    
    //variável para contar a quantidade de trocas e comparações feitas
    public static long trocasInsertion = 0;
    public static long comparacoesInsertion = 0;
    
    //algoritmo disponibilizado pelo professor
    public static void ordena(int[] v, int i) {
	    if(i == v.length)
	        return;
	        
	    for(int c = i; c > 0; c--){
                comparacoesInsertion++; // contar as comparações
	        if(v[c-1] > v[c]){
	            int aux = v[c-1];
	            v[c-1] = v[c];
	            v[c] = aux;
                    trocasInsertion ++; //contar as trocas 
	        }
	    }
	    ordena(v, ++i);
	}
}
