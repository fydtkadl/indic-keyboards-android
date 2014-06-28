package org.iisc.mile.indickeyboards.android.ui;

import org.iisc.mile.indickeyboards.android.R;
import org.iisc.mile.indickeyboards.android.R.id;
import org.iisc.mile.indickeyboards.android.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AboutActivity extends Activity {
	private static final String TAG = AboutActivity.class.getCanonicalName();
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		textView = (TextView) findViewById(R.id.about_text);
		textView.setText(getString(R.string.about_text_description));
	}
	
	public String getVersionInfo() {
		try {
			final PackageInfo info = getPackageInfo(getApplicationContext());
			return "\nVersion: " + info.versionName;
		} catch (final NameNotFoundException e) {
			Log.e(TAG, "Failed to locate package information!");
		}
		return "";
	}

	public PackageInfo getPackageInfo(Context context) throws NameNotFoundException {
		return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
	}

}
