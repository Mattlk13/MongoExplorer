package com.innodroid.mongobrowser.ui;

import com.innodroid.mongobrowser.Constants;
import com.innodroid.mongobrowser.Events;
import com.innodroid.mongobrowser.R;
import com.innodroid.mongobrowser.util.UiUtils;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;

public class CollectionEditDialogFragment extends BaseDialogFragment {
	@Bind(R.id.edit_collection_name) TextView mNameView;
	private String mName;

	public CollectionEditDialogFragment() {
		super();
	}
	
    public static CollectionEditDialogFragment newInstance(String name, boolean isNew) {
    	CollectionEditDialogFragment fragment = new CollectionEditDialogFragment();
    	Bundle args = new Bundle();
    	args.putString(Constants.ARG_COLLECTION_NAME, name);
    	args.putBoolean(Constants.ARG_IS_NEW, isNew);
    	fragment.setArguments(args);
    	return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	View view = super.onCreateDialog(R.layout.fragment_collection_name_edit);

    	mName = getArguments().getString(Constants.ARG_COLLECTION_NAME);
    	mNameView.setText(mName);
    	
    	Dialog dialog = UiUtils.buildAlertDialog(view, R.drawable.ic_mode_edit_black, R.string.title_edit_collection, true, 0, new UiUtils.AlertDialogCallbacks() {
			@Override
			public boolean onOK() {
				return save();
			}

			@Override
			public boolean onNeutralButton() {
				return false;
			}
		});


		return dialog;
    }

    private boolean save() {
    	String name = mNameView.getText().toString();

    	if (name.length() == 0) {
    		Toast.makeText(getActivity(), "Required values not provided", Toast.LENGTH_SHORT).show();
    		return false;
    	}

    	if (getArguments().getBoolean(Constants.ARG_IS_NEW))
			Events.postCreateCollection(name);
    	else
    		Events.postRenameCollection(name);

    	return true;
    }
}

