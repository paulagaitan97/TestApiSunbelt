package com.sunbelt.testsunbelt.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.sunbelt.testsunbelt.R;
import com.sunbelt.testsunbelt.ViewMember;
import com.sunbelt.testsunbelt.model.Members;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * La Clase MembersAdapter es un objeto adapter que actua como puente entre
 * los datos de la vista y ella misma. Proporciona acceso a los elementos.
 */

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder>{
    // contexto de la vista
    private Context context;
    //lista de members
    private ArrayList<Members> members;

    public MembersAdapter(Context context, ArrayList<Members> members) {
        this.context = context;
        this.members = members;
    }

    //cantidad de members en la lista
    @Override
    public int getItemCount(){
        return members.size();
    }

    //La clase MembersAdapter es responsable de crear una vista para cada elemento del conjunto de datos

    @NonNull
    @Override
    public MembersAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i){
        View viewDetailMembers= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_members,viewGroup,false);
        return  new MembersAdapter.ViewHolder(viewDetailMembers);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageMembers)
        ImageView imageMembers;
        CardView cvMembers;
        @BindView(R.id.lblNombreCompania)
        TextView lblNombreCompania;
        @BindView(R.id.lblTierCompania)
        TextView lblTierCompania;
        @BindView(R.id.lblMountDonate)
        TextView lblMountDonate;
        Members getMember=null;
        int code;
        public ViewHolder (@NonNull View itemMemberView){
            super(itemMemberView);
            ButterKnife.bind(this,itemMemberView);
            cvMembers=(CardView)itemMemberView.findViewById(R.id.cvMembers);
            cvMembers.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent viewMember=new Intent(v.getContext(),ViewMember.class);
                    viewMember.putExtra("ObjectMember",getMember);
                    v.getContext().startActivity(viewMember);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MembersAdapter.ViewHolder viewHolder,int i){
        String montoDonado="$"+members.get(i).getTotalAmountDonated();
        viewHolder.lblNombreCompania.setText(members.get(i).getName());
        viewHolder.lblTierCompania.setText(members.get(i).getTier());
        viewHolder.lblMountDonate.setText(montoDonado);
        Picasso.get().load(members.get(i).getImage()).into(viewHolder.imageMembers);
        viewHolder.code=members.get(i).getMemberId();
        viewHolder.getMember=new Members(members.get(i).getMemberId(),members.get(i).getCreatedAt(),members.get(i).getType(),members.get(i).getRole(),members.get(i).getTier(),members.get(i).getIsActive(),members.get(i).getTotalAmountDonated(),members.get(i).getCurrency(),members.get(i).getLastTransactionAt(),members.get(i).getTotalAmountDonated(),members.get(i).getProfile(),members.get(i).getName(),members.get(i).getCompany(),members.get(i).getDescription(),members.get(i).getImage(),members.get(i).getEmail(),members.get(i).getTwitter(),members.get(i).getGithub(),members.get(i).getWebsite());
    }

}
