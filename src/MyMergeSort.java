
public class MyMergeSort {
	
	private int[] array;
	private int[] tempMergeArr;
	private int length; 
	

	public static void main(String[] args) {
		int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
		MyMergeSort mms= new MyMergeSort();
		mms.Sort(inputArr);
		for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }

}

public void Sort(int[] inputArr) {
	this.array= inputArr;
	this.tempMergeArr= new int[inputArr.length];
	this.length = inputArr.length;
	doMergeSort(0, length - 1);
}

private void doMergeSort(int lowerIndex, int higherIndex) {
	if (lowerIndex<higherIndex) {
		int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
		
		doMergeSort(lowerIndex, middle);
		doMergeSort(middle + 1, higherIndex);
		mergeparts(lowerIndex, middle, higherIndex);
		
	}
}

private void mergeparts(int lowerIndex, int middle, int higherIndex) {
	
	for(int i= lowerIndex; i<= higherIndex; i++) 
		tempMergeArr[i] = array[i];
	
	int i= lowerIndex;
	int j= middle + 1;
	int k = lowerIndex;
	
	while (i <= middle && j <= higherIndex) {
		if(tempMergeArr[i] <= tempMergeArr[j]) {
			array[k] = tempMergeArr[i];
			i++;
		} else {
			array[k] = tempMergeArr[j];
		j++;
		}
		k++;
	}

	while (i <= middle){
		array[k] = tempMergeArr[i];
		i++;
		k++;
	}
}
}