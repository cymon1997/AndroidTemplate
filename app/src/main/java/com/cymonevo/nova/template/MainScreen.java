package com.cymonevo.nova.template;

import android.os.Bundle;
import android.util.Log;

import com.cymonevo.nova.template.config.Config;
import com.cymonevo.nova.template.core.Auth;
import com.cymonevo.nova.template.core.Router;
import com.cymonevo.nova.template.core.retrofit.RetrofitClient;
import com.cymonevo.nova.template.layout.HeaderFragment;
import com.cymonevo.nova.template.module.list_repo.ListRepoFragment;
import com.cymonevo.nova.template.service.Provider;
import com.cymonevo.nova.template.service.api.github.GithubAPI;
import com.cymonevo.nova.template.service.db.DBCall;
import com.cymonevo.nova.template.service.db.user.DBResult;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class MainScreen extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!Auth.isAuth(this)) {
            Router.gotoLogin(this);
            finish();
            return;
        }
        setContentView(R.layout.screen_main);
        HeaderFragment header = new HeaderFragment();
        ListRepoFragment fragment = new ListRepoFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.header_container, header)
                .add(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
