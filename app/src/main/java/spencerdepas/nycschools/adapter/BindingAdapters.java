package spencerdepas.nycschools.adapter;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Month;
import java.util.List;

import spencerdepas.nycschools.R;
import spencerdepas.nycschools.model.School;

public class BindingAdapters {

    @BindingAdapter({"schools", "callback"})
    public static void bindSchoolsAdapter(RecyclerView recyclerView,
                                          List<School> schools,
                                          SchoolAdapter.SchoolAdapterCallBack callBack) {


        SchoolAdapter adapter = new SchoolAdapter(schools, callBack);
        bindAdapter(recyclerView, adapter);

    }

    @BindingAdapter("adapter")
    public static void bindAdapter(@NonNull RecyclerView recyclerView, @Nullable RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("layout_vertical")
    public static void bindLayoutManager(@NonNull RecyclerView recyclerView, boolean vertical) {
        int orientation = vertical ? RecyclerView.VERTICAL : RecyclerView.HORIZONTAL;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), orientation, false));
    }

    @BindingAdapter("attendanceRate")
    public static void bindChefTabAdapter(TextView textView,
                                          String attendanceRate) {


        String attendenceRate = textView.getContext().getString(R.string.attendence_rate) + " " + attendanceRate.substring(0, 3);
        textView.setText(attendenceRate);
    }

}
