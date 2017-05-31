package com.tools11.caascript.editor;

import java.io.File;
import java.io.UnsupportedEncodingException;

import com.tools11.caascript.R;
import com.tools11.caascript.R.layout;
import com.tools11.caascript.R.menu;
import com.tools11.caascript.caascore.CAASEngine;
import com.tools11.caascript.util.FileUtils;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditerActivity extends Activity implements View.OnClickListener {

	private String TAG = "EditerActivity";
	private Context mContext;
	private EditText mEditText;
	private Button mSave;
	private Button mLoad;
	private Button mRun;
	private Button mStart;
	private Button mStop;
	private Button mPause;
	private StringBuffer mfull;
	private FileUtils mFu;
	private CAASEngine mCaas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editer);
		mContext = (Context)this;
		mEditText = (EditText)findViewById(R.id.mainedit);
		mSave = (Button)findViewById(R.id.save);
		mLoad = (Button)findViewById(R.id.load);
		mRun = (Button)findViewById(R.id.run);
		mStart= (Button)findViewById(R.id.start);
		mStop = (Button)findViewById(R.id.stop);
		mPause= (Button)findViewById(R.id.pause);
		mSave.setOnClickListener(this);
		mLoad.setOnClickListener(this);
		mRun.setOnClickListener(this);
		mStart.setOnClickListener(this);
		mStop.setOnClickListener(this);
		mPause.setOnClickListener(this);
		mFu = new FileUtils(mContext);
		Log.d(TAG,"init finish");
	
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editer, menu);
		return true;
	}

	private void loadFileFromSystem(){
	    File file = new File("/sdcard/caas");  
	    File parentFlie = new File(file.getParent());  
	    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  
	    intent.setDataAndType(Uri.fromFile(parentFlie), "*/*");  
	    intent.addCategory(Intent.CATEGORY_OPENABLE);  
	     try {  
	         startActivityForResult(Intent.createChooser(intent, "set a file"),0);  
	     } catch (android.content.ActivityNotFoundException ex) {  
	         // Potentially direct the user to the Market with a Dialog  

	     }    
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) { 
		if(resultCode==Activity.RESULT_OK){
			Uri uri = data.getData();
			String path = uri.getPath();
			Log.d(TAG,"path = " + path);
			if(path!=null){
				byte[] text = mFu.loadStringFromFile(path);
				Log.d(TAG,"text");
				try {
					mEditText.setText(new String(text,"UTF-8"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.save:
			mFu.saveStringBufferAsFile(mEditText.getText().toString(),mFu.getExternalStorageDir() + "/caas.txt");
			Toast.makeText(mContext, "save ok", Toast.LENGTH_SHORT).show();
			break;
		case R.id.load:
			loadFileFromSystem();
			break;
		case R.id.run:
			mCaas = new CAASEngine(mEditText.getText().toString());
			mCaas.run();
			break;
		case R.id.start:
			break;
		case R.id.stop:
			break;
		case R.id.pause:
			break;
		}
	}

}
