package com.tkapp.tkqeq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QeQSarrera extends Activity{

	
	 @Override
	    public void onCreate(Bundle savedInstanceState){ 
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.sarrera);
	        
	        
	        
	        Button euskara = (Button) findViewById(R.id.buttoneu);
	        euskara.setOnClickListener(new OnClickListener() {
	    		    	
	    		@Override
	    		public void onClick(View v) {
	    			// TODO Auto-generated method stub
	    						
	    			Intent saltoAEuskara = new Intent(QeQSarrera.this, QeQMainActivity.class);
	    			saltoAEuskara.putExtra("LANGUAGE", "euskera(Espainia)");					
	    			startActivity(saltoAEuskara);
	    		}
	        });
	        
	        Button espanol = (Button) findViewById(R.id.buttones);
	        espanol.setOnClickListener(new OnClickListener() {
	    		    	
	    		@Override
	    		public void onClick(View v) {
	    			// TODO Auto-generated method stub
	    						
	    			Intent saltoAEspanol = new Intent(QeQSarrera.this, QeQMainActivity.class);
	    			saltoAEspanol.putExtra("LANGUAGE", "español(España)");					
	    			startActivity(saltoAEspanol);
	    		}
	        });
	        
	        Button english = (Button) findViewById(R.id.buttonen);
	        english.setOnClickListener(new OnClickListener() {
	    		    	
	    		@Override
	    		public void onClick(View v) {
	    			// TODO Auto-generated method stub
	    						
	    			Intent saltoAEnglish = new Intent(QeQSarrera.this, QeQMainActivity.class);
	    			saltoAEnglish.putExtra("LANGUAGE", "english(UnitedKingdom)");					
	    			startActivity(saltoAEnglish);
	    		}
	        });
	        
	        
	
	 }	
}
