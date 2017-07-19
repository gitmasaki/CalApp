package jp.techacademy.masaki.ohmura.calapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView1;
    EditText mEditText1;
    TextView mTextView2;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);


        mTextView1 = (TextView) findViewById(R.id.textView1);
        mEditText1 = (EditText) findViewById(R.id.editText1);

        mTextView2 = (TextView) findViewById(R.id.textView2);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        mTextView1.setText(mEditText1.getText().toString());
        mTextView2.setText(mEditText2.getText().toString());
        BigDecimal value1 = new BigDecimal(mEditText1.getText().toString());
        BigDecimal value2 = new BigDecimal(mEditText2.getText().toString());
        BigDecimal val = BigDecimal.ZERO;


         if (v.getId() == R.id.button1) {
            val = value1.add(value2).setScale(2, BigDecimal.ROUND_HALF_UP);
        }  else if (v.getId() == R.id.button2) {
            val = value1.subtract(value2).setScale(2, BigDecimal.ROUND_HALF_UP);
        }  else if (v.getId() == R.id.button3) {
            val = value1.multiply(value2).setScale(2, BigDecimal.ROUND_HALF_UP);
        } else if (v.getId() == R.id.button4) {
            val = value1.divide(value2, 2, BigDecimal.ROUND_HALF_UP);
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE", val);
        startActivity(intent);
    }
}