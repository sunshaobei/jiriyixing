package com.jryx.base;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.EditText;

import com.jryx.R;
import com.jryx.lib.SwipeBackActivity;
import com.jryx.lib.sweetdialog.SweetAlertDialog;
import com.jryx.lib.utils.KeyboardUtil;
import com.jryx.lib.utils.PermissionUtils;
import com.jryx.lib.utils.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends SwipeBackActivity {

    private SweetAlertDialog sweetAlertDialog;
    private Unbinder unbinder;

    private final int REQUEST = 200;
    private OnPermissionResult onPermissionResult;
    private String[] permissons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.darkMode(this, Color.TRANSPARENT, 0.2f, isStatusBarTextDackColor());
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (overrideSoftInput() != -1) {
            setFitsSystemWindows(true);
            getWindow().setSoftInputMode(overrideSoftInput());
        }
        super.setContentView(layoutResID);
        unbinder = ButterKnife.bind(this);
    }

    protected void setFitsSystemWindows(boolean b) {
        findViewById(R.id.swipe_layout).setFitsSystemWindows(b);
    }

    public boolean isStatusBarTextDackColor() {
        return true;
    }

    protected int overrideSoftInput() {
        return -1;
    }


    public void showLoading(String str) {
        if (sweetAlertDialog == null) {
            sweetAlertDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        }
        sweetAlertDialog.setContentText(str);
    }

    /**
     * 关闭loading
     */
    public void dismissLoading() {
        if (sweetAlertDialog != null && sweetAlertDialog.isShowing()) {
            sweetAlertDialog.dismissWithAnimation();
        }
    }

    public void success(String str) {
        if (sweetAlertDialog != null && sweetAlertDialog.isShowing()) {
            sweetAlertDialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
            new Handler().postDelayed(sweetAlertDialog::dismissWithAnimation, 1000);
        }
    }

    public void error(String str) {
        if (sweetAlertDialog != null && sweetAlertDialog.isShowing()) {
            sweetAlertDialog.dismissWithAnimation();
        }
    }

    public void warn(String str) {
        if (sweetAlertDialog != null && sweetAlertDialog.isShowing()) {
            sweetAlertDialog.dismissWithAnimation();
        }
    }

    public void checkHasSelfPermissions(OnPermissionResult onPermissionResult, String... permissions) {
        this.onPermissionResult = onPermissionResult;
        this.permissons = permissions;
        if (PermissionUtils.hasSelfPermissions(this, permissions)) {
            onPermissionResult.permissionAllow();
        } else {
            ActivityCompat.requestPermissions(this, permissions, REQUEST);
        }
    }

    public interface OnPermissionResult {
        void permissionAllow();

        void permissionForbid();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST:
                if (PermissionUtils.verifyPermissions(grantResults)) {
                    onPermissionResult.permissionAllow();
                } else {
                    if (!PermissionUtils.shouldShowRequestPermissionRationale(this, this.permissons)) {
                        String permission = PermissionUtils.getDontAskAgainPermission(this, this.permissons);
                        if (!permission.equals("")) {
//                            String title = "您已关闭"+ PermissionEnum.statusOf(permission).getName()+"权限，并选择永不询问，是否前往设置手动开启？";
                            String title = PermissionUtils.PermissionEnum.statusOf(permission).getDenidStr();
                            SweetAlertDialog dialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
                            dialog.setContentText(title);
                            dialog.setCanceledOnTouchOutside(false);
                            dialog.setCancelText("取消");
                            dialog.setConfirmText("去设置");
                            dialog.setCancelClickListener(sweetAlertDialog -> {
                                dialog.dismissWithAnimation();
                            });
                            dialog.setConfirmClickListener(sweetAlertDialog -> {
                                PermissionUtils.openSetting(BaseActivity.this);
                                dialog.dismissWithAnimation();
                            });
                        }
                    } else {
                        String title = PermissionUtils.PermissionEnum.statusOf(PermissionUtils.getShouldShowRequestPermission(this, this.permissons)).getDenidStr();
                        final SweetAlertDialog dialog = new SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setContentText(title);
                        dialog.setCancelText("仍然禁止");
                        dialog.setConfirmText("开启");
                        dialog.setCancelClickListener(sweetAlertDialog -> {
                            dialog.dismissWithAnimation();
                        });
                        dialog.setConfirmClickListener(sweetAlertDialog -> {
                            ActivityCompat.requestPermissions(BaseActivity.this, permissions, REQUEST);
                            dialog.dismiss();
                        });
                        onPermissionResult.permissionForbid();
                    }
                }
                break;
            default:
                break;
        }
    }


    /**
     * 是否正在loading
     *
     * @return true or false
     */
    protected boolean isShowing() {
        if (sweetAlertDialog != null)
            return sweetAlertDialog.isShowing();
        return false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();

    }

    @Override
    public void finish() {
        super.finish();
    }

    public void closeKeyboard() {
        KeyboardUtil.closeKeyboard(this);
    }

    public void openKeyboard(EditText editText) {
        KeyboardUtil.openKeyboard(this, editText);
    }

}
