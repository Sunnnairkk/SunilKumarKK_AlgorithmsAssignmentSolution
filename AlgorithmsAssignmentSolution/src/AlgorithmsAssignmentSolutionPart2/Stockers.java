package AlgorithmsAssignmentSolutionPart2;

import java.util.Scanner;

public class Stockers {

	public void countStockStatus(boolean[] stockStatus, boolean stockIncreased) {
		int countStatus = 0;
		for(int i = 0; i < stockStatus.length; i++) {
			if(stockStatus[i] == stockIncreased) countStatus++;
		}
		System.out.println("Total number of companies whose stock value " + (stockIncreased ? "rose" : "declined") +  " today " + countStatus);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\nStockers\n\n");
		Scanner in = new Scanner(System.in);

		System.out.print("\nEnter the number of Companies : ");
		int numOfCompanies = in.nextInt();

		if (numOfCompanies > 0) {
			double[] stockValue = new double[numOfCompanies];
			boolean[] stockStatus = new boolean[numOfCompanies];

			//Stock Values and Today's status
			for (int i = 0; i < numOfCompanies; i++) {
				System.out.print("\n\nEnter the stock price of the Company " + i + " : ");
				stockValue[i] = in.nextDouble();
				System.out.print("\nWhether the Company's Stock price rose today compare to yesterday? " );
				stockStatus[i] = in.nextBoolean();
			}

			int menuOption = -1;
			do {
				System.out.println("\n\n\n");
				System.out.println("Enter the operation that you want to perform");
				System.out.println("********************************************");
				System.out.println("1. Display the Company's stock prices in ascending order");
				System.out.println("2. Display the Company's stock prices in decending order");
				System.out.println("3. Display the total number of companies for which stock prices rose today");
				System.out.println("4. Display the total number of companies for which stock prices declined today");
				System.out.println("5. Search a specific stock price");
				System.out.println("0. To Exit");
				System.out.println("-------------------------------------------------\n");
				menuOption = in.nextInt();

				MergeSort ms = new MergeSort();
				Stockers stockers = new Stockers();

				switch (menuOption) {
				case 0 :
					break;

				case 1 :
					if (numOfCompanies>1) {
						ms.sort(stockValue,0,stockValue.length-1);
						ms.printArray(ms.getSortedArray());
					}
					else
						System.out.println("Stock prices in Ascending Order " + stockValue[0]);
					break;

				case 2 :
					if (numOfCompanies > 1) {
						ms.sort(stockValue,0,stockValue.length-1);
						ms.printArrayDesc(ms.getSortedArray());
					}
					else
						System.out.println("Stock prices in Decending Order " + stockValue[0]);
					break;

				case 3 :
					stockers.countStockStatus(stockStatus, true);
					break;

				case 4 :
					stockers.countStockStatus(stockStatus, false);
					break;

				case 5 :
					System.out.print("\nEnter the Key Value ");
					double searchVal = in.nextDouble();
					BinarySearch bs = new BinarySearch();
					if (bs.binarySearchValue(stockValue, searchVal) > 0) 
						System.out.println("\nStock of value " + searchVal + " is present ");
					else
						System.out.println("\nStock Value not found");
					break;

				default :
					System.out.println("\nWrong selection\n\n");
				}

			} while (menuOption != 0);
		}
		System.out.println("\nExited Successfully");
		in.close();
	}

}
