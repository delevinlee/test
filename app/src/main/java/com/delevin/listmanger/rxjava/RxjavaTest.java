package com.delevin.listmanger.rxjava;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxjavaTest {
    public static final String TAG = "Rxjava";
    class MyObservableOnSubscribe implements ObservableOnSubscribe {

        @Override
        public void subscribe(ObservableEmitter emitter) throws Exception {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        }
    }
    public Observable createObserable(){
    MyObservableOnSubscribe myObservableOnSubscribe = new MyObservableOnSubscribe();
        Observable observable = Observable.create(myObservableOnSubscribe);
        return observable;
    }

    public Observer createObserver(){
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Object value) {
                Log.d(TAG, "对Next事件"+ value +"作出响应"  );
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");

            }
        };
        return observer;
    }
    public void line (Observable observable,Observer observer){
        observable.subscribe(observer);
    }
}
