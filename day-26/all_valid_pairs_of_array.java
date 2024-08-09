import java.util.Scanner;



public class all_valid_pairs_of_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];  
        int i=0;
        while (n!=0) { 
            arr[i] = sc.nextInt();
            i++;
            n--;
        } 
        sc.close();
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }
    public int allValidPermutations(int[] arr){
        return -1;
    }

}
