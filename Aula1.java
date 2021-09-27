//aula 1
//Utilizar uma variável do tipo volatile no código da Aula 2 para compartilhar dados entre as Threads.
//A entrega deve ser um repositório do GitHub com o arquivo Java.

public class Main {

	public static void main(String[] args) {
		
		MinhaThread mT1 = new MinhaThread(1);
		MinhaThread mT2 = new MinhaThread(2);
		MinhaThread mT3 = new MinhaThread(3);
		
		
//		mT1.setPriority(Thread.MIN_PRIORITY);
//		mT2.setPriority(Thread.MAX_PRIORITY);
		
		mT1.start();
		mT2.start();
		mT3.start();
		
//		for (int i = 0; i<Integer.MAX_VALUE; i++) {
//			System.out.println("Contador externo: "+i);
//		}
		
	}

}

class MinhaThread extends Thread{
	private volatile static int vol = 0;
	int numThread = 0;
	MinhaThread(int num) {
		this.numThread = num;
	}
	
	public void run() {
//		for (int i= 0; i<Integer.MAX_VALUE; i++) {
//			//System.out.println("Contador externo: "+i);
//			
//		}
		
		System.out.println(this.getName());
		
		for(int c = 0; c < 4; c++) {
    
			if(this.getName().equals("Thread-0")) {
			     System.out.println("Valor de num (T1)): " + vol);
			     vol = 1;
			 } else if(this.getName().equals("Thread-1")){
			     System.out.println("Valor do num (T2):" + vol);
			     vol = 2;
			 } else {
			     System.out.println("Valor do num (T3):" + vol);
			     vol = 3;
			 }
       
		}	
	}
}
