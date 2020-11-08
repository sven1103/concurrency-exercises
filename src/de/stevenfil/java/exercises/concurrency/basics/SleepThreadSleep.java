package de.stevenfil.java.exercises.concurrency.basics;

public class SleepThreadSleep {

  public static void main(String[] args) {
    String[] information = {
        "It is sunny.",
        "It is 12 degrees Celcius.",
        "It is weekend."
    };

    for (String info : information) {
      tryToSleep();
      System.out.println(info);
    }
  }

  static void tryToSleep() {
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      System.out.println("Stopping my work.");
    }
  }
}
