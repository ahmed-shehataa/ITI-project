package com.ashehata.itifinalproject.ui.upcoming;

import static com.ashehata.itifinalproject.helper.HelperMethods.startScheduling;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ashehata.itifinalproject.R;
import com.ashehata.itifinalproject.helper.HelperMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpcomingFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upcoming, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (!Settings.canDrawOverlays(requireContext())) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:" + requireContext().getPackageName()));
                        startActivityForResult(intent, 1234);
                    } else HelperMethods.startScheduling(requireContext());

                } else {
                    HelperMethods.startScheduling(requireContext());
                }
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234) {
            HelperMethods.startScheduling(requireContext());

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}