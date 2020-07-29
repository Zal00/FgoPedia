package com.nya.fgopedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailCeActivity extends AppCompatActivity {

    private ImageView imageView, ic_type, ic_type1;
    TextView name_ce, star, cost, atk, hp, skill_efc, mlb_efc;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ce);

        //image
        imageView = findViewById(R.id.image_detailCe);
        ic_type = findViewById(R.id.icon_type);
        ic_type1 = findViewById(R.id.icon_type2);

        //Text
        name_ce = findViewById(R.id.name_detailcraft);
        star = findViewById(R.id.rarity_ce);
        cost = findViewById(R.id.cost_ce);
        atk = findViewById(R.id.attack_ce);
        hp = findViewById(R.id.hp_ce);
        skill_efc = findViewById(R.id.skill_effect);
        mlb_efc = findViewById(R.id.mlb_effect);

        //database
        ref = FirebaseDatabase.getInstance().getReference().child("Craft");
        String key = getIntent().getStringExtra("key");
        ref.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    //text
                    String names = snapshot.child("name").getValue().toString();
                    String rarity = snapshot.child("rarity").getValue().toString();
                    String cost_ce = snapshot.child("cost").getValue().toString();
                    String atk_ce = snapshot.child("attack").getValue().toString();
                    String hp_ce = snapshot.child("hp").getValue().toString();
                    String skl_efc = snapshot.child("skill_efect").getValue().toString();
                    String maxlb_efc = snapshot.child("mlb_effect").getValue().toString();

                    //img
                    String img = snapshot.child("image_ce").getValue().toString();
                    String type = snapshot.child("type").getValue().toString();
                    String type2 = snapshot.child("type").getValue().toString();

                    //database
                    //text
                    name_ce.setText(names);
                    star.setText("Rarity : "+rarity);
                    cost.setText("Cost : "+cost_ce);
                    atk.setText("Attack : "+atk_ce);
                    hp.setText("Hp : "+hp_ce);
                    skill_efc.setText(skl_efc);
                    mlb_efc.setText(maxlb_efc);

                    //img
                    Picasso.get().load(img).into(imageView);
                    Picasso.get().load(type).into(ic_type);
                    Picasso.get().load(type2).into(ic_type1);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}