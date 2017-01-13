import java.util.Random;
public class Bozosort {
	private static boolean isSorted(int[] array){
		for(int i=1; i<array.length; i++){
			if(array[i]<array[i-1])
				return false;
		}
		return true;
	}//standard function to verify if array is sorted
	private static void swap(int[] array, int i, int j){
		if(i==j)
			return;
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}//swaps two numbers in an array
	private static int[] bozosort(int[] array){
		Random rand=new Random();
		int i=rand.nextInt(array.length);
		int j=rand.nextInt(array.length);//decides which indexes to swap
		while(!isSorted(array)){
			if(i!=j)
				swap(array,i,j);
			i=rand.nextInt(array.length);
			j=rand.nextInt(array.length);//swaps two random numbers until array is sorted
		}
		return array;
	}//this is an artistically bad sorting algorithm
	public static void main(String[] args){
		//int[] array={1,2,1,2,1,2,1,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2};
		Random rand=new Random();
		//int[] array=new int[rand.nextInt(50)+1];
		int[] array=new int[8];
		for(int i=0; i<array.length; i++)
			array[i]=rand.nextInt(50)+1;
		long start=System.currentTimeMillis();
		array=bozosort(array);
		for(int i:array)
			System.out.print(i+" ");
		long end=System.currentTimeMillis();
		float duration=(float)(end-start)/1000;
		if(duration<60)
			System.out.println("\nTook "+duration+" seconds to sort "+array.length+" numbers.");
		else{
			int minutes=(int)duration/60;
			float seconds=duration%60;
			if((int)duration==1){
				System.out.println("\nTook "+minutes+" minute and "+seconds+" seconds to sort "+array.length+" numbers.");				
			}
			else{
				System.out.println("\nTook "+minutes+" minutes and "+seconds+" seconds to sort "+array.length+" numbers.");
			}
		}
	}
}