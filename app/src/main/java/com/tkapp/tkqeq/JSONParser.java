package com.tkapp.tkqeq;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {
	
	//Teniendo un string como entrada devuelve un string de objetos ITEM
	private String mJsonString;
	private String category;
	
	public JSONParser (String str, String mCategory)
	{
		super();
		mJsonString = str;
		category = mCategory;
	}

	public ArrayList<Item> parser ()
	{
		
		ArrayList<Item> arrayItem = new ArrayList<Item>();
		
		JSONObject json;
		JSONArray jarray;
		
		
		try {
			json = new JSONObject(mJsonString);
			
			
			if (json.has(category))
			{
				
				//Se extrae el array
				jarray =json.getJSONArray(category);
				for (int i=0; i<jarray.length(); i++)
				{
					JSONObject jsonItem = jarray.getJSONObject(i);
					Item item = parseItem(jsonItem);
					arrayItem.add(item);
				}
					
			}
			else
				Log.e("JSONPARSER", "JSON mal formado, falta results");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.d("JSONPARSER", e.getMessage());
			return null;
			
		}
		return arrayItem;
	}
	
	private Item parseItem (JSONObject jsonObject) throws JSONException
	{
		Item item = new Item();
		
		if (jsonObject.has("photo_url"))
			item.setPhotoUrl(jsonObject.getString("photo_url"));
		
		if (jsonObject.has("name"))
			item.setName(jsonObject.getString("name"));
		
		if (jsonObject.has("surname1"))
			item.setSurname1(jsonObject.getString("surname1"));
		
		if (jsonObject.has("role"))
			item.setRole(jsonObject.getString("role"));
		
		if (jsonObject.has("projects"))
			item.setProjects(jsonObject.getString("projects"));
		
		if (jsonObject.has("email"))
			item.setEmail(jsonObject.getString("email"));
		
		if (jsonObject.has("tel"))
			item.setTel(jsonObject.getString("tel"));
		
		if (jsonObject.has("ext"))
			item.setExt(jsonObject.getString("ext"));
		
		if (jsonObject.has("cel"))
			item.setCel(jsonObject.getString("cel"));
		
				
		/*if (jsonObject.has("external_info"))
		{
			JSONObject jsonInfo = jsonObject.getJSONObject("external_info");
			
			if (jsonInfo.has("info_url"))
				item.setInfoUrl(jsonInfo.getString("info_url"));
				
			if (jsonInfo.has("photo_thumb"))
				item.setPhotoUrl(jsonInfo.getString("photo_thumb"));
		}*/	
		
		return item;
		
	}
	
}
