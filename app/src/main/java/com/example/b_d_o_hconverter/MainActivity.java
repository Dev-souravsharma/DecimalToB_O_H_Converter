package com.example.b_d_o_hconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText  editText;
    Spinner spinner;
    Button button;
    TextView myText;
    String s;
    int location=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        spinner=findViewById(R.id.spinner);
        button=findViewById(R.id.editButton);
        myText=findViewById(R.id.textView);
        ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(this,R.array.spinnerValue,android.R.layout.simple_list_item_1);
        spinner.setAdapter(arrayAdapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                TextView textView= (TextView) view;
//                Toast.makeText(MainActivity.this, ""+textView.getText(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                Toast.makeText(MainActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void convert(View view) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView= (TextView) view;
                s=textView.getText().toString();
                location=position;
               // Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });
        try {
            String value=editText.getText().toString();
            String bin;
            if (location==0){
                bin=Integer.toBinaryString(Integer.parseInt(value));
                myText.setText(bin);
            }
            else if (location==1){
               bin=Integer.toOctalString(Integer.parseInt(value));
               myText.setText(bin);
            }
            else if (location==2){
                bin=Integer.toHexString(Integer.parseInt(value));
                myText.setText(bin);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
