package su.nosite.smth.sprefsexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Button buttonLoad;
    Button buttonSave;
    EditText editText;
    SharedPreferences sharedPreferences;
    public final String KEY = "KEY983947982374";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLoad=findViewById(R.id.buttonLoad);
        buttonSave=findViewById(R.id.buttonSave);
        editText = findViewById(R.id.editText);
        sharedPreferences = getPreferences(MODE_PRIVATE);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(String.valueOf(editText.getText()));
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(load());
            }
        });

    }

    public String load(){
        Gson gson = new Gson();
        return  gson.fromJson(sharedPreferences.getString(KEY,""),String.class);
    }
    public void save(String text){
        Gson gson = new Gson();
        sharedPreferences
                .edit()
                .putString(
                        KEY,
                        gson
                                .toJson(text)
                )
                .apply();
    }

}
