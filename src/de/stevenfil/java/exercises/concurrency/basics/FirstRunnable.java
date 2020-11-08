package de.stevenfil.java.exercises.concurrency.basics;

public class FirstRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println("Hello world from the first thread :)");
  }

  public static void main(String[] args) {
    new Thread(new FirstRunnable()).start();
  }
}
