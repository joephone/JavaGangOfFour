package com.transcendence.gangoffour.main;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.transcendence.gangoffour.R;
import com.transcendence.gangoffour.log.LogUtils;

/**
 * @author joephone
 * @date 2025/4/15 3:41
 * @description
 * @edition 1.0
 */
public abstract class TitleBarActivity extends BaseActivity {
    private TextView mTitleView;
    private ImageView mBackButton;
    ViewGroup mTitleBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 必须先调用super.onCreate
//        setContentView(getLayoutId()); // 确保布局已加载
        // 设置沉浸式状态栏（需要在setContentView之后调用）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // 调试日志
        LogUtils.d("Layout set, finding title_bar...");

        initTitleBar();
        initViews();
    }

    private void initTitleBar() {
        mTitleBar = findViewById(R.id.title_bar);
        LogUtils.d( "TitleBar found: " + (mTitleBar != null));
        if (mTitleBar != null) {
            mTitleView = mTitleBar.findViewById(R.id.tv_title);
            mBackButton = mTitleBar.findViewById(R.id.iv_back);

            // 默认显示返回按钮并设置点击事件
            setBackButtonVisible(true);
            if (mBackButton != null) {
                mBackButton.setOnClickListener(v -> onBackPressed());
            }

            // 沉浸式适配
            adjustTitleBarForStatusBar();
        } else {
            LogUtils.e( "title_bar not found in layout!");
        }
    }

    private void adjustTitleBarForStatusBar() {
        if (mTitleBar != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            LogUtils.d("mTitleBar != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT");
            mTitleBar.setPadding(
                    mTitleBar.getPaddingLeft(),
                    getStatusBarHeight() + mTitleBar.getPaddingTop(),
                    mTitleBar.getPaddingRight(),
                    mTitleBar.getPaddingBottom()
            );
        } else {
            LogUtils.e( "title_bar not found in layout!");
        }
    }

    public void setTitle(String title) {
        if (mTitleView != null) {
            mTitleView.setText(title);
        } else {
            super.setTitle(title);
        }
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getString(titleId));
    }

    protected void setBackButtonVisible(boolean visible) {
        if (mBackButton != null) {
            mBackButton.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    protected int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}