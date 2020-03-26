package model;

import java.util.Calendar;

/**
 * ThreadViderCommandeJour
 */
public class ThreadViderCommandeJour extends Thread {

    private boolean condition = true;
    private int jourReference;

    public ThreadViderCommandeJour() {
        Calendar calendar = Calendar.getInstance();
        jourReference = calendar.get(Calendar.DAY_OF_MONTH);
    }
    
    public void arret() {
        condition = false;
    }

    public void run() {
        do {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            int minute = calendar.get(Calendar.MINUTE);
            if (minute == 45) {
                BDCommande.getInstance().viderCommandeJour();
            }
        } while (condition);
    }
}