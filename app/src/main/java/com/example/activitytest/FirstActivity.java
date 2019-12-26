package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity{

    private static final String TAG = "FirstActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=findViewById(R.id.button_1);
        Button button2=findViewById(R.id.button_2);
        Button button3=findViewById(R.id.button_3);
        Button button4=findViewById(R.id.button_4);
        Button button5=findViewById(R.id.button_5);
        Button button6=findViewById(R.id.button_6);
        Button button7=findViewById(R.id.button_7);
        Button button8=findViewById(R.id.button_8);
        Button button9=findViewById(R.id.button_9);
        Log.d(TAG, "Task id is "+getTaskId());
        button1.setOnClickListener(new View.OnClickListener() {   //Toast 使用
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"you are clicked Button_1",Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {      //显示Intent 用Intent传递数据
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                String data="Hello SecondActivity 显式Intent";
                intent.putExtra("Extra_data",data);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {      //隐式Intent 自定义action 用Intent传递数据
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.activity.ACTION_START");
                intent.addCategory("My_category");
                String data="Hello SecondActivity 隐式Intent";
                intent.putExtra("Extra_data",data);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {     //隐式Intent  启动系统插件
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://baidu.com"));
                //intent.setData(Uri.parse("ftp:190.128.1.1"));   //跳转到ThirdActivity
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {    //两种启动方式  获取返回的数据
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(FirstActivity.this, FourthActivity.class);
//                startActivityForResult(intent,1);
                Intent intent=new Intent();
                intent.setAction("fourth");
                startActivityForResult(intent,1);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {   //启动模式  standard
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {   //启动模式  singleTop/singleTsak
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(FirstActivity.this,FirstActivity.class);
//                startActivity(intent);
                Intent intent=new Intent(FirstActivity.this,FifthActivity.class);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,FifthActivity.class);
                 startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(FirstActivity.this,SixthActivity.class);
//                startActivity(intent);
                SixthActivity.actionStart(FirstActivity.this,"name","password");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {       //菜单项设置
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {    //菜单项点击监听器
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you clicked add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you clicked remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String ReturnedData= data.getStringExtra("data_return");
                    Log.d("FirstActivity", ReturnedData);
                }
                break;
             default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
