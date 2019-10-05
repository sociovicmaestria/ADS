package principal;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.Vector;


public class ExponentialMejora {

        public ArrayList<Long> lista;
    
	public static void main(String[] args) {
		long N = 80;
		ExponentialMejora exponential = new ExponentialMejora();
                exponential.lista = new ArrayList<Long>();
		Stopwatch stopwatch = Stopwatch.createStarted();
		for (int i = 1; i <= N; i++) {
			try {
				long fibonacci = exponential.fibonacci(i);
				System.out.println(i + " => " + fibonacci);
			} catch (Exception e) {
				e.printStackTrace();
			}
                }
		System.out.println(String.format("Time elapsed: %d seconds", stopwatch.elapsed(TimeUnit.SECONDS)) + "\n");
	}
	
	public long fibonacci(int n) throws Exception {
            if (n < 0) {
                throw new Exception("N can not be less than zero");
            }
            if (n <= 2) {
                int m = n-1;
                lista.add(m, 1L);
                return 1;
            }else{
            
                int m = n-1;
                lista.add(m,lista.get(m-1) + lista.get(m-2));
                return lista.get(m);
            //return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
}
