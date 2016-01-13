package com.tkapp.tkqeq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class DetalleItem extends Activity{
 
 
        public Item mItem;
        private Context  mContext;
 
 
       
         @Override
            public void onCreate(Bundle savedInstanceState) {
                               
                super.onCreate(savedInstanceState);
                setContentView(R.layout.detalleitem);
               
                       
                Intent i = getIntent();
                final Item mItem = i.getParcelableExtra("DATOS");
               
                mContext = this;
               
                         
                                   
                ImageView image = (ImageView) this.findViewById(R.id.photo);
                image.setImageBitmap(mItem.getPhoto());
                                              
                TextView tvName = (TextView) this.findViewById(R.id.name);
                tvName.setText(mItem.getmName());
                       
                TextView tvSurname1 = (TextView) this.findViewById(R.id.surname1);
                tvSurname1.setText(mItem.getSurname1());
                        
                TextView tvRole = (TextView) this.findViewById(R.id.role);
                tvRole.setText(mItem.getRole());
                
                TextView tvProjects = (TextView) this.findViewById(R.id.projects);
                tvProjects.setText(R.string.proiektuak);
                                                
                TextView tvRelatedProjects = (TextView) this.findViewById(R.id.relatedprojects);
                tvRelatedProjects.setText(mItem.getProjects());
                 
                ImageButton LlamarATknika = (ImageButton) this.findViewById(R.id.buttontel);
                LlamarATknika.setOnClickListener(new OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        			
        				try {
							startActivity(new Intent(Intent.ACTION_CALL, Uri
									.parse("tel:" + mItem.getTel())));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
                });
                
                ImageButton MandarCorreo = (ImageButton) this.findViewById(R.id.buttonemail);
                MandarCorreo.setOnClickListener(new OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        			
        				Intent emailIntent = new Intent(Intent.ACTION_SEND);
        			    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String [] {mItem.getEmail().toString()});
        			    emailIntent.setType("message/rfc822");
        			    startActivity(emailIntent);
					}
                });
                
                ImageButton LlamarAMovil = (ImageButton) this.findViewById(R.id.buttoncel);
                LlamarAMovil.setOnClickListener(new OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        			
        				try {
							startActivity(new Intent(Intent.ACTION_CALL, Uri
									.parse("tel:" + mItem.getCel())));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
                });
                
                        
                       
                }
         
}

