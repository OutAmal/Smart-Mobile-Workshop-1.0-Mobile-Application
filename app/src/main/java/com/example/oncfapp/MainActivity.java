package com.example.oncfapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oncfapp.Adapter.MyAdapter;
import com.example.oncfapp.model.item;
import com.github.arturogutierrez.Badges;
import com.github.arturogutierrez.BadgesNotSupportedException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

import ru.nikartm.support.ImageBadgeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int number;
    FirebaseFirestore db;
    private final String TAG = "data";
    ImageBadgeView train1,train2,train3,train4,train5,train6,train7,train8,train9,train10,train11,train12,train13,train14,train15,train16,train17,train18,train19,train20,train21,train22,train23,train24; ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.trains_list);
        TextView text1 =findViewById(R.id.text1);TextView text2 =findViewById(R.id.text2);TextView text3 =findViewById(R.id.text3);TextView text4 =findViewById(R.id.text4);TextView text5 =findViewById(R.id.text5);TextView text6 =findViewById(R.id.text6);TextView text7 =findViewById(R.id.text7);TextView text8 =findViewById(R.id.text8);TextView text9 =findViewById(R.id.text9);
        TextView text10 =findViewById(R.id.text10);TextView text11 =findViewById(R.id.text11);TextView text12 =findViewById(R.id.text12);TextView text13 =findViewById(R.id.text13);TextView text14 =findViewById(R.id.text14);TextView text15 =findViewById(R.id.text15);TextView text16 =findViewById(R.id.text16);TextView text17 =findViewById(R.id.text17);TextView text18 =findViewById(R.id.text18);
        TextView text19 =findViewById(R.id.text19);TextView text20 =findViewById(R.id.text20);TextView text21 =findViewById(R.id.text21);TextView text22 =findViewById(R.id.text22);TextView text23 =findViewById(R.id.text23);TextView text24 =findViewById(R.id.text24);
        train1 = findViewById(R.id.train1);
        train2 = findViewById(R.id.train2);  train3 = findViewById(R.id.train3);
         train4 = findViewById(R.id.train4);  train5 = findViewById(R.id.train5);  train6 = findViewById(R.id.train6);
         train7 = findViewById(R.id.train7);  train8 = findViewById(R.id.train8);  train9 = findViewById(R.id.train9);
         train10 = findViewById(R.id.train10);  train11 = findViewById(R.id.train11);  train12 = findViewById(R.id.train12);
         train13 = findViewById(R.id.train13);  train14 = findViewById(R.id.train14);  train15 = findViewById(R.id.train15);
         train16 = findViewById(R.id.train16);  train17 = findViewById(R.id.train17);  train18 = findViewById(R.id.train18);
         train19 = findViewById(R.id.train19);  train20 = findViewById(R.id.train20);  train21 = findViewById(R.id.train21);
         train22= findViewById(R.id.train22);  train23 = findViewById(R.id.train23);  train24 = findViewById(R.id.train24);
        train1.setOnClickListener(this); train2.setOnClickListener(this); train3.setOnClickListener(this); train4.setOnClickListener(this); train5.setOnClickListener(this); train6.setOnClickListener(this); train7.setOnClickListener(this); train8.setOnClickListener(this); train9.setOnClickListener(this); train10.setOnClickListener(this);
        train11.setOnClickListener(this); train12.setOnClickListener(this); train13.setOnClickListener(this); train14.setOnClickListener(this); train15.setOnClickListener(this); train16.setOnClickListener(this); train17.setOnClickListener(this); train18.setOnClickListener(this); train19.setOnClickListener(this); train20.setOnClickListener(this);
        train21.setOnClickListener(this); train22.setOnClickListener(this); train23.setOnClickListener(this); train24.setOnClickListener(this);
        numberOfitems("Z2M-101", train1);
        numberOfitems("Z2M-102", train2);
        numberOfitems("Z2M-103", train3);numberOfitems("Z2M-104", train4);numberOfitems("Z2M-105", train5);numberOfitems("Z2M-106", train6);
        numberOfitems("Z2M-107", train7);numberOfitems("Z2M-108", train8);numberOfitems("Z2M-109", train9);numberOfitems("Z2M-110", train10);numberOfitems("Z2M-111", train11);numberOfitems("Z2M-112", train12);numberOfitems("Z2M-113", train13);numberOfitems("Z2M-114", train14);
        numberOfitems("Z2M-115", train15);numberOfitems("Z2M-116", train16);numberOfitems("Z2M-117", train17);numberOfitems("Z2M-118", train18);numberOfitems("Z2M-119", train19);numberOfitems("Z2M-120", train20);
        numberOfitems("Z2M-121", train21);numberOfitems("Z2M-122", train22);numberOfitems("Z2M-123", train23);numberOfitems("Z2M-124", train24);
        //if (train1.getBadgeValue()!= 0){


    }
    // check the clicked button
    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.train1:
                Intent intent1 = new Intent(this, Main2Activity.class);
                intent1.putExtra("TrainId", "01" );
                startActivity(intent1);
                Toast.makeText(this, "Z2M-101 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train2:
                Intent intent2 = new Intent(this, Main2Activity.class);
                intent2.putExtra("TrainId", "02" );
                startActivity(intent2);
                Toast.makeText(this, "Z2M-102 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train3:
                Intent intent3 = new Intent(this, Main2Activity.class);
                intent3.putExtra("TrainId", "03" );
                startActivity(intent3);
                Toast.makeText(this, "Z2M-103 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train4:
                Intent intent4 = new Intent(this, Main2Activity.class);
                intent4.putExtra("TrainId", "04" );
                startActivity(intent4);
                Toast.makeText(this, "Z2M-104 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train5:
                Intent intent5 = new Intent(this, Main2Activity.class);
                intent5.putExtra("TrainId", "05" );
                startActivity(intent5);
                Toast.makeText(this, "Z2M-105 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train6:
                Intent intent6 = new Intent(this, Main2Activity.class);
                intent6.putExtra("TrainId", "06" );
                startActivity(intent6);
                Toast.makeText(this, "Z2M-106 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train7:
                Intent intent7 = new Intent(this, Main2Activity.class);
                intent7.putExtra("TrainId", "07" );
                startActivity(intent7);
                Toast.makeText(this, "Z2M-107 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train8:
                Intent intent8 = new Intent(this, Main2Activity.class);
                intent8.putExtra("TrainId", "08" );
                startActivity(intent8);
                Toast.makeText(this, "Z2M-108 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train9:
                Intent intent9 = new Intent(this, Main2Activity.class);
                intent9.putExtra("TrainId", "09" );
                startActivity(intent9);
                Toast.makeText(this, "Z2M-109 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train10:
                Intent intent10 = new Intent(this, Main2Activity.class);
                intent10.putExtra("TrainId", "10" );
                startActivity(intent10);
                Toast.makeText(this, "Z2M-110 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train11:
                Intent intent11 = new Intent(this, Main2Activity.class);
                intent11.putExtra("TrainId", "11" );
                startActivity(intent11);
                Toast.makeText(this, "Z2M-111 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train12:
                Intent intent12 = new Intent(this, Main2Activity.class);
                intent12.putExtra("TrainId", "12" );
                startActivity(intent12);
                Toast.makeText(this, "Z2M-112 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train13:
                Intent intent13 = new Intent(this, Main2Activity.class);
                intent13.putExtra("TrainId", "13" );
                startActivity(intent13);
                Toast.makeText(this, "Z2M-113 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train14:
                Intent intent14 = new Intent(this, Main2Activity.class);
                intent14.putExtra("TrainId", "14" );
                startActivity(intent14);
                Toast.makeText(this, "Z2M-114 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train15:
                Intent intent15 = new Intent(this, Main2Activity.class);
                intent15.putExtra("TrainId", "15" );
                startActivity(intent15);
                Toast.makeText(this, "Z2M-115 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train16:
                Intent intent16 = new Intent(this, Main2Activity.class);
                intent16.putExtra("TrainId", "16" );
                startActivity(intent16);
                Toast.makeText(this, "Z2M-116 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train17:
                Intent intent17 = new Intent(this, Main2Activity.class);
                intent17.putExtra("TrainId", "17" );
                startActivity(intent17);
                Toast.makeText(this, "Z2M-117 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train18:
                Intent intent18 = new Intent(this, Main2Activity.class);
                intent18.putExtra("TrainId", "18");
                startActivity(intent18);
                Toast.makeText(this, "Z2M-118" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train19:
                Intent intent19 = new Intent(this, Main2Activity.class);
                intent19.putExtra("TrainId", "19" );
                startActivity(intent19);
                Toast.makeText(this, "Z2M-119 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train20:
                Intent intent20 = new Intent(this, Main2Activity.class);
                intent20.putExtra("TrainId", "20" );
                startActivity(intent20);
                Toast.makeText(this, "Z2M-120 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train21:
                Intent intent21 = new Intent(this, Main2Activity.class);
                intent21.putExtra("TrainId", "21" );
                startActivity(intent21);
                Toast.makeText(this, "Z2M-121 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train22:
                Intent intent22 = new Intent(this, Main2Activity.class);
                intent22.putExtra("TrainId", "22" );
                startActivity(intent22);
                Toast.makeText(this, "Z2M-122 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train23:
                Intent intent23 = new Intent(this, Main2Activity.class);
                intent23.putExtra("TrainId", "23" );
                startActivity(intent23);
                Toast.makeText(this, "Z2M-123 " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.train24:
                Intent intent24 = new Intent(this, Main2Activity.class);
                intent24.putExtra("TrainId", "24" );
                startActivity(intent24);
                Toast.makeText(this, "Reservé " , Toast.LENGTH_SHORT).show();
                break;




                // Do something
        }
    }
    // count the number of documents in one collection

    private void numberOfitems(final String string, final ImageBadgeView view){

        db.getInstance().collection(string)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count;
                            count = 0;
                            for (DocumentSnapshot document : task.getResult()) {
                                  count++;
                            }
                            view.setBadgeValue(count);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

        // refresh the activity every one second

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                numberOfitems( string,  view);

            }
        };
        handler.postDelayed(runnable, 1000);

    }
    public void IconBadge(int count ){
        try {
            Badges.setBadge(MainActivity.this, count);
        }

        catch (BadgesNotSupportedException badgesNotSupportedException) {
            Log.d(TAG, badgesNotSupportedException.getMessage());
        }
    }
    protected void onStart() {
        super.onStart();
        int count = train1.getBadgeValue() + train3.getBadgeValue();
        IconBadge(count);

    }





}

