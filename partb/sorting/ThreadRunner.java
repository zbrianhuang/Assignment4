
import java.util.Random;
import java.lang.Thread;
import java.util.Calendar;
public class ThreadRunner extends Thread{
    int selectedSortMethod;
    int[]arr;
    long startTime,endTime;
    public long bubbleSort(int[] in){
        long bubbleStartTime = System.currentTimeMillis();
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
        long bubbleEndTime = System.currentTimeMillis();
        long bubbleFinalTime = bubbleEndTime-bubbleStartTime;
        return bubbleFinalTime;
        
    }
    public void insertionSort(int[]arr){
        
        for(int unsorted = 1;unsorted<arr.length;unsorted++){
            int NextItem = arr[unsorted];
            int Loc = unsorted;
            for(;(Loc>0)&&(arr[Loc-1]>NextItem);--Loc){
                arr[Loc]=arr[Loc-1];

            }
            arr[Loc]=NextItem;
        }
    }
    public void selectionSort(int[]arr){
        
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
        
    }
    public void MergeSort(int Ar[],int first, int last){
        
        MergeSortR(Ar,first,last);
        
    }
    public void MergeSortR(int Ar[],int first, int last){
        
        if(first<last){
            int mid = (first+last)/2;
            MergeSortR(Ar,first,mid);
            MergeSortR(Ar,mid+1,last);
            Merge(Ar,first,mid,last);
        }

       
        
    }
    public void Merge(int Ar[],int first, int mid, int last){
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
    public ThreadRunner (int in,int[]arr){
        selectedSortMethod= in;
        this.arr = arr;
        
    }
    public void run(){
        startTime = System.currentTimeMillis();
        
        
        System.out.println(bubbleSort(arr)+"ms");
        endTime = System.currentTimeMillis();
        System.out.println(printString());
    }
    public String printString(){
        long finalTime = endTime-startTime;
        String builder = "Printing: "+Thread.currentThread()+" ";
        builder+="\ncompleted in: "+finalTime+"ms";
        return builder;
    }
    public String printArr(){
        String builder="";
        for(int i:arr){
            builder+=i;
            builder+=" ";
        }
        return builder;
    }
}
