package de.stevenfil.java.exercises.concurrency.syncronisation;

public class Counter {

  private int value;

  public Counter() {
    value = 0;
  }

  public void increment() {
    if (value < 1) {
      System.out.format(
          "%s: %s %d\n", Thread.currentThread().getName(), "Increasing value: ", value);
      value++;
      System.out.format("%s: %s %d\n",
          Thread.currentThread().getName(), "New value.", value);
    } else {
      System.out.format("%s: %s \n",
          Thread.currentThread().getName(), "Nothing to do.");
    }
  }

  public int getValue() {
    return value;
  }

}
