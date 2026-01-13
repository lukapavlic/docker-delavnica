public class Zdravo {

    public static void main(String... args) {
      
        new Thread(() -> {
            try {
                for (int i = 100; i >= 1; i--) {
                    if (i%20==0) System.out.println();
                    System.out.print(i+ " ");
                    Thread.sleep(30);
                }
                System.out.println("BUM!!!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Nit je bila prekinjena.");
            }
        }).start();
    }

}