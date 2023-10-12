package alberoBinario;
import java.util.LinkedList;

public class AlberoBinarioDemo{
	public static void main(String argc[]){
		System.out.println("alb1=nodo1=1");
		AlberoBinario alb1 = new AlberoBinarioImpl(1);
		NodoBinario nodo1 = alb1.radice();

		System.out.println("alb2=nodo2=2");
		AlberoBinario alb2 = new AlberoBinarioImpl(2);
		NodoBinario nodo2 = alb2.radice();

		System.out.println("alb3=nodo3=3");
		AlberoBinario alb3 = new AlberoBinarioImpl(3);
		NodoBinario nodo3 = alb3.radice();

		System.out.println("alb4=nodo4=4");
		AlberoBinario alb4 = new AlberoBinarioImpl(4);
		NodoBinario nodo4 = alb4.radice();

		System.out.println("alb5=nodo5=5");
		AlberoBinario alb5 = new AlberoBinarioImpl(5);
		NodoBinario nodo5 = alb5.radice();

		System.out.println("alb6=nodo6=6");
		AlberoBinario alb6 = new AlberoBinarioImpl(6);
		NodoBinario nodo6 = alb6.radice();


		System.out.println("alb1.innestaDes(nodo1,alb3)"); alb1.innestaDes(nodo1,alb3);
		System.out.println("alb1.innestaSin(nodo1,alb2)"); alb1.innestaSin(nodo1,alb2);
		System.out.println("alb1.innestaDes(nodo3,alb4)"); alb1.innestaDes(nodo3,alb4);
		System.out.println("alb1.innestaSin(nodo2,alb5)"); alb1.innestaSin(nodo2,alb5);
		System.out.println("alb1.innestaDes(nodo2,alb6)"); alb1.innestaDes(nodo2,alb6);
		
			
		System.out.println("alb1.visitaDFS()"); 
		LinkedList visita = (LinkedList) alb1.visitaDFS();
		System.out.println(visita.toString());

		System.out.println("alb1.visitaBFS()"); 
		visita = (LinkedList) alb1.visitaBFS();
        System.out.println(visita.toString());
/*
		System.out.println("alb8=alb1.potaSinistro(nodo1)"); 
		AlberoBinario alb8 = alb1.potaSinistro(nodo1);
		System.out.println("alb1.visitaDFS()"); 
		visita = (LinkedList) alb1.visitaDFS();
		System.out.println(visita.toString());
		System.out.println("alb8.visitaDFS()"); 
		visita = (LinkedList) alb8.visitaDFS();
		System.out.println(visita.toString());*/
		
		System.out.println("alb1, livello nodo 1: " + alb1.level(nodo1));
		System.out.println("alb1, livello nodo 3: " + alb1.level(nodo3));
		System.out.println("alb1, livello nodo 4: " + alb1.level(nodo4));
		
		System.out.println("atezza: " + alb1.altezza());
		
		System.out.println("numero nodi: " + alb1.numNodi());

		System.out.println("numero foglie: " + alb1.numFoglie());
		
		System.out.println("numero nodi interni: " + alb1.numNodiInterni());

		System.out.println("alb1 = alb1: " + alb1.equals(alb1));
		System.out.println("alb1 = alb2: " + alb1.equals(alb2));
		System.out.println("alb11=nodo11=1");
		AlberoBinario alb11 = new AlberoBinarioImpl(1);
		NodoBinario nodo11 = alb11.radice();

		System.out.println("alb12=nodo12=2");
		AlberoBinario alb12 = new AlberoBinarioImpl(2);
		NodoBinario nodo12 = alb12.radice();

		System.out.println("alb3=nodo3=3");
		AlberoBinario alb13 = new AlberoBinarioImpl(3);
		NodoBinario nodo13 = alb13.radice();

		System.out.println("alb4=nodo4=4");
		AlberoBinario alb14 = new AlberoBinarioImpl(4);
		NodoBinario nodo14 = alb14.radice();

		System.out.println("alb5=nodo5=5");
		AlberoBinario alb15 = new AlberoBinarioImpl(5);
		NodoBinario nodo15 = alb15.radice();

		System.out.println("alb6=nodo6=6");
		AlberoBinario alb16 = new AlberoBinarioImpl(6);
		NodoBinario nodo16 = alb16.radice();
		
		System.out.println("alb11.innestaDes(nodo11,alb13)"); alb11.innestaDes(nodo11,alb13);
		System.out.println("alb11.innestaSin(nodo11,alb12)"); alb11.innestaSin(nodo11,alb12);
		System.out.println("alb11.innestaDes(nodo13,alb14)"); alb11.innestaDes(nodo13,alb14);
		System.out.println("alb11.innestaSin(nodo12,alb15)"); alb11.innestaSin(nodo12,alb15);
		System.out.println("alb11.innestaDes(nodo12,alb16)"); alb11.innestaDes(nodo12,alb16);
		
		System.out.println("alb1.visitaBFS()");
		visita = (LinkedList) alb1.visitaBFS();
        System.out.println(visita.toString());
        
		System.out.println("alb11.visitaBFS()"); 
		visita = (LinkedList) alb11.visitaBFS();
        System.out.println(visita.toString());
        
		System.out.println("alb1 = alb11: " + alb1.equals(alb11));
		
		alb1.potaSinistro(nodo2);
		
		System.out.println("alb1.visitaBFS()");
		visita = (LinkedList) alb1.visitaBFS();
        System.out.println(visita.toString());
        
		System.out.println("alb11.visitaBFS()"); 
		visita = (LinkedList) alb11.visitaBFS();
        System.out.println(visita.toString());
        
		System.out.println("alb1 = alb11: " + alb1.equals(alb11));
		
		alb11.potaSinistro(nodo12);

		System.out.println("alb1.visitaBFS()");
		visita = (LinkedList) alb1.visitaBFS();
        System.out.println(visita.toString());
        
		System.out.println("alb11.visitaBFS()"); 
		visita = (LinkedList) alb11.visitaBFS();
        System.out.println(visita.toString());
        
		System.out.println("alb1 = alb11: " + alb1.equals(alb11));
		
		AlberoBinario alb21 = new AlberoBinarioImpl(1);
		NodoBinario nodo21 = alb21.radice();

		System.out.println("alb22=nodo12=2");
		AlberoBinario alb22 = new AlberoBinarioImpl(2);
		NodoBinario nodo22 = alb22.radice();

		System.out.println("alb23=nodo23=3");
		AlberoBinario alb23 = new AlberoBinarioImpl(3);
		NodoBinario nodo23 = alb23.radice();

		System.out.println("alb24=nodo24=4");
		AlberoBinario alb24 = new AlberoBinarioImpl(4);
		NodoBinario nodo24 = alb24.radice();

		System.out.println("alb25=nodo25=5");
		AlberoBinario alb25 = new AlberoBinarioImpl(5);
		NodoBinario nodo25 = alb25.radice();

		System.out.println("alb26=nodo26=6");
		AlberoBinario alb26 = new AlberoBinarioImpl(6);
		NodoBinario nodo26 = alb26.radice();
		
		System.out.println("alb27=nodo27=7");
		AlberoBinario alb27 = new AlberoBinarioImpl(4);
		NodoBinario nodo27 = alb27.radice();
		
		System.out.println("alb21.innestaDes(nodo21,alb23)"); alb21.innestaDes(nodo21,alb23);
		System.out.println("alb21.innestaSin(nodo21,alb22)"); alb21.innestaSin(nodo21,alb22);
		System.out.println("alb21.innestaDes(nodo23,alb24)"); alb21.innestaDes(nodo23,alb24);
		System.out.println("alb21.innestaSin(nodo22,alb25)"); alb21.innestaSin(nodo22,alb25);
		System.out.println("alb21.innestaDes(nodo22,alb26)"); alb21.innestaDes(nodo22,alb26);
		System.out.println("alb21.innestaSin(nodo22,alb27)"); alb21.innestaSin(nodo23,alb27);
	
		System.out.println("alb21.visitaBFS()");
		visita = (LinkedList) alb21.visitaBFS();
        System.out.println(visita.toString());
        
        System.out.println("elimina foglie uguali:");
        alb21.eliminaFoglieUguali();
        
		System.out.println("alb21.visitaBFS()");
		visita = (LinkedList) alb21.visitaBFS();
        System.out.println(visita.toString());

	}	
}