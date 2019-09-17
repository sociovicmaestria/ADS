package pe.edu.unmsm.fisi.upg.ads.big_o_notation_java;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

// ----- ALGORITMO FIBONACCI USANDO PROGRAMACIÓN DINÁMICA ----- //

public class Fibonacci_Dinamica {
	
	//ArrayList<Long> memoria;
	
	HashMap<Integer,Long> memoria;
	

	public static void main(String[] args) {
		long N = 80;
		Fibonacci_Dinamica exponential = new Fibonacci_Dinamica();
		Stopwatch stopwatch = Stopwatch.createStarted();
		for (int i = 1; i <= N; i++) {
			try {
				exponential.reiniciar_Memoria();
				long fibonacci = exponential.fibonacci(i);
				System.out.println(i + " => " + fibonacci);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
		System.out.println(String.format("Time elapsed: %d seconds", stopwatch.elapsed(TimeUnit.SECONDS)) + "\n");
	}
	
	public void reiniciar_Memoria(){
		//memoria=new ArrayList<Long>();
		memoria=new HashMap<Integer,Long>();
	}
	
	public long fibonacci(int n) throws Exception {
        if (n < 0) {
            throw new Exception("N can not be less than zero");
        }
        if (n <= 2) {
            return 1;
        }
        int m = n-1;
        if(memoria.get(m)==null){
        	//memoria.add(m, (fibonacci(n - 1) + fibonacci(n - 2)));
        	memoria.put(m, (fibonacci(n - 1) + fibonacci(n - 2)));
        }
        
        return memoria.get(m);
        
    }
}
