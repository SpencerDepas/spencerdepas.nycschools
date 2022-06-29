package spencerdepas.nycschools.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import spencerdepas.nycschools.model.SATInfo;
import spencerdepas.nycschools.model.School;

public interface SchoolApi {

    //would like to have finished adding auth
    //secret
    //5ufd1yebyidfvoprs2ydlo0665yhartdm41fgbpazxwbeqspkl
//    @Headers({
//        "Accept: application/json",
//        "X-App-Token: bd7edu58wmbkveox9j8o3nfxb"
//    })
    @GET("resource/s3k6-pzi2.json")
    Call<List<School>> getSchoolList(@retrofit2.http.Query("$limit") int limit );


    @GET("resource/f9bf-2cp4.json")
    Call<List<SATInfo>> getSchoolSATInfo(@retrofit2.http.Query("dbn") String dbn );
}
