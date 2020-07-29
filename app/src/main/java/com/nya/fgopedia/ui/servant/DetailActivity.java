package com.nya.fgopedia.ui.servant;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nya.fgopedia.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView, arts, ic_skill1, ic_skill2, ic_skill3, np_img;
    TextView textView, star, cost, atk, hp, atr, ali, skil, isi, skill2, isi2, skill3, isi3, np, isinp;
    DatabaseReference ref;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_detailservant);

        //TextView
        cost = findViewById(R.id.cost_servant);
        star = findViewById(R.id.star);
        textView = findViewById(R.id.names);
        atk = findViewById(R.id.attack_servant);
        hp = findViewById(R.id.hp_servant);
        atr = findViewById(R.id.atribute_servant);
        ali = findViewById(R.id.ali_servant);
        skil = findViewById(R.id.skill);
        isi = findViewById(R.id.isi_skill);
        skill2 = findViewById(R.id.skill2);
        isi2 = findViewById(R.id.isi_skill2);
        skill3 = findViewById(R.id.skill3);
        isi3 = findViewById(R.id.isi_skill3);
        np = findViewById(R.id.name_np);
        isinp = findViewById(R.id.isi_np);

        //Image
        imageView = findViewById(R.id.icon_class);
        arts = findViewById(R.id.art);
        ic_skill2 = findViewById(R.id.ic_skill2);
        ic_skill1 = findViewById(R.id.ic_skill);
        ic_skill3 = findViewById(R.id.ic_skill3);
        np_img = findViewById(R.id.np_skill);

        //database
        ref = FirebaseDatabase.getInstance().getReference().child("Servant");
        String key = getIntent().getStringExtra("key");

        ref.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String names = snapshot.child("name").getValue().toString();
                    String icon = snapshot.child("icon").getValue().toString();
                    String rarity = snapshot.child("rarity").getValue().toString();
                    String img = snapshot.child("art").getValue().toString();
                    String cost_servant = snapshot.child("cost").getValue().toString();
                    String attack = snapshot.child("attack").getValue().toString();
                    String hp_servant = snapshot.child("hp").getValue().toString();
                    String atribut = snapshot.child("atribute").getValue().toString();
                    String alignment = snapshot.child("alignment").getValue().toString();
                    String skill = snapshot.child("name_skill").getValue().toString();
                    String detail = snapshot.child("detail_skill").getValue().toString();
                    String skl2 = snapshot.child("name_skill2").getValue().toString();
                    String detail2 = snapshot.child("detail_skill2").getValue().toString();
                    String icon_skill = snapshot.child("icon_skill").getValue().toString();
                    String icon_skl2 = snapshot.child("icon_skill2").getValue().toString();
                    String skl3 = snapshot.child("name_skill3").getValue().toString();
                    String icon_skl3 = snapshot.child("icon_skill3").getValue().toString();
                    String detail3 = snapshot.child("detail_skill3").getValue().toString();
                    String imgnp = snapshot.child("npimg").getValue().toString();
                    String npname = snapshot.child("name_np").getValue().toString();
                    String detailnp = snapshot.child("isi_np").getValue().toString();


                    isinp.setText(detailnp);
                    np.setText(npname);
                    Picasso.get().load(imgnp).into(np_img);
                    Picasso.get().load(icon_skill).into(ic_skill1);
                    Picasso.get().load(icon_skl2).into(ic_skill2);
                    Picasso.get().load(icon_skl3).into(ic_skill3);
                    skill3.setText(skl3);
                    skill2.setText(skl2);
                    isi2.setText(detail2);
                    isi3.setText(detail3);
                    isi.setText(detail);
                    skil.setText(skill);
                    ali.setText("Alignment  :  "+alignment);
                    atr.setText("Atribute  :  "+atribut);
                    hp.setText("HP  :  "+hp_servant);
                    atk.setText("Attack  :  "+attack);
                    cost.setText("Cost  :"+"  "+ cost_servant);
                    Picasso.get().load(img).into(arts);
                    star.setText(rarity);
                    Picasso.get().load(icon).into(imageView);
                    textView.setText(names);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}
