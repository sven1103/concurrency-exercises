package de.stevenfil.java.exercises.concurrency.basics;

public class FirstThread extends Thread {

  public void run() {
    System.out.println("Hello from the first thread :D");
  }

  public static void main(String[] args) {
    new FirstThread().start();
  }
}
