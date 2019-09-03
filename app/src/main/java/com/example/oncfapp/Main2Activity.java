package com.example.oncfapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.util.Log;
import com.example.oncfapp.Adapter.MyAdapter;
import com.example.oncfapp.model.item;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Nullable;


public class Main2Activity extends AppCompatActivity {


    ArrayList list, list3 , list4 , list5, list6, list7, list8, list9 , list10 , list11, list12 = new ArrayList<item>();
    ArrayList list2 , list13 , list14 , list15 , list16, list17, list18, list19, list20 , list21 , list22, list23 , list24 = new ArrayList<item>();
    MyAdapter adapter;
    RecyclerView recyclerView;
    private final String TAG = "data";
    FirebaseFirestore db;
    private final String LIST_INSTANCE_STATE = "list view";
    private static Bundle mBundleState;
    String CHANNEL_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        // check which train is selected
        String i = intent.getStringExtra("TrainId");
        String Z2M_id = "Z2M-1".concat(i) ;

        if (i == "01") {
            UpDateDocuments(Z2M_id, list);

        }
        else if (i == "02"){
            UpDateDocuments(Z2M_id, list2);
        }
        else if (i == "03"){
            UpDateDocuments(Z2M_id, list3);

        }
        else if (i == "04"){
            UpDateDocuments(Z2M_id, list4);
        }
        else if (i == "05"){
            UpDateDocuments(Z2M_id, list5);
        }
        else if (i == "06"){
            UpDateDocuments(Z2M_id, list6);
        }
        else if (i == "07"){
            UpDateDocuments(Z2M_id, list7);
        }
        else if (i == "08"){
            UpDateDocuments(Z2M_id, list8);
        }
        else if (i == "09"){
            UpDateDocuments(Z2M_id, list9);
        }
        else if (i == "10"){
            UpDateDocuments(Z2M_id, list10);
        }
        else if (i == "11"){
            UpDateDocuments(Z2M_id, list11);
        }
        else if (i == "12"){
            UpDateDocuments(Z2M_id, list12);
        }
        else if (i == "13"){
            UpDateDocuments(Z2M_id, list13);
        }
        else if (i == "14"){
            UpDateDocuments(Z2M_id, list14);
        }
        else if (i == "15"){
            UpDateDocuments(Z2M_id, list15);
        }
        else if (i == "16"){
            UpDateDocuments(Z2M_id, list16);
        }
        else if (i == "17"){
            UpDateDocuments(Z2M_id, list17);
        }
        else if (i == "18"){
            UpDateDocuments(Z2M_id, list18);
        }
        else if (i == "19"){
            UpDateDocuments(Z2M_id, list19);
        }
        else if (i == "20"){
            UpDateDocuments(Z2M_id, list20);
        }
        else if (i == "21"){
            UpDateDocuments(Z2M_id, list21);
        }
        else if (i == "22"){
            UpDateDocuments(Z2M_id, list22);
        }
        else if (i == "23"){
            UpDateDocuments(Z2M_id, list23);
        } else {
            UpDateDocuments(Z2M_id, list24);
        }

    }

    private void UpDateDocuments(final String string, final  ArrayList<item> list ) {

        db.getInstance().collection(string)
                .addSnapshotListener(MetadataChanges.INCLUDE, new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot querySnapshots, @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w(TAG, "Listen error", e);
                            return;
                        }

                        for (DocumentChange change : querySnapshots.getDocumentChanges()) {
                            item item = change.getDocument().toObject(item.class);

                            switch (change.getType()) {
                             // check if there is a new breakdown
                                case ADDED: {
                                    if (list.isEmpty()){
                                        list.add(item);
                                    }
                                   else {
                                    for ( int i=0 ; i < list.size() ; i++){
                                        if (list.get(i).getCode() != item.getCode()){
                                            list.add(item);
                                            break;
                                        }
                                    }
                                    }
                                    addNotification(string,  " EST EN PANNE");
                                }
                                break;
                                // check if a breakdown state has been modified from On to OFF , if so delete it
                                // from Firestore and Android RecyclerView.
                                case MODIFIED: {
                                    addNotification(string , "UNE PANNE EST CORRIGEE");

                                    // remove the item who s field has been changed for my recyclerView

                                    for (int i = 0; i < list.size(); i++) {

                                        if ( list.get(i).getCode().equals (item.getCode())  ) {
                                            int myPosition = list.indexOf(list.get(i));
                                            adapter.removeItem(myPosition);
                                            adapter.notifyDataSetChanged();
                                        }
                                    }

                                    String groupId = change.getDocument().getId();
                                    FirebaseFirestore.getInstance()
                                            .collection(string)
                                            .document(groupId).delete();
                                }
                                    break;

                                    case REMOVED:
                                        break;
                                }

                            adapter = new MyAdapter(list);
                            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
                            recyclerView.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
                            recyclerView.setHasFixedSize(true);
                            recyclerView.setAdapter(adapter);


                            }

                            String source = querySnapshots.getMetadata().isFromCache() ?
                                    "local cache" : "server";
                            Log.d(TAG, "Data fetched from " + source);
                        }

                });
    }
    // For notifications when a breakdown happened or deleted
    private void addNotification (String string , String message){

         // build the notification

        NotificationCompat.Builder builder = new NotificationCompat.Builder(Main2Activity.this , CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_train_black_24dp)
                .setContentTitle( "URGENT !!" )
                .setContentText( string + message )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // create an intent to train list activity

        Intent intentfornotif = new Intent(this, MainActivity.class);
        intentfornotif.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intentfornotif, 0);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        // set the notification
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setLights(Color.CYAN, 1000, 1000);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(Main2Activity.this);
        int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
        notificationManager.notify(m, builder.build());

    }
    // to Save the state of list when activity is stopped

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(LIST_INSTANCE_STATE,list);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        list = savedInstanceState.getParcelableArrayList(LIST_INSTANCE_STATE);
    }


    @Override
    protected void onPause() {
        super.onPause();
        mBundleState = new Bundle();
        mBundleState.putParcelableArrayList(LIST_INSTANCE_STATE, list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mBundleState != null){
            list = mBundleState.getParcelableArrayList(LIST_INSTANCE_STATE);
        }
    }
}




