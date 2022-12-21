import java.util.Calendar;
import java.util.Random;
public class Sorting {
    public static long bubbleSort(int[] in){
        Calendar c = Calendar.getInstance();
        long startTime = c.getTimeInMillis();
        boolean sorted = false;
        int temp;
        for(int i= 1;i<in.length&&!sorted; i++){
            sorted=true;
            for(int j=0;j<in.length-i;j++){
                if(in[j]>in[j+1]){
                    temp=in[j];
                    in[j]=in[j+1];
                    in[j+1]=temp;
                    sorted = false;
                }
            }

        }
        Calendar c2 = Calendar.getInstance();
        long endTime = c2.getTimeInMillis();
        return endTime-startTime;
    }
    public static long insertionSort(int[]arr){
        Calendar c = Calendar.getInstance();
        long startTime = c.getTimeInMillis();
        
        for(int unsorted = 1;unsorted<arr.length;unsorted++){
            int NextItem = arr[unsorted];
            int Loc = unsorted;
            for(;(Loc>0)&&(arr[Loc-1]>NextItem);--Loc){
                arr[Loc]=arr[Loc-1];

            }
            arr[Loc]=NextItem;
        }
        Calendar c2 = Calendar.getInstance();
        long endTime = c2.getTimeInMillis();
        return endTime-startTime;
    }
    public static long selectionSort(int[]arr){
        Calendar c = Calendar.getInstance();
        long startTime = c.getTimeInMillis();
        
        for(int i= 0;i<arr.length-1;i++){
            int minIndex = i;
            int minValue = arr[i];
            for(int j= i+1;j<=arr.length-1;j++){
                if(minValue>arr[j]){
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex]=temp;
        }
        Calendar c2 = Calendar.getInstance();
        long endTime = c2.getTimeInMillis();
        return endTime-startTime;
    }
    public static long MergeSort(int Ar[],int first, int last){
        Calendar c = Calendar.getInstance();
        long startTime = c.getTimeInMillis();
        MergeSortR(Ar,first,last);
        Calendar c2 = Calendar.getInstance();
        long endTime = c2.getTimeInMillis();
        return endTime-startTime;
    }
    public static void MergeSortR(int Ar[],int first, int last){
        
        if(first<last){
            int mid = (first+last)/2;
            MergeSortR(Ar,first,mid);
            MergeSortR(Ar,mid+1,last);
            Merge(Ar,first,mid,last);
        }

       
        
    }
    public static void Merge(int Ar[],int first, int mid, int last){
        int[] tempArray = new int[Ar.length];

        int first1 = first;
        int last1 = mid;
        int first2 = mid+1;
        int last2 = last;

        int index = first1;
        for(;(first1<=last1)&&(first2<=last2);++index){
            if(Ar[first]<Ar[first2]){
                tempArray[index]=Ar[first1];
                ++first1;

            }
            else{
                tempArray[index]=Ar[first1];
                ++first2;
            }
        }
    }
    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void main(String[]args){
        
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
    }
}
