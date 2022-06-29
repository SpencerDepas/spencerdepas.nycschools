package spencerdepas.nycschools.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import spencerdepas.nycschools.adapter.SchoolAdapter;
import spencerdepas.nycschools.api.API;
import spencerdepas.nycschools.model.School;


public class HomeViewModel extends ViewModel implements SchoolAdapter.SchoolAdapterCallBack {

    private HomeViewModelCallBack callBack;
    public MutableLiveData<List<School>> schools = new MutableLiveData<>();

    public HomeViewModel(HomeViewModelCallBack callBack) {
        this.callBack = callBack;
        getSchoolList();
    }

    private void getSchoolList() {
        API.get().getSchoolList(22).enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, retrofit2.Response<List<School>> response) {
                schools.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.d("", "");
            }
        });
    }

    @Override
    public void onItemClicked(String schoolName) {
        goToSchoolDetail(schoolName);
    }

    private void goToSchoolDetail(String schoolDBN) {
        if (callBack != null) {
            callBack.goToSchoolDetail(schoolDBN);
        }
    }

    public interface HomeViewModelCallBack {

        void goToSchoolDetail(String schoolName);

    }
}