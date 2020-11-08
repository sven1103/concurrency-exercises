package de.stevenfil.java.exercises.concurrency.syncronisation;

public class HappensAfterRelationship {

  static int counter = 0;

  private static class TooLate implements Runnable {

    @Override
    public void run() {
      // This will be output either 0 or -1 => bad :(
      System.out.format("%s: Counter is %d\n",
          Thread.currentThread().getName(), counter);
    }
  }

  public static void main(String[] args) {
    Thread t = new Thread(new TooLate());
    t.start();
    counter--;
    System.out.format("%s: Counter is %d\n",
        Thread.currentThread().getName(), counter);
  }
}
