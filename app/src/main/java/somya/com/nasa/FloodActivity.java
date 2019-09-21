package somya.com.nasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class FloodActivity extends AppCompatActivity {
FrameLayout container;
ArrayList<Information>flood_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        flood_list.add(new Information(("Drinking water – Fill clean containers")));
        flood_list.add(new Information((" Phones or any reusable batteries for Flashlights")));
        flood_list.add(new Information(("Food that requires no refrigeration or cooking")));
        flood_list.add(new Information(("Medications and first aid supplies")));
        flood_list.add(new Information(("Avoid coming in contact with flood water")));
        flood_list.add(new Information(("Clothing, toiletries")));
        flood_list.add(new Information(("Battery-powered radio")));


        setContentView(R.layout.activity_flood);
        container= findViewById(R.id.flood_container);
        MainFragment mainFragment= MainFragment.newInstance(flood_list);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flood_container,mainFragment )
                .commit();

        //final SheredRef first=new SheredRef(this);

    }
}
