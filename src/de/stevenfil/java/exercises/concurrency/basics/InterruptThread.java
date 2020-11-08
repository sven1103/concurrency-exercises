package de.stevenfil.java.exercises.concurrency.basics;

import de.stevenfil.java.exercises.concurrency.basics.toythreads.SlowMessenger;

public class InterruptThread {

  public static void main(String[] args) throws InterruptedException{
    Thread messenger = new Thread(new SlowMessenger());
    messenger.start();
    Thread.sleep(2000);
    messenger.interrupt();
  }
}
