package com.baovt.androidweek7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.baovt.androidweek7.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    public static final String EXTRA_MESSAGE =
            "com.baovt.androidweek7.extra.MESSAGE";
    private String mOrderMessage;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putString(EXTRA_MESSAGE, mOrderMessage);
            NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);

        });

        binding.donut.setOnClickListener(view12 -> {
            mOrderMessage = getString(R.string.donut_order_message);
            displayToast(mOrderMessage);

        });

        binding.iceCream.setOnClickListener(view13 -> {
            mOrderMessage = getString(R.string.ice_cream_order_message);
            displayToast(mOrderMessage);
        });

        binding.froyo.setOnClickListener(view14 -> {
            mOrderMessage = getString(R.string.froyo_order_message);
            displayToast(mOrderMessage);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void displayToast(String message) {
        Toast.makeText(this.getActivity(), message,
                Toast.LENGTH_SHORT).show();
    }

}