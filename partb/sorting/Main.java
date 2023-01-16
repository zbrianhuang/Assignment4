import java.util.Calendar;
import java.util.Random;
import java.io.PrintWriter;
public class Main {
    public static void main(String[]args){
        /* 
        long startTime = System.currentTimeMillis();
        int arrSize=100000;
        int[] bubbleArr=new int[arrSize];
        int[] insertionArr=new int[arrSize];
        int[] selectionArr= new int[arrSize];
        int[] mergeArr= new int[arrSize];
        Random r= new Random();
        for(int i= 0;i<arrSize-1;i++){

            int num = r.nextInt(100000);
            bubbleArr[i]=num;
            insertionArr[i]=num;
            selectionArr[i]=num;
            mergeArr[i]=num;
        }
        // printArray(mergeArr);
        
        System.out.println("Bubblesort ("+ arrSize+"items):"+bubbleSort(bubbleArr)+"ms");
        System.out.println("Insertionsort ("+ arrSize+"items):"+insertionSort(insertionArr)+"ms");
        System.out.println("Selectionsort ("+ arrSize+"items):"+selectionSort(selectionArr)+"ms");
        
        System.out.println("Mergesort ("+ arrSize+"items):"+MergeSort(mergeArr,0,mergeArr.length-1)+"ms");
        //printArray(mergeArr);
        
        long endTime = System.currentTimeMillis();
        System.out.println("Completed in "+(double)(endTime-startTime)/1000+" seconds.");
    */
    

    int arrSize = 50000;
    int arrCount = 50;
    int[][] arr= new int[arrCount][arrSize];
    int [][] nonThreadArr = new int[arrCount][arrSize];
    Random r = new Random();
    for(int j= 0;j<arrCount;j++){
        for(int i= 0;i<arrSize-1;i++){
            int temp = r.nextInt(100);
            arr[j][i] = temp;
            nonThreadArr[j][i]=temp;
        }
    }

   
        long threadStartTime = System.currentTimeMillis();
        for(int i= 0;i<arrCount;i++){
        ThreadRunner run = new ThreadRunner(1,arr[i]);
        run.start();
        }
        long threadEndTime = System.currentTimeMillis();
        long endTime = threadEndTime-threadStartTime;
       
   
        //System.out.println(r.toString());
   
        long noThreadStartTime = System.currentTimeMillis();
        for(int i= 0;i<arrCount;i++){
            Sorting s= new Sorting(nonThreadArr[i]);
            System.out.println(s.bubbleSort()+"ms");
            

            }
        long noThreadEndTime = System.currentTimeMillis();
        long noThreadfinalTime= noThreadEndTime-noThreadStartTime;
        System.out.println("NonThreaded Final Time: "+noThreadfinalTime+"ms");
    
    }

}

