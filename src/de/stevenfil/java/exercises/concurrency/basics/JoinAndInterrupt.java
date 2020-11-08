package de.stevenfil.java.exercises.concurrency.basics;

import de.stevenfil.java.exercises.concurrency.basics.toythreads.SlowMessenger;

public class JoinAndInterrupt {

  static void threadMessage(String msg) {
    System.out.format("%s: %s\n",
        Thread.currentThread().getName(), msg);
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(new SlowMessenger());
    final int waitingTime = 8 * 1000;
    final long startTime = System.currentTimeMillis();

    threadMessage("Starting new thread...");
    t.start();
    while(t.isAlive()) {
      // We wait for 1000ms
      threadMessage("Waiting...");
      t.join(1000);
      // If it is still not finished, and our waiting time
      // is exceeded, we interrupt the work.s
      if (System.currentTimeMillis() - startTime > waitingTime && t.isAlive()) {
        threadMessage("Ok, enough for know.");
        t.interrupt();
        t.join();
      }
    }
    threadMessage("Ok, done!");


  }
}
