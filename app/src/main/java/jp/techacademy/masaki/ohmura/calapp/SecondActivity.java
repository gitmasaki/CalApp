package jp.techacademy.masaki.ohmura.calapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.math.BigDecimal;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        BigDecimal val = (BigDecimal)intent.getSerializableExtra("VALUE");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(val.toString());
    }
}
