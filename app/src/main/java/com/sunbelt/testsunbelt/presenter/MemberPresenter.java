package com.sunbelt.testsunbelt.presenter;

import com.sunbelt.testsunbelt.model.Members;
import com.sunbelt.testsunbelt.service.MemberService;
import com.sunbelt.testsunbelt.view.MemberView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Esta clase representa la interfaz de vista del member
 * @author Paula Gaitán
 * @date 14/12/2019
 */
public class MemberPresenter {
    private MemberView memberView;
    private MemberService memberService;
    ArrayList<Members> membersModel;

    public  MemberPresenter(MemberView view){
        this.memberView=view;
        if(this.memberService==null){
            this.memberService=new MemberService();
        }
    }


    public void getMembers() {
        memberService
                .getApi()
                .getMembers()
                .enqueue(new Callback<List<Members>>() {
                    @Override
                    public void onResponse(Call<List<Members>> call, Response<List<Members>> response) {
                        membersModel=new ArrayList<>(response.body());
                        memberView.memberReady(membersModel);
                    }

                    @Override
                    public void onFailure(Call<List<Members>> call, Throwable t) {
                        try {
                            throw new InterruptedException("!!Algo Salió mal!!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
