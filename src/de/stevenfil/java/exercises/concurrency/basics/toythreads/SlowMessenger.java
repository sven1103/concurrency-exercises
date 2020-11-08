package de.stevenfil.java.exercises.concurrency.basics.toythreads;

import java.util.Arrays;
import java.util.List;

public class SlowMessenger implements Runnable {

  private final List<String> messages;

  public SlowMessenger(){
    messages = Arrays.asList("Hello you", "I am", "slow");
  }

  @Override
  public void run() {
    for(String message : messages) {
      System.out.println(message);
      try {
        Thread.sleep(4000);
      } catch (InterruptedException e) {
        System.out.println("Ok i stop talking.");
        return;
      }
    }
  }
}
