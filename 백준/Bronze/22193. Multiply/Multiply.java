import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
		
		System.out.print(new BigInteger(in.readLine()).multiply(new BigInteger(in.readLine())).toString());
		
	}

}
