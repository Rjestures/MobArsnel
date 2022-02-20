package com.rjesture.startupkit.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Created by Rjesture on 2/17/2022.
 */
public abstract class BaseActivity<DB extends ViewDataBinding> extends AppCompatActivity {
    public DB dataBinding;
    public Activity mActivity;
    @LayoutRes
    public abstract int getLayoutResId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        dataBinding = DataBindingUtil.setContentView(mActivity, getLayoutResId());
    }


}
