package com.nya.fgopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference database;
    private Button btCreateDB, btintent;
    private EditText etJudul, etTgl;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_create);
        btintent = findViewById(R.id.button);
        btintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });


        database = FirebaseDatabase.getInstance().getReference();

        etTgl = findViewById(R.id.et_namabarang);
        etJudul = findViewById(R.id.et_merkbarang);
        btCreateDB = findViewById(R.id.bt_submit);

        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Stanggal = etTgl.getText().toString();
                String Sjudul = etJudul.getText().toString();

                if (Stanggal.equals("")){
                    etTgl.setError("Silahkan");
                    etTgl.requestFocus();
                }else if (Sjudul.equals("")){
                    etJudul.setError("Silahkan");
                    etJudul.requestFocus();
                }else {
                    loading = ProgressDialog.show(MainActivity.this,
                            null,
                            "Please Wait",
                            true,
                            false);

                    submitUser(new News(
                            Sjudul.toLowerCase(),
                            Stanggal.toLowerCase()));

                }
            }
        });
    }

    private void submitUser(News news) {
        database.child("News").push().setValue(news).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                loading.dismiss();

                etJudul.setText("");
                etTgl.setText("");

                Toast.makeText(MainActivity.this,"Data berhasil", Toast.LENGTH_SHORT).show();
            }
        });
    }
}