package de.stevenfil.java.exercises.concurrency.syncronisation;

public class EvilCounterUsage {

  static Counter counter;

  public static void main(String[] args) throws InterruptedException {
    counter = new Counter();
    Thread t = new Thread(new EvilCounter());

    t.start();

    while(counter.getValue() <= 10) {
      counter.decrement();
      Thread.sleep(500);
    }

  }

  private static class EvilCounter implements Runnable {

    @Override
    public void run() {
      while(counter.getValue() <= 10){
        counter.increment();
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
