package com.sunbelt.testsunbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.sunbelt.testsunbelt.model.Members;

public class ViewMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member);
        Intent i = getIntent();
        Members membersGet = (Members) i.getSerializableExtra("ObjectMember");
        Toast.makeText(this, ""+membersGet.getMemberId(), Toast.LENGTH_SHORT).show();
        Log.i("Object",""+membersGet.getTotalAmountDonated()+" "+membersGet.getDescription());
    }
}
