package com.sunbelt.testsunbelt.view;

import com.sunbelt.testsunbelt.model.Members;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMembers {
    /**
     * metodo que realiza la petición al servidor de la api
     * y obtiene la lista de los members
     */
    @GET("all.json?TierId=1906&limit=15&offset=0&fbclid=IwAR3hxstQW7O_gBGC8VkW8JYESyWCoR6iMMscb3-Z_I34y4SI08UqjL78_qo")
    Call<List<Members>> getMembers();
}
