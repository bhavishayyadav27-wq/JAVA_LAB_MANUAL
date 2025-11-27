// Loader.java
public class Loader implements Runnable {
    private String message;
    private int millis;

    public Loader(String message, int millis) {
        this.message = message;
        this.millis = millis;
    }

    @Override
    public void run() {
        try {
            System.out.print(message);
            int steps = millis / 200;
            for (int i = 0; i < steps; i++) {
                System.out.print(".");
                Thread.sleep(200);
            }
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
