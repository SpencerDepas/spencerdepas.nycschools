package spencerdepas.nycschools.ui.schooldetail;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spencerdepas.nycschools.api.API;
import spencerdepas.nycschools.model.SATInfo;


public class SchoolDetailViewModel extends ViewModel {

    private SchoolDetailViewModelCallBack callBack;
    public MutableLiveData<SATInfo> satInfo = new MutableLiveData<>();
    private String schoolDBN = "";

    public SchoolDetailViewModel(SchoolDetailViewModelCallBack callBack) {
        this.callBack = callBack;
    }

    private void getSchoolSATInfo() {
        API.get().getSchoolSATInfo(schoolDBN).enqueue(new Callback<List<SATInfo>>() {
            @Override
            public void onResponse(Call<List<SATInfo>> call, Response<List<SATInfo>> response) {
                //satInfo.postValue(response.body());
                if(response.body() != null && response.body().size() > 0 && response.body().get(0) != null
                    && response.body().get(0).getSchoolName() != null){
                    satInfo.postValue(response.body().get(0));
                    Log.d("TETETETETET", "TETETETETET: " + response.body().get(0).getSchoolName());
                }

            }

            @Override
            public void onFailure(Call<List<SATInfo>> call, Throwable t) {
                Log.d("", "");
            }
        });
    }

    public void setSchoolDBN(String schoolDBN) {
        this.schoolDBN = schoolDBN;
        getSchoolSATInfo();
    }

    public interface SchoolDetailViewModelCallBack {

        void test();

    }
}