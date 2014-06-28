package org.iisc.mile.indickeyboards.android;

import org.iisc.mile.indickeyboards.android.utils.Utils;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class AppUpgradeReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context c, Intent intent) {
		String action = intent.getAction();
		Log.v("IISc Keyboard","App Update received");
		Toast.makeText(c, "App Updated", Toast.LENGTH_LONG).show();
		if (action!=null && action.equals(Utils.APP_UPATED_ACTION_STRING)) {
			SharedPreferences prefs = c.getSharedPreferences(Utils.KEYBOARD_PREFERENCES, c.MODE_PRIVATE);
			boolean notifShown = prefs.getBoolean("app_notification_shown", false);
			if (!notifShown) {
				showHelpNotification(c);				
			}
		}
	}
	
	private void showHelpNotification(Context c) {
		NotificationCompat.Builder notifBuilder  = new NotificationCompat.Builder(c);
		notifBuilder.setContentTitle(c.getString(R.string.ime_name))
        .setContentText(c.getString(R.string.notification_text))
        .setSmallIcon(R.drawable.icon)
        .setAutoCancel(true);
		NotificationManager nm = (NotificationManager)c.getSystemService(c.NOTIFICATION_SERVICE);
		nm.notify(Utils.HELP_NOTIF_ID, notifBuilder.build());
	}

}
