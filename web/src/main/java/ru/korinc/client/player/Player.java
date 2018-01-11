package ru.korinc.client.player;

/**
 * Created by gputintsev on 09.01.18.
 */

public interface Player {

    void play(ErrorListener onError, ProgressListener listener);

    void stop();

    interface ErrorListener {

        void onError();
    }

    interface ProgressListener {

        void onProgress(Double val);
    }
}
