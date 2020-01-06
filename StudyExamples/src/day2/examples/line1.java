package day2.examples;

import java.util.Scanner;

public class line1 {
	static int[] consumers;
	static int[] messages;
	static int msgSize;
	static int head;
	
	public static void dequeue() {
		System.out.println(messages[head]);
		head++;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		messages = new int[sc.nextInt()];
		consumers = new int[sc.nextInt()];
		head = consumers.length;
		
		for(int i = 0; i<messages.length; i++) {
			messages[i] = sc.nextInt();
			if(i<consumers.length) {
				consumers[i] = messages[i];
			}else {
				dequeue();
			}
		}
	}

}
