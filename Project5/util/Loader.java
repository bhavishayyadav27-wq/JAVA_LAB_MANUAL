// util/Loader.java
package util;
public class Loader implements Runnable {
    private String msg;
    private int millis;
    public Loader(String msg, int millis) { this.msg = msg; this.millis = millis; }
    @Override
    public void run() {
        try {
            System.out.print(msg);
            int steps = Math.max(1, millis/200);
            for (int i=0;i<steps;i++){ System.out.print("."); Thread.sleep(200); }
            System.out.println();
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
