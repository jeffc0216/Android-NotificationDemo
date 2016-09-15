package idv.ron.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final static int NOTIFICATION_ID = 0;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onSendClick(View view) {
        String title = "Hello Android";
        String content = "Welcome to the Android world!";
        Email email = new Email(title, content);
        Intent intent = new Intent(this, EmailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("email", email);
        intent.putExtras(bundle);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setTicker("You got a mail") // ticker text is no longer displayed in Android 5.0
                .setContentTitle(email.getTitle())
                .setContentText(email.getContent())
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    public void onCancelClick(View view) {
        notificationManager.cancel(NOTIFICATION_ID);
    }
}
