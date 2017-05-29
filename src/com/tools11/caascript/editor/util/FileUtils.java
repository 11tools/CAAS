package com.tools11.caascript.editor.util;

import java.io.File;
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
}
