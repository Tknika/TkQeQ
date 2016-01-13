package com.tkapp.tkqeq;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class QeQMainActivity extends Activity {

	public String mLanguage;
		
    @Override
    public void onCreate(Bundle savedInstanceState){ 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qeq_main);
        
        //Detectamos el idioma por defecto del terminal
        String localeLanguage = getApplicationContext().getResources().getConfiguration().locale.getDisplayName();
               
        mLanguage = localeLanguage;
        

        Toast.makeText(getApplicationContext(),mLanguage,Toast.LENGTH_LONG).show();
        
        

        
    Button executive = (Button) findViewById(R.id.buttonexe);
    executive.setOnClickListener(new OnClickListener() {
		    	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
						
			Intent saltoAExecutive = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoAExecutive.putExtra("CATEGORY","executive");
			saltoAExecutive.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoAExecutive);
		}
    });
    
    Button communication = (Button) findViewById(R.id.buttoncom);
    communication.setOnClickListener(new OnClickListener() {
		    	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
						
			Intent saltoACommunication = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoACommunication.putExtra("CATEGORY","communication");
			saltoACommunication.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoACommunication);
		}
    });
	
	Button general = (Button) findViewById(R.id.buttongen);
    general.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			Intent saltoAGeneral = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoAGeneral.putExtra("CATEGORY","general");
			saltoAGeneral.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoAGeneral);
			
			
			}
	});
    
    Button technology = (Button) findViewById(R.id.buttontec);
    technology.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			Intent saltoATechnology = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoATechnology.putExtra("CATEGORY","technology");
			saltoATechnology.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoATechnology);
			
			
			}
	});
        
    Button ict = (Button) findViewById(R.id.buttonict);
    ict.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			Intent saltoAIct = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoAIct.putExtra("CATEGORY","ict");
			saltoAIct.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoAIct);
			
			
			}
	});        

    Button management = (Button) findViewById(R.id.buttonman);
    management.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			Intent saltoAManagement = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoAManagement.putExtra("CATEGORY","management");
			saltoAManagement.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoAManagement);
			
			
			}
	});
    
    Button training = (Button) findViewById(R.id.buttontra);
    training.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			Intent saltoATraining = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoATraining.putExtra("CATEGORY","training");
			saltoATraining.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoATraining);
			
			
			}
	});
    
    Button innovation = (Button) findViewById(R.id.buttoninn);
    innovation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			Intent saltoAInnovation = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoAInnovation.putExtra("CATEGORY","innovation");
			saltoAInnovation.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoAInnovation);
			
			
			}
	});
    
    Button internationalization = (Button) findViewById(R.id.buttonnaz);
    internationalization.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			Intent saltoAInternationalization = new Intent(QeQMainActivity.this, ListaJson.class);
			saltoAInternationalization.putExtra("CATEGORY","internationalization");
			saltoAInternationalization.putExtra("LANGUAGE",mLanguage);
			startActivity(saltoAInternationalization);
			
			
			}
	});
    
    }
    
    
    
    
}
