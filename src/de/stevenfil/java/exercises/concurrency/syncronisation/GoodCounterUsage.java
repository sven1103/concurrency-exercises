package de.stevenfil.java.exercises.concurrency.syncronisation;

public class GoodCounterUsage {

  static SynchronisedCounter counter;

  public static void main(String[] args) throws InterruptedException {
    counter = new SynchronisedCounter();
    Thread t = new Thread(new GoodCounter());
    Thread o = new Thread(new GoodCounter());
    o.start();
    t.start();
    Thread.sleep(500);
    System.out.format("%s: Final value is %s.\n",
        Thread.currentThread().getName(), counter.getValue());
  }

  private static class GoodCounter implements Runnable {

    @Override
    public void run() {
      counter.increment();
    }
  }
}
