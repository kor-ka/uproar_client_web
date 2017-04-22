package ru.korinc.j2objc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.korinc.core.Model;
import ru.korinc.j2objc.runtime.rx.AndroidObservable;

public class MainActivity extends AppCompatActivity {


    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = AppCore.sharedCore().getModel();

        final EditText input = (EditText) findViewById(R.id.input);
        final TextView res = (TextView) findViewById(R.id.res);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                AppCore.sharedCore().getModel().searchQuery(s.toString());
            }
        });

        ((AndroidObservable<String>) model.getSearchResults()).getSource()
                .observeOn(AndroidSchedulers.mainThread()).subscribe(res::setText);

    }
}
