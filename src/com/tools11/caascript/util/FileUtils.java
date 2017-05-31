package com.tools11.caascript.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.content.Context;

public class FileUtils {
	
	private Context mContext;
	
	public FileUtils (Context context){
		mContext = context;
	}
	public String getExternalStorageDir(){
		return "/sdcard";
	}
	
	public boolean mkdir(int path){
		return false;
	}
	
	public void saveStringBufferAsFile(String s,String path){
		File fp = new File(path);
		try {
			FileOutputStream fos= new FileOutputStream(fp);
			fos.write(s.getBytes());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public byte[] loadStringFromFile(String path){
		byte[] buff = null;
		File fp = new File(path);
		long len = fp.length();
		try {
			FileInputStream fis= new FileInputStream(fp);
			buff = new byte[(int) len];
			fis.read(buff);
			fis.close();
			return buff;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
