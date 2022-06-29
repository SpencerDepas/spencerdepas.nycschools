package spencerdepas.nycschools.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import spencerdepas.nycschools.databinding.FragmentHomeBinding;



public class HomeFragment extends Fragment implements HomeViewModel.HomeViewModelCallBack {

    private HomeViewModel viewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        createVM();


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(this);
        View root = binding.getRoot();

        return root;
    }

    private void createVM() {
        if (viewModel == null) {
            viewModel = createViewModel();
        }
    }

    private HomeViewModel createViewModel() {
        return new HomeViewModel(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void goToPhotoMeasureNail() {

    }
}