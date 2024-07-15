import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[3];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] > n) {
                sum += n;
                continue;
            }
            sum += arr[i];
        }

        System.out.print(sum);       
    }
}