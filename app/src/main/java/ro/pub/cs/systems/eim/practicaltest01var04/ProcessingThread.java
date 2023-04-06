package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread{

    String coord;
    private Context context = null;
    private boolean isRunning = true;



    private String nume;
    private String group;



    private Random random = new Random();
    public ProcessingThread(PracticalTest01Var04Service colocviuService, String nume, String grupa) {
        // System.out.println("Thread primeste suma: " + sum);
        this.group = grupa;
       this.nume = nume;
       this.context = colocviuService;
    }

    @Override
    public void run() {
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has started! PID: " + Process.myPid() + " TID: " + Process.myTid());
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
                new Date(System.currentTimeMillis()) + " " + nume + " " + group);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
