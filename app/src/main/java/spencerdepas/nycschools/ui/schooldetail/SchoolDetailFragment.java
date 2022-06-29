package spencerdepas.nycschools.ui.schooldetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import spencerdepas.nycschools.databinding.FragmentSchoolDetailBinding;


public class SchoolDetailFragment extends Fragment implements SchoolDetailViewModel.SchoolDetailViewModelCallBack {

    private SchoolDetailViewModel viewModel;
    private FragmentSchoolDetailBinding binding;
    public static final String SCHOOL_DBN = "SCHOOL_DBN";
    private String schoolDBN = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        createVM();


        binding = FragmentSchoolDetailBinding.inflate(inflater, container, false);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(this);
        View root = binding.getRoot();

        getExtras();
        setVMData();

        return root;
    }

    private void createVM() {
        if (viewModel == null) {
            viewModel = createViewModel();
        }
    }

    private void getExtras() {
        if (getArguments() != null) {
            schoolDBN = getArguments().getString(SCHOOL_DBN);
        }
    }

    private void setVMData() {
        if (viewModel != null && schoolDBN != null) {
            viewModel.setSchoolDBN(schoolDBN);
        }
    }

    private SchoolDetailViewModel createViewModel() {
        return new SchoolDetailViewModel(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void test() {

    }
}