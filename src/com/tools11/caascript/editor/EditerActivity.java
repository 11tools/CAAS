package com.tools11.caascript.editor;

import com.tools11.caascript.R;
import com.tools11.caascript.R.layout;
import com.tools11.caascript.R.menu;
import com.tools11.caascript.caascore.CAASEngine;
import com.tools11.caascript.util.FileUtils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
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
		mRun = (Button)findViewById(R.id.run);
		mStart= (Button)findViewById(R.id.start);
		mStop = (Button)findViewById(R.id.stop);
		mPause= (Button)findViewById(R.id.pause);
		mSave.setOnClickListener(this);
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

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.save:
			mFu.saveStringBufferAsFile(mEditText.getText().toString(),mFu.getExternalStorageDir() + "/caas.txt");
			Toast.makeText(mContext, "save ok", Toast.LENGTH_SHORT).show();
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
