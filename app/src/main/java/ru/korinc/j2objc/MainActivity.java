package ru.korinc.j2objc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ru.korinc.j2objc.runtime.rx.AndroidObservable;
import ru.korinc.runtime.rx.ObservableWrapper;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn = (Button) findViewById(R.id.start_count);

        AppCore.sharedCore().getModel().subscribeCount().observeOnMain()
                .subscribe(new ru.korinc.runtime.rx.Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        btn.setText(s);

                    }
                });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCore.sharedCore().getModel().count(4);

            }
        });
    }
}
