package ro.pub.cs.systems.eim.practicaltest01var04;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class PracticalTest01Var04Service extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

      //  String textCoord;
      //  textCoord = intent.getStringExtra(Constants.COORD);
      //  System.out.println("Service primeste : " + textCoord);


        String name =  intent.getStringExtra(Constants.STUDENT_TEXT);
        String grupa = intent.getStringExtra(Constants.GROUP_TEXT);

        // creez thread si start
        ProcessingThread processingThread = new ProcessingThread(this,name, grupa);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;

    }
}
