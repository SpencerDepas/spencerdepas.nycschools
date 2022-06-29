package spencerdepas.nycschools.ui;

import static spencerdepas.nycschools.ui.schooldetail.SchoolDetailFragment.SCHOOL_DBN;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import spencerdepas.nycschools.R;


public class BaseActivity extends AppCompatActivity {

    public void goToFragment(int fragmentId) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        navController.navigate(fragmentId);
    }

    public void goToSchoolDetail(String schoolDBN) {
        Bundle bundle = new Bundle();
        bundle.putString(SCHOOL_DBN, schoolDBN);
        goToFragment(R.id.home_to_school_detail, bundle);
    }

    protected void goToFragment(int fragmentId, Bundle bundle) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        navController.navigate(fragmentId, bundle);
    }

}
