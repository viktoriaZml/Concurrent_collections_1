import java.util.Queue;

public class ATS extends Thread {
  private Queue<Integer> queue;
  private static final int MAX_COUNT = 60;
  private static final int PAUSE_TIME = 1000;

  public ATS(Queue<Integer> queue) {
    this.queue = queue;
  }

  public void run() {
    for (int i = 1; i <= MAX_COUNT; i++) {
      queue.offer(i);

      try {
        Thread.sleep(PAUSE_TIME);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
