import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//import jdk.internal.net.http.common.Pair;

//import jdk.internal.org.jline.utils.InputStreamReader;

/**
 * Main
 */
public class Main {

    private static class Pair {
        int value ;
        int count ;
        public Pair(int value , int count) {
            this.value = value ;
            this.count = count ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in)) ;
        int n = Integer.parseInt(read.readLine()) ;
        String[] str = read.readLine().trim().split(" ") ;
        int[] arr = new int[n] ;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(str[i]) ;
        }

        Stack<Pair> leftStack = new Stack<>() ;
        int[] arrLeft = new int[n] ;
        for(int i=0; i<n; i++) {
            int temp = 1 ;
            while (!leftStack.isEmpty() && leftStack.peek().value > arr[i]) {
                temp += leftStack.pop().count ;
            }
            leftStack.push(new Pair(arr[i], temp)) ;
            arrLeft[i] = temp ;
            

        }
        Stack<Pair> righStack = new Stack<>() ;
        int[] arrRight = new int[n] ;
        for(int i=n-1; i>=0; i--) {
            int temp = 1 ;
            while (!righStack.isEmpty() && righStack.peek().value >= arr[i]) {
                temp += righStack.pop().count ;
            }
            righStack.push(new Pair(arr[i], temp)) ;
            arrRight[i] = temp ;
            
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.println(arrLeft[i] + " " + arrRight[i]);
        // }

        long result = 0L ;
        for(int i=0; i<n; i++) {
            result += arr[i] * arrLeft[i] * arrRight[i] ;
        }

        System.out.println(result);
        
        
        
        
    }
}