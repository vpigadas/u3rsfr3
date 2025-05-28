package eu.york.u3rsfr3.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentViewModel extends ViewModel {

    private MutableLiveData<Integer> _counter = new MutableLiveData<>(0);

    public LiveData<Integer> counter = _counter;

    public void incrementCounter(){
        _counter.postValue(_counter.getValue() + 1);
    }

}
