package me.whiteship.java8to11.section6.introduction;

public class Concurrent {

	public static void main(String[] args) throws InterruptedException {

		//자바8 이전에는 많은 Thread 관리가 너무 복잡했음!
		//자바8에 Executor 등장 -> Future -> CompletableFuture

		//Thread의 순서는 알 수 없음!
		//Thread 사용법1: Thread 상속
		MyThread thread = new MyThread();
		thread.start();

		//Thread 사용법2: Runnable 구현
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread1: " + Thread.currentThread().getName());
			}
		});
		thread1.start();

		//Thread 사용법3: Runnable 구현(람다)
		Thread thread2 = new Thread(() -> {
			//1.sleep: Thread 재우기(데드락 주의)
			//2.interrupt: Thread 깨우기
			while (true){
				System.out.println("Thread2: " + Thread.currentThread().getName());
				try{
					Thread.sleep(1000L);
				}catch (InterruptedException e){
					System.out.println("interrupted!");
					return; //return 없으면 계속 while문 수행
				}
			}
		});
		thread2.start();
		
		System.out.println("Hello: " + Thread.currentThread().getName());

		Thread.sleep(3000L);
		thread2.interrupt();

		//3.join: Thread 기다리기
		thread2.join();
		System.out.println(thread2 + "is finished");



	}

	//Thread 사용법1
	static class MyThread extends Thread {
		@Override
		public void run(){
			System.out.println("Thread0: " + Thread.currentThread().getName());
		}
	}
}
