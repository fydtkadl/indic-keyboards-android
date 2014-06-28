package org.iisc.mile.indickeyboards.android.ui;

import org.iisc.mile.indickeyboards.android.R;
import org.iisc.mile.indickeyboards.android.R.layout;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.activity_settings);
	}
}
