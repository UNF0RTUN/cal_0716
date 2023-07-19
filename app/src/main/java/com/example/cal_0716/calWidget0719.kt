package com.example.cal_0716

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class calWidget0719 : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)

        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }


}

internal fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int){
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object

   //작성 테스트
    val intent = Intent(context,MainActivity::class.java);
   // return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);
    val pInt : PendingIntent = Intent(context,MainActivity::class.java).let{
        intent -> PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_MUTABLE)
    }
    val views = RemoteViews(context.packageName, R.layout.cal_widget0719).apply{
        setOnClickPendingIntent(R.id.appwidget_text,pInt)
    }

    views.setTextViewText(R.id.appwidget_text, widgetText)

    views.setOnClickPendingIntent(R.id.appwidget_text,pInt);

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}