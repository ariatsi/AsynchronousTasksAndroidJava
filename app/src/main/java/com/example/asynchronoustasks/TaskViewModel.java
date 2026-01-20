package com.example.asynchronoustasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaskViewModel extends ViewModel {

    private final MutableLiveData<String> status = new MutableLiveData<>("Prêt.");
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    private final MutableLiveData<Integer> progressValue = new MutableLiveData<>(0);
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public LiveData<String> getStatus() {
        return status;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<Integer> getProgressValue() {
        return progressValue;
    }

//    public void startLongTask() {
//        isLoading.setValue(true);
//        status.setValue("Travail en cours...");
//
//        executor.execute(() -> {
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            status.postValue("Terminé !");
//            isLoading.postValue(false);
//        });
//    }

    public void startLongTask() {
        isLoading.setValue(true);
        status.setValue("Travail en cours...");
        progressValue.setValue(0);

        executor.execute(() -> {
            for (int p = 0; p <= 100; p += 10) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

                progressValue.postValue(p);
            }

            status.postValue("Terminé !");
            isLoading.postValue(false);
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        executor.shutdownNow();




    }


}



