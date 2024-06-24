import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (m % k == 0) {
            System.out.print("Yes");
            return;
        }
        System.out.print("No");
    }
}
