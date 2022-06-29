package spencerdepas.nycschools.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import spencerdepas.nycschools.BR;
import spencerdepas.nycschools.R;
import spencerdepas.nycschools.model.School;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.CustomViewHolder> {

    private List<School> schools;
    private SchoolAdapterCallBack callBack;

    public SchoolAdapter(@NonNull List<School> schools, SchoolAdapterCallBack callBack) {
        this.schools = schools;
        this.callBack = callBack;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_school, parent, false);
        return new CustomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        School item = schools.get(position);
        holder.bind(item);

        setupViewClickEvent(holder.itemView, item);

    }

    private void setupViewClickEvent(final View view, final School item) {
//        final View text = view.findViewById(R.id.cuisine_type);
//        text.setOnClickListener((View v) -> {
//            if (callBack != null) {
//                callBack.onItemClicked(item.getDescription());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (schools != null) {
            return schools.size();
        } else {
            return 0;
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public CustomViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(School item) {
            binding.setVariable(BR.item, item);
            binding.executePendingBindings();
        }
    }

    public interface SchoolAdapterCallBack {
        void onItemClicked(String month);
    }

    public void setCallBack(SchoolAdapterCallBack callBack) {
        this.callBack = callBack;
    }
}
