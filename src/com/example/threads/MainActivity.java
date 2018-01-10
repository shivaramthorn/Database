package com.example.threads;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	EditText ed1,ed2,ed3,ed4;
	Button b1,b2;
	SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);
        ed3 = (EditText)findViewById(R.id.editText3);
        ed4 = (EditText)findViewById(R.id.editText4);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        db = openOrCreateDatabase("Network",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Address(Ipv4 VARCHAR,SubnetMask VARCHAR,Default_GateWay VARCHAR,DNS VARCHAR)");
        b1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db.execSQL("INSERT INTO Address (Ipv4,SubnetMask,Default_GateWay,DNS) VALUES ('"+ed1.getText().toString()+","+ed2.getText().toString()+","+ed3.getText().toString()+","+ed4.getText().toString()+"')");
				Toast.makeText(getApplicationContext(), "Inseted",Toast.LENGTH_LONG).show();
			}
        	
        });
        b2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db.execSQL("DROP TABLE Address");
				db.execSQL("CREATE TABLE IF NOT EXISTS Address(Ipv4 VARCHAR,SubnetMask VARCHAR,Default_GateWay VARCHAR,DNS VARCHAR)");
				Toast.makeText(getApplicationContext(), "Truncated",Toast.LENGTH_LONG).show();
			}
        	
        });
    }
}
