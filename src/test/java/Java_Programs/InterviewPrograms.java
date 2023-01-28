package Java_Programs;

import java.util.Scanner;

public class InterviewPrograms {
	public static void armstrongNumber() {
		int n, a, i = 0, j = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("enter the number");
		n = input.nextInt();
		a = n;
		while (a > 0) {
			i = a % 10;
			j = j + (i * i * i);
			a = a / 10;
		}
		if (j == n) {
			System.out.println("it is armstrong number");
		} else {
			System.out.println("it is not armstrong number");
		}

	}

	public static void armstrongNumber1to1000() {
		int c = 0;

		for (int n = 0; n < 1000; n++) {
			int a, i = 0, j = 0;
			a = n;
			while (a > 0) {
				i = a % 10;
				j = j + (i * i * i);
				a = a / 10;
			}
			if (j == n) {
				System.out.println(j + " is armstrong number");
				c++;
			}
		}
		System.out.println("number of armstrong numbers" + c);

	}

	public static void ascendingNumber() {
		int temp;
		int a[] = { 10, 100, 200, 40, 20 };
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {

				while (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			System.out.println(a[i]);
		
		}
		
		System.out.println("min value = "+a[0]);
		System.out.println("max value ="+a[a.length-1]);
	}
	public static void descendingOrder() {
		int temp;
		int a[] = {10,100,200,40,20};
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				while(a[i]<a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			System.out.println(a[i]);
			
		}
	}
	public static void main(String[] args) {
		descendingOrder();
	}
}
