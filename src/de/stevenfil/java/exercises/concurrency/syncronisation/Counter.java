package de.stevenfil.java.exercises.concurrency.syncronisation;

public class Counter {

  private int value;

  public Counter() {
    value = 0;
  }

  public void increment() {
    System.out.format("%s: %s %d\n",
        Thread.currentThread().getName(), "Increasing value: ", value);
    value++;
  }

  public void decrement() {
    System.out.format("%s: %s %d\n",
        Thread.currentThread().getName(), "Decreasing value.", value);
    if (value == 0) {
      throw new IllegalStateException("Counter value cannot be negative!");
    }
    value--;
  }

  public int getValue() {
    return value;
  }

}
