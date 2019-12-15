package com.sunbelt.testsunbelt.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Esta clase representa el member servicio
 * @author Paula Gaitán
 * @date 14/12/2019
 */

public class MemberService {
    private Retrofit retrofit = null;

    /**
     * Este método crea una nueva instancia de la interfaz API.
     * @return la interfaz Api
     */
    public ApiMembers getApi(){
        String BASE_URL="https://opencollective.com/babel/members/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiMembers.class);
    }
}
