package com.nya.fgopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    private DatabaseReference database;
    private Button btCreateDB;
    private EditText etName, eId;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance().getReference();

        eId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_namaServant);
        btCreateDB = findViewById(R.id.bt_submit1);

        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Stanggal = eId.getText().toString();
                String Sjudul = etName.getText().toString();

                if (Stanggal.equals("")){
                    eId.setError("Silahkan");
                    eId.requestFocus();
                }else if (Sjudul.equals("")){
                    etName.setError("Silahkan");
                    etName.requestFocus();
                }else {
                    loading = ProgressDialog.show(MainActivity2.this,
                            null,
                            "Please Wait",
                            true,
                            false);

                    submitUser(new Servant(
                            Sjudul.toLowerCase(),
                            Stanggal.toLowerCase()));

                }
            }
        });
    }

    private void submitUser(Servant servant) {
        database.child("Servant").push().setValue(servant).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                loading.dismiss();

                eId.setText("");
                etName.setText("");

                Toast.makeText(MainActivity2.this,"Data berhasil", Toast.LENGTH_SHORT).show();
            }
        });
    }
}