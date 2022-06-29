package spencerdepas.nycschools.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import spencerdepas.nycschools.model.SATInfo;
import spencerdepas.nycschools.model.School;

public interface SchoolApi {


    @GET("resource/s3k6-pzi2.json")
    Call<List<School>> getSchoolList(@retrofit2.http.Query("$limit") int limit );


    @GET("resource/f9bf-2cp4.json")
    Call<List<SATInfo>> getSchoolSATInfo(@retrofit2.http.Query("school_name") String school_name );
}
