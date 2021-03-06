package de.stevenfil.java.exercises.concurrency.syncronisation;

public class EvilCounterUsage {

  static Counter counter;

  public static void main(String[] args) throws InterruptedException {
    counter = new Counter();
    Thread t = new Thread(new EvilCounter());
    Thread o = new Thread(new EvilCounter());
    o.start();
    t.start();
    Thread.sleep(500);
    System.out.format("%s: Final value is %s.\n",
        Thread.currentThread().getName(), counter.getValue());
  }

  private static class EvilCounter implements Runnable {

    @Override
    public void run() {
      counter.increment();
    }
  }
}
