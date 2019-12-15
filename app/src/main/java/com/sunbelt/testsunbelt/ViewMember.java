package com.sunbelt.testsunbelt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.sunbelt.testsunbelt.model.Members;

public class ViewMember extends AppCompatActivity {
    ImageView ivMembers;
    TextView lblNombreMember,lblRoleMember,lblLevelMember,lblDateMember,lblTotalDonado,lblMoneda,lblUltMovimiento,lblValorMovimient,lblSocialMail,lblSocialGit,lblSocialTw,lblSocialWeb;
    Members membersGet=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        Intent i = getIntent();
        membersGet = (Members) i.getSerializableExtra("ObjectMember");
        ivMembers=(ImageView) findViewById(R.id.ivMembers);
        lblNombreMember=(TextView)findViewById(R.id.lblNombreMember);
        lblRoleMember=(TextView)findViewById(R.id.lblRoleMember);
        lblLevelMember=(TextView)findViewById(R.id.lblLevelMember);
        lblDateMember=(TextView)findViewById(R.id.lblDateMember);

        lblTotalDonado=(TextView)findViewById(R.id.lblTotalDonado);
        lblMoneda=(TextView)findViewById(R.id.lblMoneda);
        lblUltMovimiento=(TextView)findViewById(R.id.lblUltMovimiento);
        lblValorMovimient=(TextView)findViewById(R.id.lblValorMovimient);

        lblSocialMail=(TextView)findViewById(R.id.lblSocialMail);
        lblSocialGit=(TextView)findViewById(R.id.lblSocialGit);
        lblSocialTw=(TextView)findViewById(R.id.lblSocialTw);
        lblSocialWeb=(TextView)findViewById(R.id.lblSocialWeb);
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
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
