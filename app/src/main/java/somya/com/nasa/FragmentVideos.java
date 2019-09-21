package somya.com.nasa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentVideos extends Fragment {
    ArrayList<vfvideos>mylist = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.somya_video_refrector, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mylist.add(new vfvideos("CPR Training","https://www.youtube.com/watch?v=ApzANyz15KI","https://i.postimg.cc/3xTHP2GQ/injurednew.jpg"));
        mylist.add(new vfvideos("Transport of Injured","https://www.youtube.com/watch?v=ApzANyz15KI","https://i.postimg.cc/8zmVDsdJ/cprnew.jpg"));
        mylist.add(new vfvideos("Flooding Water Logging due to rains","https://www.youtube.com/watch?v=L2gx_rlvLgQ","https://i.postimg.cc/65RXjMyh/floodnew.jpg"));
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.vidfrag_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyVideosAdaptor myVideosAdaptor = new MyVideosAdaptor(mylist);
        recyclerView.setAdapter(myVideosAdaptor);
    }
}
