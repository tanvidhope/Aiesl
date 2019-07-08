package com.example.user.airindiaengg.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.user.airindiaengg.R;


public class TendersFragment extends Fragment {

    private WebView webview;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tenders, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webview = (WebView) view.findViewById(R.id.tendersWebView);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://www.airindia.in/tenders.htm");
        //you can set the title for your toolbar here for different fragments different titles
        //getActivity().setTitle("About Us");
    }

}
