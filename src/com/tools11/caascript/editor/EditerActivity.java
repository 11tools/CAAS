package com.tools11.caascript.editor;

import com.tools11.caascript.R;
import com.tools11.caascript.R.layout;
import com.tools11.caascript.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EditerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editer, menu);
		return true;
	}

}
