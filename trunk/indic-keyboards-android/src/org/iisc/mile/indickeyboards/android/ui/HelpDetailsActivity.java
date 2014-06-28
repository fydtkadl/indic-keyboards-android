package org.iisc.mile.indickeyboards.android.ui;

import org.iisc.mile.indickeyboards.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HelpDetailsActivity extends Activity {
	
	protected void onCreate(Bundle savedState) {
		super.onCreate(savedState);
		setContentView(R.layout.activity_help_details);
		
		Intent callerIntent = getIntent();
		if (callerIntent == null) {
			Log.v("IISc Keyboard","Caller intent null");
			return;
		}
		
		TextView helpTextView = (TextView) findViewById(R.id.help_text_view);
		int helpStrResId = callerIntent.getIntExtra(HelpActivity.HELP_STR_INTENT_KEY, R.string.kan_inscript_help_text);
		
		helpTextView.setText(getString(helpStrResId)+"\n"+getString(R.string.zwnj_help_text));
	}

}
