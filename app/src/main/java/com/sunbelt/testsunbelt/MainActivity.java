package com.sunbelt.testsunbelt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.sunbelt.testsunbelt.adapter.MembersAdapter;
import com.sunbelt.testsunbelt.model.Members;
import com.sunbelt.testsunbelt.presenter.MemberPresenter;
import com.sunbelt.testsunbelt.service.ApiMembers;
import com.sunbelt.testsunbelt.service.ReceptorConectividad;
import com.sunbelt.testsunbelt.view.MemberView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MemberView, ReceptorConectividad.ConnectivityReceiverListener {
    MembersAdapter membersAdapter;
    @BindView(R.id.rvListMembers)
    RecyclerView rvListMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rvListMembers.setLayoutManager(new LinearLayoutManager(this));
        checkConnection();

    }

    @Override
    public void memberReady(ArrayList<Members> members) {
        membersAdapter = new MembersAdapter(MainActivity.this, members);
        rvListMembers.setAdapter(membersAdapter);
    }

    private void checkConnection() {
        boolean isConnected = ReceptorConectividad.isConnected(this);
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        if (isConnected) {
            boolean isDataNetwork = ReceptorConectividad.isOnlineNet();
            if (isDataNetwork) {
                MemberPresenter memberPresenter = new MemberPresenter(this);
                memberPresenter.getMembers();
            } else {
                Toast.makeText(this, "No tiene internet", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No tiene internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkConnection();
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }
}

