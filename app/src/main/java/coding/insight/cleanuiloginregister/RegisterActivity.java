package coding.insight.cleanuiloginregister;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView banner, textViewRol, account, Signupbutton;
    private EditText editTextName, editTextEmail, editTextCountry, editTextCity, editTextPassword;
    private ProgressBar progressBar;
    private CheckBox checkBoxUser, checkBoxSeller;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        changeStatusBarColor();
        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        Signupbutton = (Button) findViewById(R.id.Signupbutton);
        Signupbutton.setOnClickListener(this);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextCountry = (EditText) findViewById(R.id.editTextCountry);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        checkBoxUser = (CheckBox) findViewById(R.id.checkBoxUser);
        checkBoxSeller = (CheckBox) findViewById(R.id.checkBoxSeller);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case  R.id.Signupbutton:
                Signupbutton();
                break;
                
        }

    }

    private void Signupbutton() {

        String email= editTextEmail.getText().toString().trim();
        String password= editTextPassword.getText().toString().trim();
        String name= editTextName.getText().toString().trim();
        String country= editTextCountry.getText().toString().trim();
        String city = editTextCity.getText().toString().trim();


        if(name.isEmpty()){
            editTextName.setError("Este campo es obligatorio");
            editTextName.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextEmail.setError("Este campo es obligatorio");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Este campo es obligatorio");
            editTextPassword.requestFocus();
            recreate();

        }
        if(country.isEmpty()){
            editTextCountry.setError("Este campo es obligatorio");
            editTextCountry.requestFocus();
            return;
        }
        if(city.isEmpty()){
            editTextCity.setError("Este campo es obligatorio");
            editTextCity.requestFocus();
            return;
        }


        }


    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }
    public void onLoginClick(View view){
        startActivity(new Intent(this,LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);
    }


    private class EMAIL_ADRESS {
    }
}