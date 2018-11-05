package net.unifyconcept.sidhartproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class DetailActivity extends AppCompatActivity {
    String name, date, time, address;
    EditText txtname, txtdate,txtaddress, txttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtname = findViewById(R.id.txtName);
        txtdate = findViewById(R.id.txtDate);
        txtaddress = findViewById(R.id.txtAddress);
        txttime = findViewById(R.id.txtTime);
    }
    public void preview(View view){
        name = txtname.getText().toString();
        date = txtdate.getText().toString();
        time = txttime.getText().toString();
        address = txtaddress.getText().toString();
        Intent intent = new Intent(DetailActivity.this, PhotoActivity.class);
        intent.putExtra("Name", name);
        intent.putExtra("Date", date);
        intent.putExtra("Time", time);
        intent.putExtra("Address", address);
        startActivity(intent);
    }
    public void reset(View view){
       txtname.setText("");
       txtdate.setText("");
       txttime.setText("");
       txtaddress.setText("");
    }
}
