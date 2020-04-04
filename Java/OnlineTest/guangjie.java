package OnlineTest;
import java.util.Scanner;
import java.util.Stack;
public class guangjie
{
        public static void main(String[] args) {
//            ThreadLocal
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();
            int[] leftLook=new int[n],rightLook = new int[n];
            int j;
            for(int i=0;i<n;i++){
                j = n-1-i;
                leftLook[i] = st1.size(); rightLook[j] = st2.size();
                while (!st1.isEmpty()&&st1.peek()<=arr[i]) st1.pop();
                while (!st2.isEmpty()&&st2.peek()<=arr[j]) st2.pop();
//                System.out.println(st1.peek());
                st1.push(arr[i]); st2.push(arr[j]);
            }
            for(int i=0;i<n;i++) System.out.print(leftLook[i]+rightLook[i]+1+" ");
        }
    }

