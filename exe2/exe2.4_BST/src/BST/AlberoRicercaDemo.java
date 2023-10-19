package BST;
import java.util.LinkedList;


public class AlberoRicercaDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlberoBR diz = new AlberoBR();
		
		System.out.println("insert(12,6)");	diz.insert(12,6);
			

		System.out.println("insert(8,4)");	diz.insert(8,4);
		
		System.out.println("insert(6,3)");	diz.insert(6,3);
		
		System.out.println("insert(4,2)");	diz.insert(4,2);
		
		System.out.println("insert(2,1)");	diz.insert(2,1);
		
		System.out.println("insert(10,5)");	diz.insert(10,5);
		
		System.out.println("insert(14,7)");	diz.insert(14,7);
		
		LinkedList visita = (LinkedList) diz.inorder();
		for (Object r : visita){  
		System.out.print(((Record) r ).toString());
		}
		System.out.println();
		
		System.out.println("search(5)="+diz.search(5));
		System.out.println("search(3)="+diz.search(3));
		System.out.println("search(6)="+diz.search(6));
		System.out.println("search(8)="+diz.search(8));
		System.out.println();


		System.out.println("delete(6)"); diz.delete(6);
		visita = (LinkedList) diz.inorder();
		for (Object r : visita){  
		System.out.print(((Record) r ).toString());	}			
		System.out.println();
		
        System.out.println("delete(3)"); diz.delete(3);
        visita = (LinkedList) diz.inorder();
		for (Object r : visita){  
		System.out.print(((Record) r ).toString());	}			
		System.out.println();
						
		
        System.out.println("delete(1)"); diz.delete(1);
        visita = (LinkedList) diz.inorder();
		for (Object r : visita){  
		System.out.print(((Record) r ).toString());	}			
		System.out.println();				
		
        System.out.println("delete(8)"); diz.delete(8);
        visita = (LinkedList) diz.inorder();
		for (Object r : visita){  
		System.out.print(((Record) r ).toString());	}			
		System.out.println();
		
		//****************************************//
		System.out.println("****************************************");
		System.out.println("exe 3");
		System.out.println("");

		AlberoBR diz2 = new AlberoBR();

		
		/*System.out.println("insert(12,6)");*/	diz2.insert(12,6);
		

		/*System.out.println("insert(8,4)");*/	diz2.insert(8,4);
		
		/*System.out.println("insert(6,3)");*/	diz2.insert(6,3);
		
		/*System.out.println("insert(4,2)");*/	diz2.insert(4,2);
		
		/*System.out.println("insert(2,1)");*/	diz2.insert(2,1);
		
		/*System.out.println("insert(10,5)");*/	diz2.insert(10,5);
		
		/*System.out.println("insert(14,7)");*/	diz2.insert(14,7);
		
		LinkedList visita2 = (LinkedList) diz2.inorder();
		for (Object r : visita2){  
		System.out.print(((Record) r ).toString());
		}
		System.out.println();
						
		System.out.println("Predecessore di (6)" + diz2.pred(6).toString());
		System.out.println("Predecessore di (7)" + diz2.pred(7).toString());
		System.out.println("Predecessore di (4)" + diz2.pred(4).toString());

		System.out.println("Successore di (6)" + diz2.succ(6).toString());
		System.out.println("Successroe di (1)" + diz2.succ(1).toString());
		System.out.println("Successroe di (5)" + diz2.succ(5).toString());
		
		System.out.println("__________");
		System.out.println("Intersezione:");
		
		AlberoBR diz3 = new AlberoBR();
		diz3.insert(1,5);
		diz3.insert(2,3);
		diz3.insert(3,7);
		diz3.insert(4,4);
		diz3.insert(5,6);
		diz3.insert(6,2);
		diz3.insert(4,8);
		
		LinkedList visita3 = (LinkedList) diz3.inorder();
		for (Object r : visita3){  
		System.out.print(((Record) r ).toString());
		}
		System.out.println();
		
		AlberoBR diz4 = new AlberoBR();
		diz4.insert(1,5);
		diz4.insert(2,3);
		diz4.insert(3,7);
		diz4.insert(4,8);
		
		LinkedList visita4 = (LinkedList) diz4.inorder();
		for (Object r : visita4){  
		System.out.print(((Record) r ).toString());
		}
		System.out.println();
		
		AlberoBR diz3_int_diz4 = new AlberoBR();
				
		diz3_int_diz4 = diz3_int_diz4.intersezione(diz3, diz4);
		
		LinkedList visita5 = (LinkedList) diz3_int_diz4.inorder();
		for (Object r : visita5){  
		System.out.print(((Record) r ).toString());
		}
		System.out.println();


	}

}
