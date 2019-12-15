package com.sunbelt.testsunbelt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.sunbelt.testsunbelt.adapter.MembersAdapter;
import com.sunbelt.testsunbelt.model.Members;
import com.sunbelt.testsunbelt.view.ApiMembers;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Members> membersModel = new ArrayList<>();
    MembersAdapter membersAdapter;
    @BindView(R.id.rvListMembers)
    RecyclerView rvListMembers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rvListMembers.setLayoutManager(new LinearLayoutManager(this));
        getResponseApi();
    }

    private void getResponseApi() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://opencollective.com/babel/members/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiMembers responseInterface=retrofit.create(ApiMembers.class);
        Call<List<Members>> call=responseInterface.getMembers();

        call.enqueue(new Callback<List<Members>>() {
            @Override
            public void onResponse(Call<List<Members>> call, Response<List<Members>> response) {
                membersModel=new ArrayList<>(response.body());
                membersAdapter=new MembersAdapter(MainActivity.this,membersModel);
                rvListMembers.setAdapter(membersAdapter);
                Toast.makeText(MainActivity.this,"Datos obtenidos",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Members>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
    }

