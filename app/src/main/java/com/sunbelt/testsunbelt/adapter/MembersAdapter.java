package com.sunbelt.testsunbelt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.sunbelt.testsunbelt.R;
import com.sunbelt.testsunbelt.model.Members;
import java.util.ArrayList;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Members> members=new ArrayList<>();

    public MembersAdapter(Context context, ArrayList<Members> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemCount(){
        return members.size();
    }

    @NonNull
    @Override
    public MembersAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i){
        View viewDetailMembers= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_members,viewGroup,false);
        return  new MembersAdapter.ViewHolder(viewDetailMembers);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageMembers;
        TextView lblNombreCompania,lblTierCompania,lblMountDonate;
        public ViewHolder (@NonNull View itemMemberView){
            super(itemMemberView);
            imageMembers=(ImageView)itemMemberView.findViewById(R.id.imageMembers);
            lblNombreCompania=(TextView)itemMemberView.findViewById(R.id.lblNombreCompania);
            lblTierCompania=(TextView)itemMemberView.findViewById(R.id.lblTierCompania);
            lblMountDonate=(TextView)itemMemberView.findViewById(R.id.lblMountDonate);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull MembersAdapter.ViewHolder viewHolder,int i){
        String montoDonado="$"+members.get(i).getTotalAmountDonated();
        viewHolder.lblNombreCompania.setText(members.get(i).getName());
        viewHolder.lblTierCompania.setText(members.get(i).getTier());
        viewHolder.lblMountDonate.setText(montoDonado);
        Picasso.get().load(members.get(i).getImage()).into(viewHolder.imageMembers);
    }

}
