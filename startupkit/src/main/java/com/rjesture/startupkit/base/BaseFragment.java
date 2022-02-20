package com.rjesture.startupkit.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/**
 * Created by Rjesture on 2/17/2022.
 */
public abstract class BaseFragment<DB extends ViewDataBinding> extends Fragment {
    public DB dataBinding;
    public FragmentActivity mActivity;

    @LayoutRes
    public abstract int getLayoutResId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater,getLayoutResId(),container,false);
        mActivity = getActivity();
        return dataBinding.getRoot();
    }

}












