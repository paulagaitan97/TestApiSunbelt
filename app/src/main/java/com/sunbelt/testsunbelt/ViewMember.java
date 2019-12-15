package com.sunbelt.testsunbelt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.sunbelt.testsunbelt.model.Members;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewMember extends AppCompatActivity {
    @BindView(R.id.ivMembers)
    ImageView ivMembers;
    @BindView(R.id.lblNombreMember)
    TextView lblNombreMember;
    @BindView(R.id.lblRoleMember)
    TextView lblRoleMember;
    @BindView(R.id.lblLevelMember)
    TextView lblLevelMember;
    @BindView(R.id.lblDateMember)
    TextView lblDateMember;
    @BindView(R.id.lblTotalDonado)
    TextView lblTotalDonado;
    @BindView(R.id.lblMoneda)
    TextView lblMoneda;
    @BindView(R.id.lblUltMovimiento)
    TextView lblUltMovimiento;
    @BindView(R.id.lblValorMovimient)
    TextView lblValorMovimient;
    @BindView(R.id.lblSocialMail)
    TextView lblSocialMail;
    @BindView(R.id.lblSocialGit)
    TextView lblSocialGit;
    @BindView(R.id.lblSocialTw)
    TextView lblSocialTw;
    @BindView(R.id.lblSocialWeb)
    TextView lblSocialWeb;

    Members membersGet=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        ButterKnife.bind(this);
        membersGet = (Members) getIntent().getSerializableExtra("ObjectMember");
        loadData();
    }

    public void loadData(){
        lblNombreMember.setText(membersGet.getName());
        lblRoleMember.setText(membersGet.getRole());
        lblLevelMember.setText(membersGet.getTier());
        lblDateMember.setText(membersGet.getCreatedAt());
        Picasso.get().load(membersGet.getImage()).into(ivMembers);
        lblTotalDonado.setText(String.valueOf(membersGet.getTotalAmountDonated()));
        lblMoneda.setText(membersGet.getCurrency());
        lblUltMovimiento.setText(membersGet.getLastTransactionAt());
        lblValorMovimient.setText(String.valueOf(membersGet.getLastTransactionAmount()));
        lblSocialMail.setText(String.valueOf(membersGet.getEmail()));
        lblSocialGit.setText(String.valueOf(membersGet.getGithub()));
        lblSocialTw.setText(String.valueOf(membersGet.getTwitter()));
        lblSocialWeb.setText(String.valueOf(membersGet.getWebsite()));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(ViewMember.this,MainActivity.class);
                startActivity(intent);
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
