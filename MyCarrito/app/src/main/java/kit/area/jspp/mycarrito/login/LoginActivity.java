package kit.area.jspp.mycarrito.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kit.area.jspp.mycarrito.BaseActivity;
import kit.area.jspp.mycarrito.R;
import kit.area.jspp.mycarrito.entities.User;
import kit.area.jspp.mycarrito.login.ui.LoginView;
import kit.area.jspp.mycarrito.main.MainActivity;
import kit.area.jspp.mycarrito.modelo.logics.LUser;

public class LoginActivity extends BaseActivity implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
