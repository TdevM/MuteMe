package tdevm.muteme;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    AudioManager silentMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelSensor, SensorManager.SENSOR_DELAY_UI);
        silentMode = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float accX = sensorEvent.values[0];
        float accY = sensorEvent.values[1];
        float accZ = sensorEvent.values[2];
        if(accZ<-8){
            //Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
            silentMode.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
