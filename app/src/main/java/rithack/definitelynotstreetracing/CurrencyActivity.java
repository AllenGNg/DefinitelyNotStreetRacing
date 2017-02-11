package rithack.definitelynotstreetracing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by allen on 2/11/17.
 */

public class CurrencyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

    Button button4 = (Button) findViewById(R.id.button6);
    button4.setOnClickListener(new View.OnClickListener() {
        //@Override
        EditText text1 = (EditText) findViewById(R.id.editText);
        String currency = "10";
        public void onClick(View v){
            text1.setText(currency);
        }


        });
    }
}
