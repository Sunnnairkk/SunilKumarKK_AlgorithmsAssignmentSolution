package AlgorithmsAssignmentSolutionPart2;

public class MergeSort {

	private double[] sortedArray;
	
	public void merge(double[] dArr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		double[] leftArray = new double[n1];
		double[] rightArray = new double[n2];

		for (int i = 0; i < n1; ++i)
			leftArray[i] = dArr[left + i];
		
		for (int j = 0; j < n2; ++j)
			rightArray[j] = dArr[mid + 1 + j];

		int i = 0, j = 0;

		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				dArr[k] = leftArray[i];
				i++;
			} 
			else {
				dArr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			dArr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			dArr[k] = rightArray[j];
			j++;
			k++;
		}
		
		setSortedArray(new double[dArr.length]);
		setSortedArray(dArr);
	}
	
	public void sort(double[] dArr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			sort(dArr, left, mid);
			sort(dArr, mid + 1, right);

			merge(dArr, left, mid, right);
		}
	}


	public void printArray(double[] dArr) {
		System.out.println("\nStock Prices in Ascending Order");
		for (int i = dArr.length-1; i >=0; i--) {
			System.out.print("  " + dArr[i]);
		}
		System.out.println("\n");
	}
	
	public void printArrayDesc(double[] dArr) {
		System.out.println("\nStock Prices in Descending Order");
		for(int i = 0; i < dArr.length; i++) {
			System.out.print("  " + dArr[i]);
		}
		System.out.println("\n");
	}

	public double[] getSortedArray() {
		return sortedArray;
	}

	public void setSortedArray(double[] sortedArray) {
		this.sortedArray = sortedArray;
	}
}
