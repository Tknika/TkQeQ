package com.tkapp.tkqeq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaJson extends ListActivity {

	
	final String URL_JSON_ES = "http://dokumentuak.tknika.net/alfresco/s/api/node/content/workspace/SpacesStore/0c2b9d71-d194-4712-9abf-afd6d75f4db0/TknikaQuienEsQuienCentros.json?guest=true&a=true";
	final String URL_JSON_EU = "http://dokumentuak.tknika.net/alfresco/s/api/node/content/workspace/SpacesStore/30d4dab4-630a-4dda-86a7-8d48f298b5a1/TknikaZeinDaZeinIkastetxeak.json?guest=true&a=true";
	final String URL_JSON_EN = "http://dokumentuak.tknika.net/alfresco/s/api/node/content/workspace/SpacesStore/fbea5196-3204-4ceb-aee8-d90af61eb759/TknikaWhoIsWhoCentres.json?guest=true&a=true";

	public String mURL_JSON;
	
	
	//http://dokumentuak.tknika.net/download.html?id=0c2b9d71-d194-4712-9abf-afd6d75f4db0/TknikaQuienEsQuienCentros.json
	
	private Context  mContext;
	
	public String mCategory;
	
	public String mLanguage;
	
	public String lastLanguage;
		
	private ArrayList<Item> mArray;
	
	public String c2cTel;
	
	
	
	
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
            	  	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_json);
        
                
        Intent i = getIntent();
        String category = i.getStringExtra("CATEGORY");
        String language = i.getStringExtra("LANGUAGE");
        
        mCategory = category;
        mLanguage = language;
        
        StrictMode.ThreadPolicy policy = new
        StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);
        
        mContext = this; 
        
        /*TextView tvJson = (TextView) this.findViewById(R.id.tvJson);
        
        detectar_conectividad();
        tvJson.setText(detectar_conectividad());*/
        
        	if (mLanguage.equals(lastLanguage)){
        	        
        		if (!existsJsonFile("jsonEdukia.json")) {
			
        			DownloadJSON json = new DownloadJSON();
        			json.execute(null, null, null);			
					}else{
			
						JSONOsatu jsonOsatu = new JSONOsatu();
						jsonOsatu.execute(null, null, null);
				}
        	}else{
        		DownloadJSON json = new DownloadJSON();
    			json.execute(null, null, null);
        	}
        			  
			 lastLanguage = mLanguage;
          
        
        
        
    }
    
  
    
 // Paso de todos los datos individuales a una nueva vista
 	

 	

	@Override
 	protected void onListItemClick(ListView l, View v, int position, long id) {

 		super.onListItemClick(l, v, position, id);

 		Item datosDetalle = mArray.get(position);
 	    Intent saltoADetalle = new Intent(this, DetalleItem.class);
 	    saltoADetalle.putExtra("DATOS", datosDetalle);
 		startActivity(saltoADetalle);
 				
 		}

    
    
   //metodo para detectar la conectividad; devuelve un string que luego presentaremos 
   /* private String detectar_conectividad(){
	   
	   final ConnectivityManager conMan = (ConnectivityManager)
			 getSystemService(Context.CONNECTIVITY_SERVICE);
	   final State mobile = conMan.getNetworkInfo(0).getState();
	   final State wifi = conMan.getNetworkInfo(1).getState();
	   
	   if (mobile == NetworkInfo.State.CONNECTED)
		   return  "mobile";
	   else if (wifi == NetworkInfo.State.CONNECTED)
		   return  "wifi";
	   
	   return "no detectado";
	   
   }*/
	
	
	
	
   //clase AsyncTask para descargar el archivo JSON
   public class DownloadJSON extends AsyncTask<Void, Void, Void>
   {

	ProgressDialog  pd;
	
	
	
	
		
	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		pd = ProgressDialog.show(mContext, "Jaisten", "Datuak biltzen...");
		
	}   
	//El doInBackground se ejecuta en otro thread diferente al principal
	@Override
	protected Void doInBackground(Void... params) {
		
		String URL_JSON = definirUrlJson(mLanguage);
		
		mURL_JSON = URL_JSON;
		
		doGetPetition(mURL_JSON);
		
		//Para definir un tiempo + lo que tarda la petición
		
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//Recogemos el archivo JSON
		String str = doGetPetition(mURL_JSON);
		
		// Guardamos el archivo Json en el dispositivo
		try {
			OutputStreamWriter jsonFitxategia = new OutputStreamWriter(
					openFileOutput("jsonEdukia.json",
							Context.MODE_PRIVATE));

			jsonFitxategia.write(str);
			jsonFitxategia.close();

		} catch (Exception ex) {
			Log.e("Fitxategiak", "Errorea barne memorian idazterakoan");
		}
		
		//Parseamos el JSON pasándolo por la clase JSONParser
		JSONParser jsonP = new JSONParser(str, mCategory);
		mArray = jsonP.parser();
		
		
		return null;
	
	}
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		if (pd.isShowing())
			pd.dismiss();
		
		
				
		//Presentamos la información del número de elementos del array
		/*Toast.makeText(mContext, "Número de elementos: " +
					    String.valueOf(mArray.size()),
					    Toast.LENGTH_SHORT).show();
		*/
		
		MyAdapter adapter = new MyAdapter();
		setListAdapter(adapter);
		
	}
	   
   }
   
// clase AsyncTask para formar el archivo JSON sin descargar
		public class JSONOsatu extends AsyncTask<Void, Void, Void> {

			ProgressDialog pd;

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				
				pd = ProgressDialog.show(mContext, "Mesedez, itxaron momentu batean. ",
						"Zerrenda osatzen...");
			}

			// El doInBackground se ejecuta en otro thread diferente al principal
			@Override
			protected Void doInBackground(Void... params) {
				
					 
					// leer y parsear json

					try {
						// Abrimos el archivo
						File jsonFitxategia = new File(getFilesDir()
								+ "/jsonEdukia.json");
						
						//convertir lo leido en string
						BufferedReader jsonIrakurketa = new BufferedReader(
								new InputStreamReader(new FileInputStream(
										jsonFitxategia)));
						
						StringBuilder sb = new StringBuilder();
						String line = null;
					    try {
					      while ((line = jsonIrakurketa.readLine()) != null) {
					        sb.append(line + "\n");
					      }
					    } catch (IOException e) {
					      e.printStackTrace();
					    } 
					    
					    String str= sb.toString();
					    
						jsonIrakurketa.close();
						
						// Parseamos el JSON pasándolo por la clase JSONParser
						JSONParser jsonP = new JSONParser(str, mCategory);
						mArray = jsonP.parser();
						
					} catch (Exception ex) {
						Log.e("Fitxategiak", "Errorea barne memorian irakurtzerakoan");
					}
					
				return null;

			}

			@Override
			protected void onPostExecute(Void result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);

				if (pd.isShowing())
					pd.dismiss();
				
				MyAdapter adapter = new MyAdapter();
				setListAdapter(adapter);

			}

		}
   
   private String doGetPetition (String url)
   {
	   try
	   {
		   DefaultHttpClient httpclient = new DefaultHttpClient();
		   HttpGet httpGet = null;
		   httpGet = new HttpGet(url);
		   HttpResponse response = httpclient.execute(httpGet);
		   HttpEntity entity = response.getEntity();
		   String str = EntityUtils.toString(entity, HTTP.UTF_8); // añadir HTTP.UTF_8 para codificar caracteres como tildes,ñs etc.
		 		 		   
		   Log.d("JSON", str);
		   
		   return str;
	   } catch (IOException e) {
		   Log.e("doGet",e.getMessage());
		   return null;
	   }
   }
    
    

   public class MyAdapter extends BaseAdapter
   {
    

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mArray.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// Se llena la vista item, que presenta el elemento que nos interesa del array
		View view = null;
		
		LayoutInflater inflater = (LayoutInflater) mContext
		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		view = inflater.inflate(R.layout.item, null);
		
		ImageView image = (ImageView) view.findViewById(R.id.photo);
		
		Bitmap argazkia = mArray.get(position).getPhoto();
		if (argazkia==null){

		     argazkia=getBitmapFromURL(mArray.get(position).getPhotoUrl());

		     mArray.get(position).setPhoto(argazkia); 
		     //item.setPhoto(argazkia);

		     image.setImageBitmap(argazkia);

		     Log.i("MEZUA", "argazkia deskargatu du");
		}
			else{
				Log.i("MEZUA", "ez du argazkia deskargatu");
				image.setImageBitmap(argazkia);
			}
		
		
		
		
			
		TextView tvName = (TextView) view.findViewById(R.id.name);
		tvName.setText(mArray.get(position).getmName());
		
		TextView tvSurname1 = (TextView) view.findViewById(R.id.surname1);
		tvSurname1.setText(mArray.get(position).getSurname1());
		
		TextView tvRole = (TextView) view.findViewById(R.id.role);
		tvRole.setText(mArray.get(position).getRole());
		
		TextView tvEmail = (TextView) view.findViewById(R.id.email);
		tvEmail.setText("Email: " + mArray.get(position).getEmail());
				
		TextView tvTel = (TextView) view.findViewById(R.id.tel);
		tvTel.setText("Tel: " + mArray.get(position).getTel());
		
		TextView tvExt = (TextView) view.findViewById(R.id.ext);
		tvExt.setText("Ext: " + mArray.get(position).getExt());
				
		TextView tvCel = (TextView) view.findViewById(R.id.cel);
		tvCel.setText("M: " + mArray.get(position).getCel());
		
		
		return view;
	
	}
	
	/* 
	public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_json, menu);
        return true;
    }
    */ 
	
   }
      
   private Bitmap getBitmapFromURL(String urlBitmap) {
       try {
           URL url = new URL(urlBitmap);
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           connection.setDoInput(true);
           connection.connect();
           InputStream input = connection.getInputStream();
           Bitmap myBitmap = BitmapFactory.decodeStream(input);           
           return myBitmap;
          
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
   }
   
 //Json fitxategia existitzen edo ez jakiteko funtzioa; existitzen bada true bueltatzen du bestela false.
 	public boolean existsJsonFile(String fileName) {
 		for (String tmp : fileList()) {
 			if (tmp.equals(fileName))
 				return true;
 		}
 		return false;
 	}
 	
 	public String definirUrlJson (String language){
 		
 		String url_json;
 		
 		if (language.equals("español (España)")){
 			url_json = URL_JSON_ES;
 		}
 		else{
 			 if (language.equals("euskera (Espainia)")){
 			 url_json = URL_JSON_EU;
 		}
 		else{
 			 url_json = URL_JSON_EN;
 		}
 		}
		return url_json;
 	}
 	 
}


