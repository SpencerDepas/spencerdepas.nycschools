package spencerdepas.nycschools.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spencerdepas.nycschools.adapter.SchoolAdapter;
import spencerdepas.nycschools.api.API;
import spencerdepas.nycschools.model.SATInfo;
import spencerdepas.nycschools.model.School;


public class HomeViewModel extends ViewModel implements SchoolAdapter.SchoolAdapterCallBack {

    private HomeViewModelCallBack callBack;
    public MutableLiveData<List<School>> schools = new MutableLiveData<>();

    public HomeViewModel(HomeViewModelCallBack callBack) {
        this.callBack = callBack;


        getSchoolList();
    }

    private void getSchoolList() {
        API.get().getSchoolList(7).enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, retrofit2.Response<List<School>> response) {
                schools.postValue(response.body());
                Log.d("", "");
                getSchoolSATInfo();
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.d("", "");
            }
        });
    }

    private void getSchoolSATInfo() {
        API.get().getSchoolSATInfo("HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES").enqueue(new Callback<List<SATInfo>>() {
            @Override
            public void onResponse(Call<List<SATInfo>> call, Response<List<SATInfo>> response) {
                Log.d("", "");
            }

            @Override
            public void onFailure(Call<List<SATInfo>> call, Throwable t) {
                Log.d("", "");
            }
        });
    }

    @Override
    public void onItemClicked(String month) {
        Log.d("", "");
    }

    public interface HomeViewModelCallBack {

        void goToPhotoMeasureNail();

    }
}