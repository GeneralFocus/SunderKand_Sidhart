package net.unifyconcept.sidhartproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PhotoActivity extends AppCompatActivity {//implements OnClickListener {
    private Button mButton;
    private View mView;
    TextView date,time,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        mView = findViewById(R.id.f_view);
        mButton = findViewById(R.id.button1);
      //  mButton.setOnClickListener(this);

        mView.setDrawingCacheEnabled(true);
        mView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        mView.layout(0, 0, mView.getMeasuredWidth(), mView.getMeasuredHeight());
        mView.buildDrawingCache(true);

        date = findViewById(R.id.tDate);
        time = findViewById(R.id.tTime);
        address = findViewById(R.id.tAddress);

        Intent intent = getIntent();
        /*Date", date);
        intent.putExtra("Time", time);
        intent.putExtra("Address",*/
        String dat = intent.getStringExtra("Date");
        String tim = intent.getStringExtra("Time");
        String add = intent.getStringExtra("Address");
        date.setText(dat);
        time.setText(tim);
        address.setText(add);
    }

    public void printOut(View v) {

        if (v.getId() == R.id.button1) {
            Bitmap b = Bitmap.createBitmap(mView.getDrawingCache());
            mView.setDrawingCacheEnabled(false);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

            File f = new File(Environment.getExternalStorageDirectory() + File.separator + "invitation.jpg");
            try {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
                fo.close();
            } catch (Exception e) {
            }
            finish();
        }
    }
}
