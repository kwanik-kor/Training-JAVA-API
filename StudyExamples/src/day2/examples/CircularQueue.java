package day2.examples;

import java.util.Scanner;

public class CircularQueue {
	int[] arr = new int[10];
	int head = 0;
	int tail = -1;
	int arrSize = 0;
	int number = 0;
	Scanner sc = new Scanner(System.in);
	
	public void enqueue() {
		if(arrSize == arr.length) {
			System.out.println("Overflow!");
		}else {
			tail = (tail+1) % arr.length;
			arr[tail] = ++number;
			System.out.println("����ȣ : " + arr[tail]);
			arrSize++;
		}
	}
	public void dequeue() {
		if(arrSize == 0) {
			System.out.println("Underflow!");
		}else {
			head = (head) % arr.length;
			System.out.println(arr[head] + "�� ���� !");
			arr[head] = 0;
			head++;
			arrSize--;
		}
	}
	public void menu() {
		CircularQueue q = new CircularQueue();
		do {
			for(int i=0; i<q.arr.length; i++) {
				System.out.print(q.arr[i] + " ");
			}
			System.out.println("System Start");
			System.out.println("\n����ο� : " + q.arrSize + "��");
			System.out.println("--------------");
			System.out.println("1. ��ȣǥ�̱�");
			System.out.println("2. ��ȣ��");
			System.out.println("3. ����");
			System.out.print("�޴� ��ȣ �Է� : ");
			int num = sc.nextInt();
			switch(num) {
			case 1: q.enqueue(); break;
			case 2: q.dequeue(); break;
			case 3: return;
			default: System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�.");
			}
		}while(true);
	}
	public static void main(String[] args) {
		new CircularQueue().menu();

		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}
	
}
