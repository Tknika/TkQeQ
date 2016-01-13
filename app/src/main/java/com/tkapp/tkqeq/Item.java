package com.tkapp.tkqeq;







import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Item  implements Parcelable
{

	public static final Parcelable.Creator<Item>
	CREATOR = new Parcelable.Creator<Item>() {
		
		public Item createFromParcel(Parcel in) {
			return new Item(in);
		}
		public Item[] newArray(int size) {
			return new Item[size];
		}
		
	};
	
	
	private String mName;
	private String mSurname1;
	private String mSurname2;
	private String mRole;
	private String mProjects;
	private String mEmail;
	private String mTel;
	private String mExt;
	private String mPersonalTel;
	private String mCel;
	private String mPhotoUrl;
	private Bitmap mPhoto;
	
	
	
	public Item ()
	{
		super();
	}
	
	public Item (String name, String surname1, String surname2, String role, String projects, String email, String tel, String ext, String personalTel, String cel, String photoUrl, Bitmap Photo)
	{
		//clase para guardar los datos
		super();
		setName (name);
		setSurname1 (surname1);
		setSurname2 (surname2);
		setRole (role);
		setProjects (projects);
		setEmail (email);
		setTel (tel);
		setExt (ext);
		setPersonalTel (personalTel);
		setCel (cel);
		setPhotoUrl (photoUrl);
		setPhoto (Photo);
		
	}

	public String getmName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public String getSurname1() {
		return mSurname1;
	}

	public void setSurname1(String mSurname1) {
		this.mSurname1 = mSurname1;
	}
	
	public String getSurname2() {
		return mSurname2;
	}

	public void setSurname2(String mSurname2) {
		this.mSurname2 = mSurname2;
	}

	public String getRole() {
		return mRole;
	}

	public void setRole(String mRole) {
		this.mRole = mRole;
	}
	
	public String getProjects() {
		return mProjects;
	}

	public void setProjects(String mProjects) {
		this.mProjects = mProjects;
	}
	
	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	
	public String getTel() {
		return mTel;
	}

	public void setTel(String mTel) {
		this.mTel = mTel;
	}
	
	public String getExt() {
		return mExt;
	}

	public void setExt(String mExt) {
		this.mExt = mExt;
	}
	
	public String getPersonalTel() {
		return mPersonalTel;
	}

	public void setPersonalTel(String mPersonalTel) {
		this.mPersonalTel = mPersonalTel;
	}
	
	public String getCel() {
		return mCel;
	}

	public void setCel(String mCel) {
		this.mCel = mCel;
	}

	public String getPhotoUrl() {
		return mPhotoUrl;
	}

	public void setPhotoUrl(String mPhotoUrl) {
		this.mPhotoUrl = mPhotoUrl;
	}
	
	public Bitmap getPhoto() {
		
		Log.i("MEZUA", "hartu da argazkia");
		return mPhoto;
	}
	
	public void setPhoto(Bitmap mPhoto) {
		this.mPhoto = mPhoto;
		Log.i("MEZUA", "gorde da argazkia");
	}

	//Parcelable section
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
	
		dest.writeString(mName);
		dest.writeString(mSurname1);
		dest.writeString(mSurname2);
		dest.writeString(mRole);
		dest.writeString(mProjects);
		dest.writeString(mEmail);
		dest.writeString(mTel);
		dest.writeString(mExt);
		dest.writeString(mPersonalTel);
		dest.writeString(mCel);
		dest.writeString(mPhotoUrl);
		
		dest.writeParcelable(mPhoto, flags);
		
	}
	
	public Item (Parcel in)
    {
    	setName (in.readString());
    	setSurname1 (in.readString());
    	setSurname2 (in.readString());
    	setRole (in.readString());
    	setProjects (in.readString());
    	setEmail (in.readString());
    	setTel (in.readString());
    	setExt (in.readString());
    	setPersonalTel (in.readString());
    	setCel (in.readString());
    	setPhotoUrl (in.readString());
    	
    	setPhoto( (Bitmap) in.readParcelable(getClass().getClassLoader()));
    
    }
    

}
	
	

	

	

