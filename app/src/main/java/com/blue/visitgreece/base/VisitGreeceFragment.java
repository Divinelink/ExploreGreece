package com.blue.visitgreece.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.Fragment;

import com.blue.visitgreece.R;

abstract public class VisitGreeceFragment extends Fragment {

    public void showErrorDialog()
    {
        final AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle(getResources().getString(R.string.generalErrorDialogTitle))
                .setMessage(getResources().getString(R.string.generalErrorDialogMessage))
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void showErrorDialog(String title, String message, DialogInterface.OnClickListener clickListener)
    {
        final AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, clickListener)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void showGeneralDialog(String title, String message, AlertDialog.OnClickListener listener, Drawable drawable)
    {
        final AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, listener)
                .setIcon(drawable)
                .show();
    }

}
