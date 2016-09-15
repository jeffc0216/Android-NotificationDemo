package idv.ron.notificationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EmailActivity extends AppCompatActivity {
    private TextView tvTitle, tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_activity);
        findViews();
        showEmail();
    }

    private void findViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvContent = (TextView) findViewById(R.id.tvContent);
    }

    private void showEmail() {
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Email email = (Email) bundle.getSerializable("email");
        if (email != null) {
            tvTitle.setText(email.getTitle());
            tvContent.setText(email.getContent());
        }
    }
}
