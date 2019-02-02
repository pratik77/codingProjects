import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GP {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	
        HashMap<Long, Long> hm = new HashMap();
        HashMap<Long, Long> hm1 = new HashMap();
        long siz2 = 1;
        long totalCount = 0;
        for(long i : arr){
            if( i % r == 0 && hm.containsKey(i / r)){
                siz2 = hm1.getOrDefault(i / r, 0L);
                totalCount += siz2;
                hm1.put(i, hm.get(i / r) + hm1.getOrDefault(i, 0L));
            }
            
            hm.put(i, hm.getOrDefault(i, 0L) + 1);
            
        }
        
        return totalCount;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans);
        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        bufferedReader.close();
       // bufferedWriter.close();
    }
}
