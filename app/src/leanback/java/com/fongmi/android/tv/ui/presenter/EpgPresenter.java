package com.fongmi.android.tv.ui.presenter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.widget.Presenter;

import com.fongmi.android.tv.bean.Channel;
import com.fongmi.android.tv.bean.Epg;
import com.fongmi.android.tv.databinding.AdapterEpgBinding;

public class EpgPresenter extends Presenter {
    private final EpgPresenter.OnClickListener mListener;

    public EpgPresenter(EpgPresenter.OnClickListener listener) {
        this.mListener = listener;
    }

    public interface OnClickListener {

        void onItemClick(Epg item);

        boolean onLongClick(Epg item);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new ViewHolder(AdapterEpgBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Presenter.ViewHolder viewHolder, @Nullable Object object) {
        Epg item = (Epg) object;
        EpgPresenter.ViewHolder holder = (EpgPresenter.ViewHolder) viewHolder;
        holder.binding.name.setText(item.getEpg());
        setOnClickListener(holder, view -> mListener.onItemClick(item));
        holder.view.setOnLongClickListener(view -> mListener.onLongClick(item));
    }

    @Override
    public void onUnbindViewHolder(@NonNull Presenter.ViewHolder viewHolder) {

    }

    public static class ViewHolder extends Presenter.ViewHolder {

        private final AdapterEpgBinding binding;

        public ViewHolder(@NonNull AdapterEpgBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
