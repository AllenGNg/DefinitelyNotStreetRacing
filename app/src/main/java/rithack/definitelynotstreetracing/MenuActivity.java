package rithack.definitelynotstreetracing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by allen on 2/11/17.
 */

public class MenuActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Allow "Log In" button to switch to activity_login xml file.
    Button button1 = (Button)findViewById(R.id.button);
    button1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MenuActivity.this, LoginActivity.class));
        }

    });

        // Allow "Find Race" button to switch to activity_race file.
    Button button2 = (Button)findViewById(R.id.button2);
    button2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            startActivity(new Intent(MenuActivity.this, RaceActivity.class));
        }
    });

        // Allow "Currency" button to switch to activity_curr file.
    Button button3 = (Button)findViewById(R.id.button5);
    button3.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            startActivity(new Intent(MenuActivity.this, CurrencyActivity.class));
        }
    });

    }
}
