package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.xml.transform.Result;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        String data=intent.getStringExtra("Extra_data");
        Log.d("SecondActivity",data);
//        Button button6=findViewById(R.id.button_6);
//        button6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1=new Intent();
//                intent1.putExtra("data_return","Hello FirstActivity");
//                setResult(RESULT_OK,intent1);
//                finish();
//            }
//        });
    }
}
