Aufgabe: Implementiere den Bubble-Sort in Java und in RAL.

package ram;

public class BubbleSort {
	 
    public static void main(String[] args) {
            int r1[]={2,5,11,7,24,8,9,11};

            // gibt den Array in der ursprünglichen Reihenfolge aus:
            for(int i=0; i<=r1.length-1; i++) {
                    System.out.print(r1[i]+" ");
            }
            System.out.println("\n");

            // gibt den der Grösse nach geordneten Array aus:
            for(int i=0; i<=r1.length-1; i++) {
                    System.out.print(BubbleSort.bubbleSort(r1)[i]+" ");
            }
    }
    public static int[] bubbleSort(int[] a) {
            int l=a.length;
            boolean flagSwap=false;

            do {
                    flagSwap=false;
                    for (int i=0; i<l-1; i++) {
                            if (a[i]>a[i+1]) {
                                    flagSwap=true;
                                    int temp=a[i];
                                    a[i]=a[i+1];
                                    a[i+1]=temp;
                            }
                    }
            } while(flagSwap==true);
            return a;
    }
}
