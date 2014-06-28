package org.iisc.mile.indickeyboards.android.ui;

import org.iisc.mile.indickeyboards.android.R;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

public class HelpActivity extends PreferenceActivity implements OnPreferenceClickListener{
	public static final String HELP_STR_INTENT_KEY = "help_str_id";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.activity_help);
		
		Preference kanInscript = findPreference(getString(R.string.kan_inscript));
		kanInscript.setOnPreferenceClickListener(this);
		Preference kanKaGaPa = findPreference(getString(R.string.kan_kagapa));
		kanKaGaPa.setOnPreferenceClickListener(this);
		
	}

	@Override
	public boolean onPreferenceClick(Preference preference) {
		String key = preference.getKey();
		
		Intent helpDetailsActivity = new Intent(this,HelpDetailsActivity.class);
		if (key.equals(this.getString(R.string.kan_kagapa))) {
			helpDetailsActivity.putExtra(HELP_STR_INTENT_KEY, R.string.kan_kagapa_help_text);
		} else if (key.equals(this.getString(R.string.kan_inscript))) {
			helpDetailsActivity.putExtra(HELP_STR_INTENT_KEY, R.string.kan_inscript_help_text);
		}
		this.startActivity(helpDetailsActivity);
		return true;
	}
}
