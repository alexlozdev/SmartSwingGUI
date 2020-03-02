/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mt.ui;

/**
 *
 * @author Administrator
 */
public class LoadingThread extends Thread {

    public void run() {
        Manager.getInstance().init();
    }

}
