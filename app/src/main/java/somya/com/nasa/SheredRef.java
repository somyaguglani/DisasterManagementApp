package somya.com.nasa;

import android.content.Context;
import android.content.SharedPreferences;

public class SheredRef {

    SharedPreferences sharedPreferences;

    SheredRef(Context context){
        sharedPreferences=context.getSharedPreferences("myshared", Context.MODE_PRIVATE);
    }
    public void saveData(String str1){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(str1,"one");
        editor.commit();
    }
    public String loadData(){
        String fileContent="Email:"+sharedPreferences.getString("Email","khali")+" password:"+
                sharedPreferences.getString("Pass","khali");

        return fileContent;

    }
}
