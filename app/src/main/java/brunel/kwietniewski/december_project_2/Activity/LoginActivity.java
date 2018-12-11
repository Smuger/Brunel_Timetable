package brunel.kwietniewski.december_project_2.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import brunel.kwietniewski.december_project_2.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void signInButtonPushed(View view){
        Toast.makeText(this, "LOGIN IN", Toast.LENGTH_SHORT).show();

        /**
         * TODO: Update fragments to v4
         */
        //startActivity(new Intent(LoginActivity.this, DayTimetableActivity.class));
        startActivity(new Intent(LoginActivity.this, FragmentPagerSupport.class));
    }
}
