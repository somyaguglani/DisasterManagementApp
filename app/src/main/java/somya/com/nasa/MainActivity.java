package somya.com.nasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.img);
        textView=findViewById(R.id.text);
        textView.setTranslationX(-2000);
        img.setTranslationY(2000);
        img.animate().translationY(0).setDuration(500);
        textView.animate().translationX(0).setDuration(800);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(MainActivity.this,homeactivity.class));

            }
        },3000);

    }
}
