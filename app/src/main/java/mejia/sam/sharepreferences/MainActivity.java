package mejia.sam.sharepreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    EditText et,et2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et= (EditText) findViewById(R.id.et);


        sharedpreferences = getSharedPreferences("File",MODE_PRIVATE);
        et.setText(sharedpreferences.getString("First data",""));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedpreferences = getSharedPreferences("File", MODE_PRIVATE);
                String n = et.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("First data", n);
                editor.commit();

                et2.setText(n);
                Toast.makeText(MainActivity.this,"Your data was save it",Toast.LENGTH_LONG).show();
            }
        });

    }



}
