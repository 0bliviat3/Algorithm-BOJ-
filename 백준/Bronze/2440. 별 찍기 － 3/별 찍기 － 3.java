import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ans.append('*');
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
    
}