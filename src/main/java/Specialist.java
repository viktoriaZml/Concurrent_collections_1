import java.util.Queue;

public class Specialist extends Thread {
  private Queue<Integer> queue;
  private static final int DIALOG_TIME = 3000;

  public Specialist(Queue<Integer> queue, String name) {
    this.queue = queue;
    super.setName(name);
  }

  public void run() {
    Integer call = queue.poll();
    while (true) {
      if (call != null) {
        try {
          System.out.println(Thread.currentThread().getName() + ": звонок №" + call);
          Thread.sleep(DIALOG_TIME);
        } catch (InterruptedException e) {
          break;
        }
      } else if (Thread.currentThread().isInterrupted())
        break;
      call = queue.poll();
    }
  }
}
