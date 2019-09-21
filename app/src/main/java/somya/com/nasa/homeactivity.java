package somya.com.nasa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homeactivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private sos sos1;
    private todo todo1;
    private videos videos1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setItemIconTintList(null);



        sos1=new sos();
        todo1=new todo();
        videos1=new videos();
        final FragmentVideos fragmentVideos=new FragmentVideos();
        setFregment(todo1);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.todo:{setFregment(todo1);
                                     getSupportActionBar().setTitle("TO-DO");
                                   return true;}
                    case R.id.Videos :{setFregment(fragmentVideos);
                    getSupportActionBar().setTitle("Safety Tips");
                                      return true;}
                    case R.id.sos:{setFregment(sos1);
                    getSupportActionBar().setTitle("Emergency");
                    return true;}
                    default:return false;
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
    public void setFregment(Fragment fregment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fregment);
        fragmentTransaction.commit();
    }
}
