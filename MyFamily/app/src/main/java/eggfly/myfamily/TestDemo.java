package eggfly.myfamily;

import android.view.View;

public class TestDemo {
    private Runnable r = new Runnable() {
        @Override
        public void run() {
            View a = null;
            a.postDelayed(r, 100);
        }
    };

    private void test() {

    }
}
