package uk.co.dmdrummond.crapalert;

import android.media.*;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class CrapAlertWidget extends AppWidgetProvider {
    
    public static String ACTION_WIDGET_RECEIVER = "ActionReceiverWidget";


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
        Intent active = new Intent(context, CrapAlertWidget.class);
        
        active.setAction(ACTION_WIDGET_RECEIVER);
        PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context, 0, active, 0);
        remoteViews.setOnClickPendingIntent(R.id.crapwidgetbutton, actionPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);        

    }    


    @Override
    public void onReceive(Context context, Intent intent) {
        
        final String action = intent.getAction();
        if (AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action)) {
            final int appWidgetId = intent.getExtras().getInt( AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
            if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                this.onDeleted(context, new int[] {appWidgetId});
            }
        } else {
          if (intent.getAction().equals(ACTION_WIDGET_RECEIVER)) {
                MediaPlayer mPlay = MediaPlayer.create(context, R.raw.crapalert);
                mPlay.start();
        } 

        super.onReceive(context, intent);

        
    

           
        }
    }

}
